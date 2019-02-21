package com.github.kerraway.datastructures.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author kerraway
 * @date 2019/2/20
 */
public class SegmentTreeTest {

  @Test
  public void functionTest() {
    //constructor test
    constructorFunctionTest();
    //query test
    queryFunctionTest();
  }

  private void constructorFunctionTest() {
    Integer[][] argsArr = {{}, {1, 2, 3}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};
    for (Integer[] nums : argsArr) {
      System.out.println("nums: " + Arrays.toString(nums));

      SegmentTree<Integer> segmentTree4Sum = new SegmentTree<>(nums, (a, b) -> a + b);
      System.out.println("Sum:" + segmentTree4Sum);

      SegmentTree<Integer> segmentTree4Product = new SegmentTree<>(nums, (a, b) -> a * b);
      System.out.println("Product:" + segmentTree4Product);

      SegmentTree<Integer> segmentTree4Max = new SegmentTree<>(nums, Math::max);
      System.out.println("Max value: " + segmentTree4Max);

      SegmentTree<Integer> segmentTree4Min = new SegmentTree<>(nums, Math::min);
      System.out.println("Min value: " + segmentTree4Min);
      System.out.println();
    }
  }

  private void queryFunctionTest() {
    int n = 1000;
    Integer[] nums = new Integer[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      nums[i] = random.nextInt(n);
    }
    SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);

    int count = 100;
    for (int i = 0; i < count; i++) {
      int queryR = random.nextInt(n);
      int queryL = random.nextInt(queryR);
      System.out.printf("Sum of [%s, %s]: %s\n", queryL, queryR, segmentTree.query(queryL, queryR));
    }
  }

}