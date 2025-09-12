# Test-study

테스트 주도 개발(TDD)과 다양한 테스트 더블을 연습하기 위해 만든 예제 모음입니다. 각 폴더는 독립적인 Gradle 또는 Maven 프로젝트로 구성되어 있으며 JUnit 5, Mockito, AssertJ 등을 이용해 테스트 작성법을 익힐 수 있습니다.

## 폴더 구성
- `TestDouble` – `UserService`와 `UserRepository`를 활용해 **Dummy**, **Stub**, **Fake**, **Mock**, **Spy** 의 차이를 단계별로 실습합니다.
- `TDDBasic` – 은행 계좌, 계산기, 피보나치 수열 등 간단한 문제를 TDD로 해결한 예제입니다.
- `Matchers` – AssertJ 및 Mockito의 다양한 matcher 사용법을 연습합니다.
- `MyFirstJUnitTest` – JUnit 5를 이용한 기초 단위 테스트 모음입니다.
- `Practice01` – 곱셈 등 간단한 예제를 통해 테스트 코드 작성을 연습합니다.
- `MyCalTest` – 콘솔 기반 계산기 예제입니다.
- `SpringBootTDD`, `voteRestApi`, `VoteRestApiAndroid` 등 – Spring Boot와 Android 환경에서의 TDD 실습 결과물입니다.

## TestDouble 모듈 정리

| 종류 | 설명 | 예시 |
| --- | --- | --- |
| **Dummy** | 필요한 의존성 자리를 채우기만 하는 객체로, 메서드가 호출되면 `UnsupportedOperationException`을 던집니다. | `DummyRepository` |
| **Stub** | 미리 준비한 값을 반환해 분기 로직을 단순화합니다. | `StubUserRepository`는 ID가 1일 때만 "Alice"를 반환하고 전체 사용자 수를 5로 고정합니다. |
| **Fake** | 실제 구현을 단순하게 흉내 낸 대체품입니다. | `FakeUserRepository`는 `HashMap` 기반으로 사용자 정보를 저장·조회·카운트합니다. |
| **Mock** | 행위(호출 횟수, 인자 등)를 검증하기 위한 객체입니다. | Mockito로 만든 `UserRepository` mock에서 반환값을 정의하고 호출 횟수를 검증합니다. |
| **Spy** | 실제 객체를 감싸 일부 메서드만 스텁하고 나머지는 실제 동작을 수행하게 합니다. | `MySQLUserRepository`를 spy로 감싸 `when(...).thenReturn()`으로 특정 메서드를 제어하고 `save` 호출 횟수를 확인합니다. |

### 실행 방법
각 서브 프로젝트 디렉터리에서 다음 명령으로 테스트를 실행할 수 있습니다.

```bash
./gradlew test
```

`TestDouble` 모듈의 통합 예제는 다음 테스트 파일에서 확인할 수 있습니다.

➡️ **[UserServiceUnitTest.java](TestDouble/src/test/java/org/example/integratedTest/UserServiceUnitTest.java)**

---

이 문서는 학습 노트 형식으로 구성되어 있어 각 테스트 더블의 핵심 요점과 소스 위치를 빠르게 확인할 수 있습니다.

