package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.leetcode.LeetCode145.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/1/24
 */
public class LeetCode145Test {

  /**
   * in:
   * <pre>
   *  1
   *   \
   *    2
   *   /
   *  3
   * <pre/>
   * out: 3, 2, 1
   *
   * in:
   * <pre>
   *      1
   *     / \
   *    3   5
   *   / \   \
   *  2   4   6
   * </pre>
   * out: 2, 4, 3, 6, 5, 1
   */
  @Test
  public void postorderTraversal() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    List<Integer> expected = Arrays.asList(3, 2, 1);
    List<Integer> actual = new LeetCode145().postorderTraversal(root);
    assertEquals(expected, actual);

    root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    expected = Arrays.asList(2, 4, 3, 6, 5, 1);
    actual = new LeetCode145().postorderTraversal(root);
    assertEquals(expected, actual);
  }
}