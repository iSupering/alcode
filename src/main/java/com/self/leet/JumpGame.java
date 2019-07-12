package com.self.leet;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int lastIndex = nums.length -1;
        for (int length = nums.length - 2; length >= 0; length--) {
            if (length + nums[length] >= lastIndex || hasSuitebleIndex(length, nums)) {
                nums[length] = 1;
            } else {
                nums[length] = -1;
            }
        }
        return nums[0] == 1;
    }

    private static boolean hasSuitebleIndex(int length, int[] nums) {
        int n = length + nums[length];
        for(int i = length + 1; i <= n ; i ++) {
            if (nums[i] == 1) {
                return true;
            }
        }
        return false;
    }


    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        boolean [] sd = new boolean[nums.length];
        sd[0] = true;
        int canIndex = 0;
        int canTmp;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (sd[i] == false) return false;
            canTmp = i + nums[i];
            if (canTmp > canIndex) {
                canIndex = canTmp;
                if(canIndex >= lastIndex ) {
                    return true;
                }

                markCanIndex(i, canIndex, sd);
            }
        }
        return true;
    }

    private static void markCanIndex(int i, int canIndex, boolean[] sd) {
        for(;i<= canIndex; i++){
            sd[i] = true;
        }
    }

    public static boolean canJump3(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        int canIndex = 0;
        int canTmp;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length && canIndex <= lastIndex; i++) {
            if (canIndex < i) return false;
            canTmp = i + nums[i];
            if (canTmp > canIndex) {
                canIndex = canTmp;
            }
        }
        return canIndex >= lastIndex;
    }

    public static void main(String[] args) {
        System.out.println(canJump3(new int[]{3,2,1,0,4}));
    }
}
