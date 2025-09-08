# Test-study

테스트 더블(Test Double) 개념을 실습하기 위한 예제 모음입니다.  
`UserService`와 `UserRepository`를 중심으로 더미·스텁·페이크·목·스파이를 단계별로 사용해 보며 각 역할을 정리해 둡니다.

## 프로젝트 개요
- **빌드 도구**: Gradle  
- **테스트 라이브러리**: JUnit 5, Mockito, AssertJ


- **구조**
  - `src/main/java/org/example` : 서비스 및 더블 구현체
  - `src/test/java/org/example` : 더블을 이용한 JUnit 테스트

## Test Double 정리

|종류|설명|예시|
|---|---|---|
|**Dummy**|의존성 자리만 채우는 객체. 메서드를 호출하면 예외가 발생하도록 구현해 호출하지 않음을 보장합니다.|`DommyRepository`는 모든 메서드에서 `UnsupportedOperationException`을 던집니다. 테스트에서는 단순 주입 후, 레포지토리를 전혀 사용하지 않는 시나리오를 검증합니다|
|**Stub**|미리 정해 둔 값을 반환하도록 만든 객체. 의존 객체의 응답에 따라 분기되는 로직을 단순화할 때 사용합니다.|`StubUserRepository`는 ID 1에만 "Alice"를 반환하고 사용자 수를 항상 5로 고정합니다. 해당 값을 기반으로 `UserService`의 동작을 검증합니다|
|**Fake**|실제 구현을 흉내 내는 간단한 대체품. 예제에서는 메모리 기반 Map을 이용해 DB 없이 저장/조회가 가능하도록 합니다.|`FakeUserRepository`는 `HashMap`으로 사용자 정보를 보관합니다. 저장·조회·카운트가 정상 동작하는지 테스트합니다|
|**Mock**|행위 검증을 위한 가짜 객체. 어떤 메서드가 어떤 인자로 몇 번 호출되었는지 확인할 수 있습니다.|Mockito의 `mock`으로 만든 레포지토리에 대해 반환값을 정의하고 호출 횟수를 검증합니다|
|**Spy**|실제 객체를 감싼 뒤 일부 메서드만 스텁하고, 나머지는 실제 동작을 수행하도록 하는 객체입니다.|`MySQLUserRepository`를 `spy`로 감싸 일부 메서드는 `when(...).thenReturn()`으로 제어하고, 저장 호출 횟수 등을 검증합니다|

## 실행 방법
```bash
./gradlew test
```
Gradle이 JUnit 플랫폼을 사용하도록 설정되어 있어 명령 한 번으로 모든 테스트 더블 예제를 실행해 볼 수 있습니다.

---

이 README는 더블의 개념을 학습하기 위한 노트 형식으로, 각 사례의 핵심 요점과 관련 소스 위치를 빠르게 확인할 수 있도록 구성되어 있습니다.

## 실제 예제 코드 바로가기

아래 링크를 통해 이 문서에서 설명하는 모든 테스트 더블(Dummy, Stub, Mock, Spy, Fake)의 실제 구현 예제를 직접 확인할 수 있습니다.

➡️ **[UserServiceUnitTest.java 바로가기](src/test/java/org/example/integratedTest/UserServiceUnitTest.java)**
