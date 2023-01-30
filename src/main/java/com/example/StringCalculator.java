package com.example;

public class StringCalculator {

    public int add(String s) {
        int a,b;
        String[] numbers = s.split(",");
        int sum = 0;

        if (s.equals(""))
            return 0;
        for (String stringNumber: numbers) {
            sum += Integer.parseInt(stringNumber);
        }
        return sum;
    }
}
