package com.self.leet;

public class RomanToInt {


//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'V'){
                            sum += 4;
                        } else if (s.charAt(i + 1) == 'X') {
                            sum += 9;
                        } else {
                            sum += 1;
                        }
                    } else {
                        sum += 1;
                    }
                    break;
                case 'X':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'L'){
                            sum += 40;
                        } else if (s.charAt(i + 1) == 'C') {
                            sum += 90;
                        } else {
                            sum += 10;
                        }
                    } else {
                        sum += 10;
                    }
                    break;
                case 'C':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'D'){
                            sum += 400;
                        } else if (s.charAt(i + 1) == 'M') {
                            sum += 900;
                        } else {
                            sum += 100;
                        }
                    } else {
                        sum += 100;
                    }
                    break;
                case 'V':sum += 5;break;
                case 'L':sum += 50;break;
                case 'D':sum += 500;break;
                case 'M':sum += 1000;break;
                default:
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
