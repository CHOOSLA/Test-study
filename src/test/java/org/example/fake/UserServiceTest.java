package org.example.fake;

import org.example.FakeUserRepository;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository mockRepo;

    @InjectMocks
    UserService userService;


    ///  Fake
    // - 페이크는 실제 동작을 시뮬레이션 하기 위해 만든다.
    // - 실제 구현체에 접근을 하진 않지만 최대한 비슷하게 구현해서 테스트하기 위해.
    // - In-Memory 에서 실제 DB에 접근하는 것 같은 동작은 구현할 수 있다.

    @Test
    void testWithFake() {
        // 페이크 레포지토리 생성
        UserRepository fakeRepo = new FakeUserRepository();
        UserService userService = new UserService(fakeRepo);

        // 테스트 1: 유저 저장 및 조회
        userService.saveUser("Alice");
        assertThat(userService.getUserId(1)).isEqualTo("Alice"); // 저장된 유저 조회
        assertThat(userService.getUserCount()).isEqualTo(1); // 유저 수 확인

        // 테스트 2: 추가 유저 저장 및 조회
        userService.saveUser("Bob");
        assertThat(userService.getUserId(2)).isEqualTo("Bob"); // 두 번째 유저 조회
        assertThat(userService.getUserCount()).isEqualTo(2); // 유저 수 증가

        // 테스트 3: 존재하지 않는 유저 조회
        assertThat(userService.getUserId(3)).isNull(); // 없는 ID는 null 반환

        // 테스트 4: UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }

}
