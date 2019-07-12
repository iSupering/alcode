package com.self.leet;

public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int i = 0;
        int k = s.length() - 1;
        while (i < k) {
            if (s.charAt(i) != s.charAt(k)) return false;
            i++;
            k--;
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char curr = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != curr) {
                    break;
                }
            }
            index = i;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
