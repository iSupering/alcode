package com.self.leet.model;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    // Definition for a binary tree node.
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode makeTree(Integer[] integers) {
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
