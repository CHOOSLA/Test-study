package org.example.integratedTest;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// =================================================================================================
// 1. Dummy Object (더미 객체) 테스트
// =================================================================================================
// 의도:
// 'Dummy'는 가장 단순한 테스트 더블입니다. 객체는 필요하지만, 그 객체의 실제 기능은 전혀 사용되지 않을 때 사용됩니다.
// 이 테스트에서는 UserService 객체를 생성하기 위해 UserRepository 타입의 객체가 필요하지만,
// 테스트 대상 메소드인 `userService.isNotNull()` (실제로는 `returnUserServiceGreeting` 같은 메소드를 테스트해야 함)는
// 주입된 `dummyRepo`를 전혀 사용하지 않습니다. 따라서 `dummyRepo`는 단순히 자리만 채우는 '더미' 역할을 합니다.
@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {
    // @Mock: Mockito가 UserRepository의 가짜 구현체(Mock 객체)를 생성합니다.
    // 이 테스트에서는 아무런 동작도 하지 않으므로 'Dummy'로 사용됩니다.
    @Mock
    UserRepository dummyRepo;

    // @InjectMocks: `@Mock`으로 생성된 `dummyRepo` 객체를 `userService`의 생성자에 주입하여 `userService` 객체를 생성합니다.
    @InjectMocks
    UserService userService;

    @Test
    void testDummy() {
        // `userService` 객체가 성공적으로 생성되었는지(null이 아닌지) 확인합니다.
        // 이 과정에서 `dummyRepo`는 생성자 인자로 전달되기만 할 뿐, 어떠한 메소드 호출도 받지 않습니다.
        assertThat(userService).isNotNull();
    }
}

// =================================================================================================
// 2. Stub (스텁) 테스트
// =================================================================================================
// 의도:
// 'Stub'은 테스트 중에 호출되었을 때, 미리 정해진 답변(결과)을 반환하도록 만들어진 객체입니다.
// `when(...).thenReturn(...)` 구문을 사용하여 "어떤 메소드가 호출되면, 어떤 값을 반환해라"라고 미리 지정합니다.
// 이를 통해 특정 상황(예: DB에서 특정 데이터를 찾았을 때)을 시뮬레이션하고, 그에 따른 시스템의 상태를 검증(State-based Testing)합니다.
@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest2 {
    @Mock
    UserRepository stubRepo;

    @InjectMocks
    UserService userService;

    @Test
    void testStub() {
        // Stubbing: `stubRepo.findById(1L)`가 호출되면 `Optional<User>` 객체를 반환하도록 설정합니다.
        when(stubRepo.findById(1L)).thenReturn(Optional.of(new User(1L, "Alice")));
        // Stubbing: `stubRepo.count()`가 호출되면 `1L`을 반환하도록 설정합니다.
        when(stubRepo.count()).thenReturn(1L);

        // `userService`의 메소드를 호출하면, 내부적으로 `stubRepo`의 메소드를 호출하고 미리 정의된 값을 받아옵니다.
        // `assertThat`을 사용하여 반환된 값(상태)이 우리가 예상한 값과 일치하는지 검증합니다.
        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");
        assertThat(userService.getUserCount()).isEqualTo(1);
    }
}

// =================================================================================================
// 3. Spy (스파이) 테스트
// =================================================================================================
// 의도:
// 'Spy'는 실제 객체를 감싸는 래퍼(wrapper) 객체입니다. 기본적으로는 실제 객체의 로직을 그대로 사용하지만,
// Stub처럼 특정 메소드의 동작만 선택적으로 변경할 수 있습니다. 실제 객체의 동작과 가짜 동작을 섞어서 테스트하고 싶을 때 유용합니다.
@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest3 {
    // @Spy: 실제 객체를 감싸는 Spy 객체를 생성합니다. `new InMemoryUserRepository()`가 실제 객체에 해당합니다.
    @Spy
    UserRepository spyRepo = new InMemoryUserRepository();

    @InjectMocks
    UserService userService;

    @Test
    void testSpy() {
        // 1. 실제 메소드 호출: `spyRepo`의 `saveUser`가 호출됩니다. (Spy는 명시적으로 Stubbing하지 않으면 실제 객체의 메소드를 호출)
        userService.saveUser("Alice");
        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");

        // 2. 일부 메소드만 Stubbing: `findById(2L)`가 호출될 때만 가짜 값을 반환하도록 설정합니다.
        when(spyRepo.findById(2L)).thenReturn(Optional.of(new User(2L, "Bob")));
        assertThat(userService.getUserNameById(2L)).isEqualTo("Bob");

        // 3. 행위 검증: `save` 메소드가 호출되었는지 검증합니다. Spy 객체도 Mock처럼 행위 검증이 가능합니다.
        verify(spyRepo).save(any(User.class));
    }
}

// =================================================================================================
// 4. Mock (목) 테스트
// =================================================================================================
// 의도:
// 'Mock' 객체는 행위 기반 테스트(Behavior-based Testing)에 주로 사용됩니다.
// Stub처럼 미리 정의된 값을 반환할 수도 있지만, Mock의 핵심은 특정 메소드가 '올바른 인자'로, '정확한 횟수'만큼 호출되었는지를 검증하는 것입니다.
// 즉, "결과값이 무엇인가" 보다는 "올바르게 상호작용했는가"에 초점을 맞춥니다.
@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest4 { // 클래스 이름이 중복되어 임의로 변경했습니다.
    @Mock
    UserRepository mockRepo;

    @InjectMocks
    UserService userService;

    @Test
    void testMock() {
        // 상태 기반 테스트를 위한 Stubbing (Mock 객체도 Stub처럼 사용 가능)
        when(mockRepo.findById(1L)).thenReturn(Optional.of(new User(1L, "Alice")));
        when(mockRepo.count()).thenReturn(1L);

        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");
        assertThat(userService.getUserCount()).isEqualTo(1);

        // 행위 기반 테스트를 위한 로직 호출
        userService.saveUser("Bob");
        // 행위 검증(Verification): `mockRepo`의 `save` 메소드가 `User` 타입의 어떤 객체를 인자로 받아 호출되었는지 검증합니다.
        // 이것이 Mock 테스트의 핵심입니다.
        verify(mockRepo).save(any(User.class));
    }
}

// =================================================================================================
// 5. Fake Object (페이크 객체)를 사용한 통합 테스트
// =================================================================================================
// 의도:
// 'Fake'는 실제 구현을 단순화하여 대체한 객체입니다. 실제 DB 대신 H2 같은 인메모리(In-memory) DB를 사용하는 것이 대표적인 예입니다.
// `@DataJpaTest`는 Spring Boot에서 제공하는 기능으로, JPA 관련 설정만 로드하고 인메모리 DB를 'Fake' DB로 사용하여 테스트 환경을 구성합니다.
// 이는 단위 테스트보다는 여러 컴포넌트(UserService, UserRepository, DB)가 함께 동작하는 것을 검증하는 '통합 테스트'에 가깝습니다.
@DataJpaTest
class UserServiceIntegrationTest {
    // @Autowired: Spring의 DI(의존성 주입) 컨테이너가 `@DataJpaTest`에 의해 생성된 UserRepository 구현체(Fake)를 주입합니다.
    @Autowired
    UserRepository userRepository;

    UserService userService;

    @BeforeEach
    void setUp() {
        // 주입받은 Fake Repository를 사용하여 UserService를 생성합니다.
        userService = new UserService(userRepository);
    }

    @Test
    void testH2() {
        // Fake DB(H2)에 데이터를 저장하고, 다시 조회하여 올바르게 동작하는지 검증합니다.
        // 여러 메소드 호출에 걸쳐 상태가 유지되는 것을 확인할 수 있습니다.
        userService.saveUser("Alice");
        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");
        assertThat(userService.getUserCount()).isEqualTo(1);
    }
}