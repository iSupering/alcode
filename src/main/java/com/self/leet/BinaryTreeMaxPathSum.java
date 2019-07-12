package com.self.leet;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeMaxPathSum {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static Integer max;
    public static int maxPathSum(TreeNode root) {
        max = null;
        return maxPathSumWithMax(root);
    }

    private static int maxPathSumWithMax(TreeNode root) {
        if (root == null) {
            return max;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            maxPathSumWithMax(left);
        }
        if (right != null) {
            maxPathSumWithMax(right);
        }

        int leftVal = left == null ? 0 : left.val;
        int rightVal = right == null ? 0 : right.val;

        int valTmp = Math.max(root.val , root.val + Math.max(leftVal, rightVal));
        int maxTmp = root.val + (leftVal > 0 ? leftVal : 0) + (rightVal > 0 ? rightVal : 0);
        if (max == null) {
            max = maxTmp;
        } else {
            max = Math.max(max, maxTmp);
        }
        root.val = valTmp;
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maxPathSum(makeTree(new Integer[]{1,-2,-3,1,3,-2,null,-1})));
        System.out.println(maxPathSum(makeTree(new Integer[]{-10,9,20,null,null,15,7})));
        System.out.println(maxPathSum(makeTree(new Integer[]{1, 2, 3})));
        System.out.println(maxPathSum(new TreeNode(0)));
        System.out.println(maxPathSum(new TreeNode(-3)));
        System.out.println();
    }

    private static TreeNode makeTree(Integer[] integers) {
        TreeNode root = new TreeNode(integers[0]);
        TreeNode tmp = root;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < integers.length - 1;i++) {
             tmp = list.remove(0);
            if (tmp == null) {
                list.add(null);
                list.add(null);
                i += 1;
                continue;
            }
            if (integers[i] != null) {
                TreeNode left = new TreeNode(integers[i]);
                tmp.left = left;
                list.add(left);
            } else {
                list.add(null);
            }
            if (integers[i + 1] != null) {
                TreeNode right = new TreeNode(integers[i+1]);
                tmp.right = right;
                list.add(right);
            } else {
                list.add(null);
            }
            i++;
        }
        return root;
    }

}
