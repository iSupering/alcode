package com.self.leet;

import java.util.*;

public class LongestPalindrome {

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, LinkedList<Integer>> map = new HashMap<>(32);
        for (int length = s.length() - 1; length >= 0; length--) {
            Character c = s.charAt(length);
            LinkedList<Integer> tmp = map.computeIfAbsent(s.charAt(length), cc -> {
                return new LinkedList<>();
            });
            tmp.add(length);
        }
        int left = 0;
        int right = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            LinkedList<Integer> tmp = map.get(c);
            for (Integer integer : tmp) {
                if (integer <= i) break;
                int j = integer - 1;
                int k = i + 1;
                while (j > k) {
                    if (s.charAt(j) != s.charAt(k)) break;
                    j--;
                    k++;
                }
                if ((j == k || j + 1 == k) && len < (integer - i + 1)) {
                    left = i;
                    right = integer;
                    len = integer - i + 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {

        System.out.println(Solution.longestPalindrome("ac"));
    }


}

class Solution {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] charArr = manacherString(s);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            if (radius[i] > radius[maxIndex]) {
                maxIndex = i;
            }
            max = Math.max(max,radius[i]);
        }
        int left = (maxIndex - radius[maxIndex]+1);
        int right = (maxIndex + radius[maxIndex]);
        return String.valueOf(Arrays.copyOfRange(charArr, left,right)).replace("#","");
    }

    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, LinkedList<Integer>> map = new HashMap<>(32);
        for (int length = s.length() - 1; length >= 0; length--) {
            Character c = s.charAt(length);
            LinkedList<Integer> tmp = map.computeIfAbsent(s.charAt(length), cc -> {
                return new LinkedList<>();
            });
            tmp.add(length);
        }
        int left = 0;
        int right = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            LinkedList<Integer> tmp = map.get(c);
            for (Integer integer : tmp) {
                if (integer <= i) break;
                int j = integer - 1;
                int k = i + 1;
                while (j > k) {
                    if (s.charAt(j) != s.charAt(k)) break;
                    j--;
                    k++;
                }
                if ((j == k || j + 1 == k) && len < (integer - i + 1)) {
                    left = i;
                    right = integer;
                    len = integer - i + 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
