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

  public List<Integer> postorderTraversal(TreeNode root) {
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
   * TagNode is used to record whether the TreeNode has been visited.
   */
  public static class TagNode {
    TreeNode node;
    boolean isVisited;

    public TagNode(TreeNode node) {
      this.node = node;
      this.isVisited = false;
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
  }

}
