package com.github.kerraway.datastructures.leetcode;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/22
 */
public class LeetCode307Test {

  @Test
  public void sumRange() {
    int n = 100;
    int[] nums = new int[n];
    int sum = 0;
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      int num = random.nextInt(n);
      nums[i] = num;
      sum += num;
    }
    LeetCode307 instance = new LeetCode307(nums);
    assertEquals(sum, instance.sumRange(0, n - 1));

    int count = 10;
    for (int i = 0; i < count; i++) {
      int index = random.nextInt(n);
      int plus = random.nextInt(n);
      instance.update(index, instance.get(index) + plus);
      sum += plus;
      assertEquals(sum, instance.sumRange(0, n - 1));
    }
  }

}