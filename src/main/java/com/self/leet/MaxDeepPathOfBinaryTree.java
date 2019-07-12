package com.self.leet;

import java.util.LinkedList;
import java.util.List;

public class MaxDeepPathOfBinaryTree {


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return  0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(makeTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
