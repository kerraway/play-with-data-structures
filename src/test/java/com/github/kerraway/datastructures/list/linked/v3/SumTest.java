package com.github.kerraway.datastructures.list.linked.v3;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author kerraway
 * @date 2018/12/28
 */
public class SumTest {

  @Test
  public void test() {
    final Random random = new Random();
    int total = random.nextInt(100) + 100;
    int[] arr = new int[total];
    for (int i = 0; i < total; i++) {
      arr[i] = random.nextInt(100);
    }

    int sum1 = new Sum().sumByTraverse(arr);
    int sum2 = new Sum().sumByRecursive(arr);
    assertEquals(sum1, sum2);
  }

}