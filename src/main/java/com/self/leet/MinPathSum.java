package com.self.leet;

public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        Integer tmp;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                tmp = i - 1 >= 0 ? grid[i - 1][j] : null;
                tmp = j - 1 >= 0 && ( tmp == null || tmp > grid[i][j - 1]) ? grid[i][j - 1] : tmp;
                grid[i][j] += tmp == null ? 0 : tmp;
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] test = new int[3][3];
        int[] a = new int[]{1, 3, 1};
        int[] b = new int[]{1, 5, 1};
        int[] c = new int[]{4, 2, 1};
        test[0] = a;
        test[1] = b;
        test[2] = c;
        System.out.println(minPathSum(test));
    }
}
