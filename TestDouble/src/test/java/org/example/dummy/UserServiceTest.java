package org.example.dummy;

import org.example.DummyRepository;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserServiceTest {
    /// * Dummy
    /// * - UserSerivce를 테스트하기 위해 의존성만 주입하기 위해
    /// * - 객체를 지우기 위해 사용, 메서드 호출하지 않음

    @Test
    void testDummy() {
        // Dummy: 단순히 객체를 채우기 위해 사용, 실제로 호출되지 않음
        UserRepository dummy = new DummyRepository();
        UserService userService = new UserService(dummy);
        // 테스트에서 dummy의 메서드는 호출되지 않음

        // 의존하고 있는 구현체의 메소드를 호출하면 안된다. 아래는 잘못된 테스트
//        assertThat(userService.getUserById(1)).isEqualTo("User1");

        // 가짜 객체(테스트 더블) 호출 안하고 테스트 대상(userService)의 인스턴스가 잘 생성되는지만 확인
        assertThat(userService).isNotNull();

        // 의존하고 있는 인터페이스의 구현체의 메소드를 호출하지 않는다.
        // userService가 의존하고 있지 않은 메소드만 호출한다.
        assertThat(userService.notUseUserRepository()).isEqualTo("NotUseUserRepository");
    }

    @Test
    void  우리_코드는_더미의_메소드를_호출했을_때의_테스트_케이스도_만들어놨어요() {
        UserRepository dummy = new DummyRepository();
        UserService userService = new UserService(dummy);
        assertThatThrownBy(() -> {
            userService.getUserId(1);
        })
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
