package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OddEvenTest {


    @Test
    void combineNumbers() {

        ArrayList<Integer> tmp = new ArrayList<>();

        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        tmp.add(5);


        OddEven oddEven = new OddEven();
        ArrayList<String> result = oddEven.getResult(tmp);

        assertNotNull(result, "잘못된 참조");
        assertEquals(result.size(), 5, "배열 크기가 달라졌습니다.");
        result.stream().forEach(System.out::println);
    }

    @Test
    void testOnlyOddEven() {

        ArrayList<Integer> tmp = new ArrayList<>();

        tmp.add(2);
        tmp.add(2);
        tmp.add(2);

        OddEven oddEven = new OddEven();
        ArrayList<String> result = oddEven.getResult(tmp);

        assertNull(result, "배열이 null이 아닙니다.");

    }

    @Test
    void testEmptyArray() {

        ArrayList<Integer> tmp = new ArrayList<>();

        OddEven oddEven = new OddEven();
        ArrayList<String> result = oddEven.getResult(tmp);

        assertTrue(result.isEmpty(), "배열이 비어있지 않습니다.");

    }

    @Test
    void testOnlyOneNumber() {

        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(2);
        OddEven oddEven = new OddEven();
        ArrayList<String> result = oddEven.getResult(tmp);


        assertEquals(result.size(), 1, "배열의 사이즈가 1이 아닙니다.");

    }
}
