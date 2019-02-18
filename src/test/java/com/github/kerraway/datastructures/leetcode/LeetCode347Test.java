package com.github.kerraway.datastructures.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author kerraway
 * @date 2019/2/18
 */
public class LeetCode347Test {

  @Test
  public void topKFrequent() {
    int[][][] argsArr = {
        {{0, 1, 1, 2, 2, 2, 3}, {2}, {1, 2}},
        {{1}, {1}, {1}},
        {{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, {2}, {4, 1}}
    };

    for (int[][] args : argsArr) {
      int[] nums = args[0];
      int k = args[1][0];
      int[] result = args[2];
      //solution v1
      assertArrayEquals(result, buildArray(new LeetCode347().topKFrequentV1(nums, k)));
      //solution v2
      assertArrayEquals(result, buildArray(new LeetCode347().topKFrequentV2(nums, k)));
      //solution v3
      assertArrayEquals(result, buildArray(new LeetCode347().topKFrequentV3(nums, k)));
      //solution v4
      assertArrayEquals(result, buildArray(new LeetCode347().topKFrequentV4(nums, k)));
      //solution v5
      assertArrayEquals(result, buildArray(new LeetCode347().topKFrequentV5(nums, k)));
    }
  }

  private int[] buildArray(List<Integer> list) {
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }

}