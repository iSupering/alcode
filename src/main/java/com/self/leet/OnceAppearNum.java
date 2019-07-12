package com.self.leet;

public class OnceAppearNum {

    public static int singleNumber(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 1, 2, 2,2,1,5,3}));
    }
}
