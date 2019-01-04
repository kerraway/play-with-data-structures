package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.queue.ArrayQueue;
import com.github.kerraway.datastructures.queue.Queue;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值（即逐层地、从左到右访问所有节点）。
 * 例如: 给定二叉树: [3,9,20,null,null,15,7]
 * -    3
 * -   / \
 * -   9  20
 * -     /  \
 * -    15   7
 * 返回其层次遍历结果：
 * - [
 * -    [3],
 * -    [9,20],
 * -    [15,7]
 * - ]
 *
 * @author kerraway
 * @date 2018/11/30
 */
public class LeetCode102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<Pair<TreeNode, Integer>> queue = new ArrayQueue<>();
    queue.enqueue(new Pair<>(root, 0));

    while (!queue.isEmpty()) {
      Pair<TreeNode, Integer> front = queue.dequeue();
      TreeNode node = front.getKey();
      int level = front.getValue();

      if (level == res.size()) {
        res.add(new ArrayList<>());
      }
      assert level < res.size();

      res.get(level).add(node.val);
      if (node.left != null) {
        queue.enqueue(new Pair<>(node.left, level + 1));
      }
      if (node.right != null) {
        queue.enqueue(new Pair<>(node.right, level + 1));
      }
    }
    return res;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
