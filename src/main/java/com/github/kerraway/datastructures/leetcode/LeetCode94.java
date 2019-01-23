package com.github.kerraway.datastructures.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 * 给定一个二叉树，返回它的中序遍历。
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
 * 输出: [1,3,2]
 *
 * @author kerraway
 * @date 2019/1/23
 */
public class LeetCode94 {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cursor = root;
    while (cursor != null || !stack.isEmpty()) {
      while (cursor != null) {
        stack.push(cursor);
        cursor = cursor.left;
      }

      cursor = stack.pop();
      res.add(cursor.val);
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
  }

}
