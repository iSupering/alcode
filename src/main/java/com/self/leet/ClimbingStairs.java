package com.self.leet;

public class ClimbingStairs {

    public static int climingStair(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }


}
