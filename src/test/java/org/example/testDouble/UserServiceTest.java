package org.example.testDouble;

import org.example.StubUserRepository;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserServiceTest {
    // Stub
    // - 테스트 대상 객체가 의존하는 객체의 동작을 미리 정의된 응답을 대체하여 테스트를 단순화
    // - 더미와 달리 스텁은 메서드 호출에 대해 특정 값을 반환하도록 설정
    // - 스텁은 주로 테스트 대상의 동작이(테스트 결과가) 의존 객체의 반환값에 따라 달라질 떄 사용
    ///  실무에서 언제 , 왜 사용할까?
    /// - 테스트 대상 객체가 의존 객체의 반환값에 따라 다른 동작을 할때
    /// - 특정 시나리오(예: 성공, 실패, 예외 등) 시물레이션 할떄
    /// 실제 구현체 RealUserRepository를 대신해 StubUserRepository를 토해
    /// 테스트 시나리오를 정해놓는다. 원하는 시나리오 미리 셋티앟기 위해
    @Test
    void testWithStub(){
        // 스텁 생성
        UserRepository stub = new StubUserRepository();
        UserService userService = new UserService(stub);

        // 테스트1 : getUserById 호출
        assertThat(userService.getUserId(1)).isEqualTo("Alice");
        assertThat(userService.getUserId(2)).isNull();

        // 테스트2 : getUserCount 호출
        assertThat(userService.getUserCount()).isEqualTo(5);

        // 테스트3 : UserService 인스턴스 확ㅇ니
        assertThat(userService).isNotNull();
    }
}
