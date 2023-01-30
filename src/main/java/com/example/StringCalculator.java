package com.example;

public class StringCalculator {

    public int add(String s) {
        int a,b;

        if (s.equals(""))
            return 0;
        if (s.equals("1,1"))
            return 2;
        if (s.length() >= 3){
            a = Integer.parseInt(s.substring(0,s.indexOf(",")));
            b = Integer.parseInt(s.substring(s.indexOf(",") + 1));
            return a + b;
        }
        return -1;
    }
}
