package com.github.kerraway.datastructures.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * <p>
 * 给定一个二叉树，返回它的后序遍历。
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
 * 输出: [3,2,1]
 *
 * @author kerraway
 * @date 2019/1/23
 */
public class LeetCode145 {

  /**
   * Use TagNode to record whether the TreeNode has been visited.
   *
   * @param root
   * @return List<Integer>
   */
  public List<Integer> postorderTraversalV1(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TagNode> stack = new Stack<>();
    TreeNode cursor = root;
    while (cursor != null || !stack.isEmpty()) {
      while (cursor != null) {
        stack.push(new TagNode(cursor));
        cursor = cursor.left;
      }

      TagNode tagNode = stack.pop();
      cursor = tagNode.node;
      if (!tagNode.isVisited) {
        tagNode.isVisited = true;
        stack.push(tagNode);
        cursor = cursor.right;
      } else {
        res.add(cursor.val);
        cursor = null;
      }
    }
    return res;
  }

  /**
   * Use two stacks, reverse preorder traversal.
   *
   * @param root
   * @return List<Integer>
   */
  public List<Integer> postorderTraversalV2(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> preorderRes = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cursor = stack.pop();
      preorderRes.push(cursor.val);

      if (cursor.left != null) {
        stack.push(cursor.left);
      }
      if (cursor.right != null) {
        stack.push(cursor.right);
      }
    }
    while (!preorderRes.isEmpty()) {
      res.add(preorderRes.pop());
    }
    return res;
  }

  /**
   * Use two stacks, reverse preorder traversal.
   *
   * @param root
   * @return List<Integer>
   */
  public List<Integer> postorderTraversalV3(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Stack<TreeNode> preorderRes = new Stack<>();

    TreeNode cursor = root;
    while (cursor != null || !stack.isEmpty()) {
      if (cursor != null) {
        stack.push(cursor);
        preorderRes.push(cursor);
        cursor = cursor.right;
      } else {
        cursor = stack.pop();
        cursor = cursor.left;
      }
    }
    List<Integer> res = new ArrayList<>();
    while (!preorderRes.isEmpty()) {
      res.add(preorderRes.pop().val);
    }
    return res;
  }

  /**
   * Use a previous pointer to record the last visited node.
   *
   * @param root
   * @return List<Integer>
   */
  public List<Integer> postorderTraversalV4(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode prev = root;
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cursor = stack.pop();
      if ((cursor.left == null && cursor.right == null)
          || (prev == cursor.left && cursor.right == null)
          || prev == cursor.right) {
        res.add(cursor.val);
        prev = cursor;
        continue;
      }

      stack.push(cursor);
      if (cursor.right != null) {
        stack.push(cursor.right);
      }
      if (cursor.left != null) {
        stack.push(cursor.left);
      }
    }
    return res;
  }

  /**
   * Use a previous pointer to record the last visited node.
   *
   * @param root
   * @return List<Integer>
   */
  public List<Integer> postorderTraversalV5(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode prev = null;
    TreeNode cursor = root;
    while (cursor != null || !stack.isEmpty()) {
      while (cursor != null) {
        stack.push(cursor);
        cursor = cursor.left;
      }

      cursor = stack.pop();
      if (cursor.right == null || cursor.right == prev) {
        res.add(cursor.val);
        prev = cursor;
        cursor = null;
      } else {
        stack.push(cursor);
        cursor = cursor.right;
      }
    }
    return res;
  }

  /**
   * TagNode is used to record whether the TreeNode has been visited.
   */
  public static class TagNode {
    TreeNode node;
    boolean isVisited;

    public TagNode(TreeNode node) {
      this.node = node;
      this.isVisited = false;
    }

    @Override
    public String toString() {
      return "TagNode{" +
          "node=" + node +
          ", isVisited=" + isVisited +
          '}';
    }
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
