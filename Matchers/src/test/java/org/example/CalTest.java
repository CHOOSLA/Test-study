package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;


public class CalTest {
    @Test
    void assertJPractice(){
        assertThat(1).isEqualTo(1);
        assertThat(1).isEqualTo(1);
    }

    @Test
    void getSum() {
        Cal cal = new Cal();
        int ret = cal.getSum(10, 20);

        // assertThat(실제대상).isEqualTo(기대값);
        assertThat(ret).isEqualTo(30);

        // 메서드 체이닝
        assertThat(ret)
                // 실패에 대한 설명 기록
                // as()는 메서드 체이닝 맨 앞에 와야 한다.
                .as("안 돼면 이상해요.")
                .isEqualTo(30)
                .isNotEqualTo(40);

        // 수 검증 할 때
        assertThat(ret)
                .isGreaterThan(20)
                .isLessThan(40);

        // 문자열 검사할 때
        assertThat("ABCD")
                .startsWith("AB")
                .endsWith("D")
                .contains("BC");

        // 배열 검사할 때
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(5);


        assertThat(arr).contains(3);
        assertThat(arr).contains(3);
    }
}
