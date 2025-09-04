package org.example.mokito;

import org.example.DommyRepository;
import org.example.MySQLUserRepository;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Spy
    UserRepository spyRepo = new MySQLUserRepository();

    ///* spy
    ///* - 스파이는 실제 객체를 감싼다 ex> spy(MySqlRepository()), spy(RealRepository())
    ///* 기본적으로 실제 메서드 호출, 일부 스텁가능
    /// - 호출 검증 가능
    /// 실무에서 언제 사용할까?
    /// 실제 객체의 동작을 테스트하고 싶지만, 특정 메서드의 반환값을 제어해야 할때
    /// 메서드 호출 여부나 횟수를 검증하면서로직도 일부 실행하고 싶을 때,
    /// 실제 구현체의 동작이 복합하거나 외부 의존성(예 : DB)이 없어도 동작해야할 떄

    @Test
    void testWithSpy(){
        // 실제 UserRepository 구현체
        UserRepository realRepo = new MySQLUserRepository();

        UserRepository spyRepo = spy(realRepo);

        // 스파이 생성
        UserService userService = new UserService(spyRepo);

        // 테스트 1: 실제 동작 확인 (스파이의 기본 동작은 실제 메서드 호출)
        userService.saveUser("Alice");
        assertThat(userService.getUserId(1)).isEqualTo("Alice");
        assertThat(userService.getUserCount()).isEqualTo(1);

        // 테스트 2: 특정 메서드 스텁처럼 동작 설정
        when(spyRepo.findUserId(2)).thenReturn("Alice"); // 실제 로직실행
        when(spyRepo.countUsers()).thenReturn(0); // 실제 로직실행

        // 테스트 3 : 메서드 호출 검증
        userService.saveUser("Charlie");
        verify(spyRepo,times(2)).saveUser(anyString());
        verify(spyRepo).saveUser("Charlie");

        // 테스트4 : UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }
}
