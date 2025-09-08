package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }


    @Test
    void getSum() {
        Sum sum = new Sum();
        int result = sum.getSum(10, 20);
        assertEquals(40, result);
    }

    @Test
    void getSum_return_0() {
        Sum sum = new Sum();
        int ret = sum.getSum(-50, 60);
        assertEquals(0, ret);
    }

    @Test
    void 에러메시지출력() {
        int actual = 1; // 실제값
        int expected = 2; // 기대값(예상값)
        String message = "기대값과 실제값이 다릅니다"; // 실패 메시지
        assertEquals(expected, actual, message);
    }

    @Test
    void true_false() {
        int ret = 10;
//        assertTrue(ret == 20); 이런 것은 별로 가독성이 별로
        assertEquals(10, ret); // 얘가 10 이란 것을 보장하는 테스트 코드
    }

    @Test
    void false_test() {
        int ret = 10;
        assertNotEquals(20, ret);
    }

    @Test
    void ArrayList_비교() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(1);
        arr2.add(2);

        assertIterableEquals(arr1, arr2);
    }

    @Test
    void getSum_with_minus_ints() {
        // given : 테스트 대상이 "주어지고"
        Sum sum = new Sum();

        // when : 결과를 수행했을 "때"
        int ret = sum.getSum(-50, -50);

        // then : "그렇다면" 어떤 결과가 나와야 하는가
        assertEquals(100, ret);

        // GWT : Good With Test
    }

    @Test
    void loop_test() {
        assertNull(null); // actual이 null일 때만 통과
//        assertNotNull(null); // actual이 null이 아닐 때만 통과
    }

    @Test
    @Disabled
    void failTest() {
        fail("이 아이는 무조건 통과 못 합니다.");
    }

    @Test
    void nullPointException() {
        assertThrows(NullPointerException.class, () -> {
            ArrayList<Integer> arr = null;
            int ret = arr.get(0);
        });
    }

    @Test
    void nullPointExceptionNotThrows() {
        // 오류를 내보내지 않아야 통과되는 테스트
        assertDoesNotThrow(() -> {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("아무거나");
            String ret = arr.get(0);
        });
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MICROSECONDS)
    void long_loop() {
        int sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum = sum % 10 + i;
        }

        assertEquals(sum, 100000000);
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }


}