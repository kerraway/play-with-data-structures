package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.leetcode.LeetCode94.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/1/23
 */
public class LeetCode94Test {

  /**
   * in:
   * <pre>
   *  1
   *   \
   *    2
   *   /
   *  3
   * <pre/>
   * out: 1, 3, 2
   *
   * in:
   * <pre>
   *      1
   *     / \
   *    3   5
   *   / \   \
   *  2   4   6
   * </pre>
   * out: 2, 3, 4, 1, 5, 6
   */
  @Test
  public void inorderTraversal() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    List<Integer> expected = Arrays.asList(1, 3, 2);
    List<Integer> actual = new LeetCode94().inorderTraversal(root);
    assertEquals(expected, actual);

    root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    expected = Arrays.asList(2, 3, 4, 1, 5, 6);
    actual = new LeetCode94().inorderTraversal(root);
    assertEquals(expected, actual);
  }
}