package com.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String s) {
        String delimiter = ",";
        int sum = 0;
        List<String> negatives = new ArrayList<>();

        if (s.equals(""))
            return 0;

        if (s.startsWith("//")){
            char delimiter1 = ',';
            char delimiter2 = ':';

            if (s.indexOf("[") == 2) {
                delimiter1 = s.charAt(3);
                if (s.substring(4).contains("["))
                    delimiter2 = s.charAt(s.lastIndexOf("[")+1);
            }else
                delimiter1 = s.charAt(2);
            s = s.substring(s.indexOf("\n") + 1);

            delimiter = "[" + delimiter1 + "|" + delimiter2 + "]";
        }

        String[] numbers = s.split("(?<![" + delimiter + "|\\n])\\n|"+ delimiter + "+");
        for (String stringNumber: numbers) {
            if (stringNumber.charAt(0) == '-')
                negatives.add(stringNumber);
            else if (stringNumber.length() > 3)
                continue;
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
