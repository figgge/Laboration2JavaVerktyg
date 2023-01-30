package com.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String s) {
        char delimiter = ',';
        int sum = 0;
        List<String> negatives = new ArrayList<>();

        if (s.equals(""))
            return 0;
        if (s.substring(0,2).equals("//")){
            delimiter = s.charAt(2);
            s = s.substring(4);
        }
        String[] numbers = s.split("(?<![" + delimiter + "|\\n])\\n|"+ delimiter);
        for (String stringNumber: numbers) {
            if (stringNumber.charAt(0) == '-')
                negatives.add(stringNumber);
            else
                sum += Integer.parseInt(stringNumber);
        }

        StringBuilder message = new StringBuilder("negatives not allowed");
        if (negatives.size() > 0){
            for (String negative: negatives) {
                message.append("\n").append(negative);
            }
            throw new IllegalArgumentException(message.toString());
        }
        return sum;
    }
}
