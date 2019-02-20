package com.github.kerraway.datastructures.tree;

import org.junit.Test;

/**
 * @author kerraway
 * @date 2019/2/20
 */
public class SegmentTreeTest {

  @Test
  public void functionTest() {
    Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    SegmentTree<Integer> segmentTree4Sum = new SegmentTree<>(nums, (a, b) -> a + b);
    System.out.println("Sum:" + segmentTree4Sum);

    SegmentTree<Integer> segmentTree4Product = new SegmentTree<>(nums, (a, b) -> a * b);
    System.out.println("Product:" + segmentTree4Product);

    SegmentTree<Integer> segmentTree4Max = new SegmentTree<>(nums, Math::max);
    System.out.println("Max value: " + segmentTree4Max);

    SegmentTree<Integer> segmentTree4Min = new SegmentTree<>(nums, Math::min);
    System.out.println("Min value: " + segmentTree4Min);

    int[][] argsArr = {{0, 2}, {2, 5}, {0, 5}, {0, 8}, {1, 8}};
    for (int[] ints : argsArr) {
      int queryL = ints[0];
      int queryR = ints[1];
      System.out.printf("Sum of [%s, %s]: %s\n", queryL, queryR, segmentTree4Sum.query(queryL, queryR));
    }
  }

}