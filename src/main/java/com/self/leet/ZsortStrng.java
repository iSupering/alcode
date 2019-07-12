package com.self.leet;

public class ZsortStrng {

    public static String zSort(String s,int n){
        if (n <= 0 || s == null || s.isEmpty()) {
            return "";
        }
        if (n == 1) {
            return s;
        }
        int r = (n - 1) *2;
        int index,tmp, j,i2;
        boolean lineTmp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            index = i;
            j = 1;
            lineTmp = true;
            i2 = i + i;
            while(lineTmp) {
                lineTmp = false;

                if (i2 > 0 && i2 < r && (tmp = index - i - i) > 0 && tmp < s.length()) {
                    sb.append(s.charAt(tmp));
                    lineTmp = true;
                }
                if (index < s.length()) {
                    sb.append(s.charAt(index));
                    lineTmp = true;
                }
                index += r;
                j++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(zSort("123456789abc", 4));
    }
}
