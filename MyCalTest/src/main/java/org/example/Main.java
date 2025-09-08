package org.example;

public class Main {
    public static void main(String[] args) {
        Cal cal = new Cal();

        int resultSum = cal.add(10,20);
        if (resultSum == 10) {
            System.out.println("통과!!");
        } else {
            System.out.println("실패!!");
        }
    }
}