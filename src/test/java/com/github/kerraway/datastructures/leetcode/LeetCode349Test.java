package com.github.kerraway.datastructures.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/15
 */
public class LeetCode349Test {

  @Test
  public void intersection() {
    int[][][] argsArr = {
        {{1, 2, 3}, {4, 5, 6}, {}},
        {{1, 2, 3}, {1, 2, 4}, {1, 2}},
        {{1, 2, 2, 3}, {1, 2, 2, 4}, {1, 2}},
        {{1, 2, 2, 2, 3}, {1, 2, 3}, {1, 2, 3}},
        {
            {61, 24, 20, 58, 95, 53, 17, 32, 45, 85, 70, 20, 83, 62, 35, 89, 5, 95, 12, 86, 58, 77, 30,
                64, 46, 13, 5, 92, 67, 40, 20, 38, 31, 18, 89, 85, 7, 30, 67, 34, 62, 35, 47, 98, 3, 41,
                53, 26, 66, 40, 54, 44, 57, 46, 70, 60, 4, 63, 82, 42, 65, 59, 17, 98, 29, 72, 1, 96, 82,
                66, 98, 6, 92, 31, 43, 81, 88, 60, 10, 55, 66, 82, 0, 79, 11, 81},
            {5, 25, 4, 39, 57, 49, 93, 79, 7, 8, 49, 89, 2, 7, 73, 88, 45, 15, 34, 92, 84, 38, 85, 34, 16,
                6, 99, 0, 2, 36, 68, 52, 73, 50, 77, 44, 61, 48},
            {5, 4, 57, 79, 7, 89, 88, 45, 34, 92, 38, 85, 6, 0, 77, 44, 61}
        }
    };

    for (int[][] intsArr : argsArr) {
      int[] ints1 = intsArr[0];
      int[] ints2 = intsArr[1];
      int[] result = intsArr[2];

      //solution v1
      assertArrayEquals(result, new LeetCode349().intersectionV1(ints1, ints2));
      //solution v2
      assertArrayEquals(result, new LeetCode349().intersectionV2(ints1, ints2));
      //solution v3
      assertArrayEquals(result, new LeetCode349().intersectionV3(ints1, ints2));
      //solution v4
      assertArrayEquals(result, new LeetCode349().intersectionV4(ints1, ints2));
    }
  }

}