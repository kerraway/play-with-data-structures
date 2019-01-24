package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.leetcode.LeetCode144.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/1/24
 */
public class LeetCode144Test {

  /**
   * in:
   * <pre>
   *  1
   *   \
   *    2
   *   /
   *  3
   * <pre/>
   * out: 1, 2, 3
   *
   * in:
   * <pre>
   *      4
   *     / \
   *    2   5
   *   / \   \
   *  1   3   6
   * </pre>
   * out: 4, 2, 1, 3, 5, 6
   */
  @Test
  public void preorderTraversal() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    List<Integer> expected = Arrays.asList(1, 2, 3);
    preorderTraversal(root, expected);

    root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    expected = Arrays.asList(4, 2, 1, 3, 5, 6);
    preorderTraversal(root, expected);
  }

  private void preorderTraversal(TreeNode root, List<Integer> expected) {
    final LeetCode144 leetCode144 = new LeetCode144();
    assertEquals(expected, leetCode144.preorderTraversalV1(root));
    assertEquals(expected, leetCode144.preorderTraversalV2(root));
    assertEquals(expected, leetCode144.preorderTraversalV3(root));
  }
}