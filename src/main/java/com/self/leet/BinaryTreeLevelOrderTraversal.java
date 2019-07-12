package com.self.leet;

import com.self.leet.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        qu.offer(null);
        TreeNode tmp;
        List<Integer> x = new ArrayList<>();
        while (qu.size() > 1) {
            tmp = qu.poll();
            if (tmp == null) {
                result.add(x);
                x = new ArrayList<>();
                qu.offer(null);
                continue;
            }
            x.add(tmp.val);
            if (tmp.left != null) {
                qu.offer(tmp.left);
            }
            if (tmp.right != null) {
                qu.offer(tmp.right);
            }
        }
        result.add(x);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(levelOrder(TreeNode.makeTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
