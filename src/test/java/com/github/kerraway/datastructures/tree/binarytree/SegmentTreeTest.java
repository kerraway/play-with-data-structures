package com.github.kerraway.datastructures.tree.binarytree;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

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
    //set and query test
    setAndQueryFunctionTest();
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

    int count = 10;
    for (int i = 0; i < count; i++) {
      int queryR = random.nextInt(n);
      int queryL = random.nextInt(queryR);
      System.out.printf("Sum of [%s, %s]: %s\n", queryL, queryR, segmentTree.query(queryL, queryR));
    }
    System.out.println();
  }

  private void setAndQueryFunctionTest() {
    Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    SegmentTree<Integer> segmentTree4Sum = new SegmentTree<>(nums, (a, b) -> a + b);
    System.out.println("Init: " + segmentTree4Sum);

    Integer sum = Arrays.stream(nums)
        .mapToInt(Integer::intValue)
        .sum();
    assertEquals(sum, segmentTree4Sum.query(0, segmentTree4Sum.size() - 1));

    int[][] argsArr = {{1, 1}, {0, -1}, {2, 1}, {7, 5}};
    for (int[] ints : argsArr) {
      int index = ints[0];
      int plus = ints[1];
      Integer integer = segmentTree4Sum.get(index);
      segmentTree4Sum.set(index, integer + plus);
      System.out.printf("After add %s on the element at index %s: %s\n", plus, index, segmentTree4Sum);
      sum += plus;
      assertEquals(sum, segmentTree4Sum.query(0, segmentTree4Sum.size() - 1));
    }
  }

}