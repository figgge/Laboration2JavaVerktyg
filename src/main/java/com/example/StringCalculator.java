package com.example;

public class StringCalculator {

    public int add(String s) {
        char delimiter = ',';
        int sum = 0;

        if (s.equals(""))
            return 0;
        if (s.substring(0,2).equals("//")){
            delimiter = s.charAt(2);
            s = s.substring(4);
        }
        String[] numbers = s.split("(?<![" + delimiter + "|\\n])\\n|"+ delimiter);
        for (String stringNumber: numbers) {
            sum += Integer.parseInt(stringNumber);
        }
        return sum;
    }
}
