package com.github.kerraway.queue;

import com.github.kerraway.queue.LeetCode102.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/11/30
 */
public class LeetCode102Test {

  @Test
  public void levelOrder() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    int[][] numsArr = {
        {3},
        {9, 20},
        {15, 7}
    };
    List<List<Integer>> expected = new ArrayList<>(numsArr.length);
    for (int[] nums : numsArr) {
      List<Integer> list = new ArrayList<>(nums.length);
      for (int num : nums) {
        list.add(num);
      }
      expected.add(list);
    }

    assertEquals(expected, new LeetCode102().levelOrder(root));
  }

}