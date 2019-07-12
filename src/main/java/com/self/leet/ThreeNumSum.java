package com.self.leet;

import java.util.*;

public class ThreeNumSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Map<Integer,List<List<Integer>>> sumMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<String> distinctSet = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tmp = sumMap.computeIfAbsent(nums[i] * -1, (a) -> {
                return new ArrayList<List<Integer>>();
            });
            if (!tmp.isEmpty()) {
                for (List<Integer> integers : tmp) {
                    List<Integer> res = new ArrayList<>(3);
                    res.addAll(integers);
                    res.add(nums[i]);
                    Collections.sort(res);
                    String key = res.get(0) + "_" + res.get(1) + "_" + res.get(2);
                    if (!distinctSet.contains(key)) {
                        result.add(res);
                        distinctSet.add(key);
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                List<List<Integer>> tmpGenerate = sumMap.computeIfAbsent(nums[i] + nums[j] , (a) -> {
                    return new ArrayList<List<Integer>>();
                });
                List<Integer> generate = new ArrayList<>(2);
                generate.add(nums[i]);
                generate.add(nums[j]);
                tmpGenerate.add(generate);
            }
        }
        return result;
    }



    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        testgc();
    }

    private static void testgc() {
        while (true) {
            List<List<String>> s = new ArrayList<>(10000);
            for (int i = 0; i < 10000; i++) {
                s.add(new ArrayList<String>(100));
            }
        }
    }
}
