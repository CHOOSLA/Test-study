package org.example.mock;

import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    ///  Mock
    // - 목은 스파이와 비슷하게 호출 검증 등이 가능하다.
    // - 완전히 가짜 객체 UserRepository 인터페이스를 mock()으로 묶어서 주입한다.
    /// 실무에서 언제 사용할까?
    /// - 테스트 대상 객체가 의존 객체의 특정 메서드를 정확히 호출하는지, 올바른 인자로 호출하는지 확인할 때

    @Test
    void testWithMock() {
        // 목 생성 : 실제 구현체 없이 가짜 UserRepository
        UserRepository mockRepo = mock(UserRepository.class);

        // UserService 인스턴스 생성
        UserService userService = new UserService(mockRepo);

        // 목 동작 정의 (스텁처럼)
        when(mockRepo.findUserId(1)).thenReturn("Alice");
        when(mockRepo.findUserId(2)).thenReturn("Bob");
        when(mockRepo.countUsers()).thenReturn(1);

        // 테스트 1: getUserId 호출
        assertThat(userService.getUserId(1)).isEqualTo("Alice"); // saveUser("Charlie") 1번
        assertThat(userService.getUserId(2)).isEqualTo("Bob"); // saveUser 총 1번 호출

        // 테스트 2: getUserCount 호출
        assertThat(userService.getUserCount()).isEqualTo(1); // 모크 반환값

        // 테스트 3: 메서드 호출 검증
        userService.saveUser("Charlie");
        verify(mockRepo, times(1)).saveUser("Charlie"); // saveUser("Charlie") 1번 호출
        verify(mockRepo, times(1)).saveUser(anyString()); // saveUser 총 1번 호출

        // 테스트 4: 추가 검증 - 다른 인자로 호출되지 않음
        verify(mockRepo, never()).saveUser("Alice");

        // 테스트 5: UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }
}
