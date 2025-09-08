package org.example;

import java.util.ArrayList;

public class OddEven {
    public ArrayList<String> getResult(ArrayList<Integer> nums) {
        ArrayList<String> result = new ArrayList<>();

        int countOdd = 0;
        int countEven = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                result.add("O");
                ++countOdd;
            } else {
                result.add("X");
                ++countEven;
            }
        }

        if (result.size() != 1) {
            if ((countOdd > 0 && countEven == 0) || (countOdd == 0 && countEven > 0)) {
                result = null;
            }
        }


        return result;
    }
}
