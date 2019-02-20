package com.github.kerraway.datastructures.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/20
 */
public class LeetCode303Test {

  private static final int[] NUMS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  private static final int[][] ARGS_ARR = {
      {0, 2, 6},
      {2, 5, 18},
      {0, 5, 21},
      {0, 8, 45},
      {1, 8, 44}
  };

  @Test
  public void sumRange() {
    LeetCode303.NumArrayV1 numArrayV1 = new LeetCode303.NumArrayV1(NUMS);
    LeetCode303.NumArrayV2 numArrayV2 = new LeetCode303.NumArrayV2(NUMS);
    for (int[] ints : ARGS_ARR) {
      int queryL = ints[0];
      int queryR = ints[1];
      int result = ints[2];
      //solution v1
      assertEquals(result, numArrayV1.sumRange(queryL, queryR));
      //solution v2
      assertEquals(result, numArrayV2.sumRange(queryL, queryR));
    }
  }
}