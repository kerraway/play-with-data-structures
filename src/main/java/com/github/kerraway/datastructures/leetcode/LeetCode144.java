package com.github.kerraway.datastructures.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 给定一个二叉树，返回它的前序遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * <pre>
 * 1
 *  \
 *   2
 *  /
 * 3
 * <pre/>
 * <p>
 * 输出: [1,2,3]
 *
 * @author kerraway
 * @date 2019/1/24
 */
public class LeetCode144 {

  public List<Integer> preorderTraversalV1(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cursor = stack.pop();
      res.add(cursor.val);

      if (cursor.right != null) {
        stack.push(cursor.right);
      }
      if (cursor.left != null) {
        stack.push(cursor.left);
      }
    }
    return res;
  }

  public List<Integer> preorderTraversalV2(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cursor = root;
    while (cursor != null || !stack.isEmpty()) {
      while (cursor != null) {
        res.add(cursor.val);
        stack.push(cursor);
        cursor = cursor.left;
      }

      cursor = stack.pop();
      cursor = cursor.right;
    }
    return res;
  }

  public List<Integer> preorderTraversalV3(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cursor = root;
    while (cursor != null || !stack.isEmpty()) {
      if (cursor != null) {
        res.add(cursor.val);
        stack.push(cursor);
        cursor = cursor.left;
        continue;
      }

      cursor = stack.pop();
      cursor = cursor.right;
    }
    return res;
  }

  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return String.valueOf(val);
    }
  }

}
