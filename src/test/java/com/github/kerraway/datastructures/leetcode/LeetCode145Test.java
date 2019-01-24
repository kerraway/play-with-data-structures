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
   *      4
   *     / \
   *    2   5
   *   / \   \
   *  1   3   6
   * </pre>
   * out: 1, 3, 2, 6, 5, 4
   */
  @Test
  public void postorderTraversal() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    List<Integer> expected = Arrays.asList(3, 2, 1);
    postorderTraversal(root, expected);

    root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    expected = Arrays.asList(1, 3, 2, 6, 5, 4);
    postorderTraversal(root, expected);
  }

  private void postorderTraversal(TreeNode root, List<Integer> expected) {
    final LeetCode145 leetCode145 = new LeetCode145();
    assertEquals(expected, leetCode145.postorderTraversalV1(root));
    assertEquals(expected, leetCode145.postorderTraversalV2(root));
    assertEquals(expected, leetCode145.postorderTraversalV3(root));
    assertEquals(expected, leetCode145.postorderTraversalV4(root));
    assertEquals(expected, leetCode145.postorderTraversalV5(root));
    assertEquals(expected, leetCode145.postorderTraversalV6(root));
  }
}