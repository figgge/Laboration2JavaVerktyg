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

        if (s.startsWith("//")) {
            delimiter = getDelimiter(s);
            s = s.substring(s.indexOf("\n") + 1);
        }

        String[] numbers = s.split("(?<![" + delimiter + "|\\n])\\n|" + delimiter + "+");

        sum = getSum(sum, negatives, numbers);

        throwExceptionIfNegatives(negatives);
        return sum;
    }

    private static void throwExceptionIfNegatives(List<String> negatives) {
        StringBuilder message = new StringBuilder("negatives not allowed");
        if (negatives.size() > 0) {
            for (String negative : negatives) {
                message.append("\n").append(negative);
            }
            throw new IllegalArgumentException(message.toString());
        }
    }

    private static int getSum(int sum, List<String> negatives, String[] numbers) {
        for (String stringNumber : numbers) {
            if (stringNumber.charAt(0) == '-')
                negatives.add(stringNumber);
            else if (stringNumber.length() > 3)
                continue;
            else
                sum += Integer.parseInt(stringNumber);
        }
        return sum;
    }

    private static String getDelimiter(String s) {
        String delimiter;
        String delimiter1 = ",";
        String delimiter2 = ":";

        if (s.indexOf("[") == 2) {
            delimiter1 = s.substring(3, s.indexOf("]"));
            if (s.substring(4).contains("["))
                delimiter2 = s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"));
        } else
            delimiter1 = s.substring(2, 2);

        delimiter = "[" + delimiter1 + "|" + delimiter2 + "]";
        return delimiter;
    }
}
