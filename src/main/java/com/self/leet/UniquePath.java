package com.self.leet;

public class UniquePath {

    /*
     * 方法一：动态规划
     */
    public static int uniquePaths(int m, int n) {
        //不合法校验
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //初始化一个m*n的数组，存每个格子的可达路径数
        int [][] sd = new int[m][n];
        //第一个格子的初始可达方式为1
        sd[0][0] = 1;
        //填充整个数组
        //重点： 坐标为i,j的格子的可达路径数为其上方格子的可达路径数加左方的格子的可达路径数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //若i,j格子存在上方格子则其可达路径数需要加上上方格子的可达路径数
                if (i-1 >= 0) {
                    sd[i][j] += sd[i-1][j];
                }
                //若i,j格子存在左方格子则其可达路径数需要加上左方格子的可达路径数
                if (j-1 >= 0) {
                    sd[i][j] += sd[i][j -1];
                }
            }
        }
        //返回 第m,n格子的可达路径数，即为结果
        return sd[m -1][n-1];
    }

    /*
     * 方法二：在方法一上，进行空间优化的动态规划
     */
    public static int uniquePaths2(int m, int n) {
        //不合法校验
        if (m <= 0 || n <= 0) {
            return 0;
        }
        /*
        初始化一个m个元素数组，用来存第一行的的每个格子的可达不同路径数
        注：我们发现，其实每一行的数组计算好可达路径数后，只有下一行使用到，并且，我们的目标位置在右下角
        所以 我们可以实例化一行，重复使用
         */
        int [] sd = new int[m];
        //第一行第1个位置的可达路径为1
        sd[0] = 1;
        //因为是行复用，所以我们按行方式进行遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /**
                 * 当前列，在未求可达路径前，已经是上一行相同位置的可达路径数，
                 * 若存在左边的格子，则加上左边格子的可达路径数，即为当前行，当前位置可达路径数
                 */
                if (j-1 >= 0) {
                    sd[j] += sd[j -1];
                }
            }
        }
        return sd[m -1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }
}
















