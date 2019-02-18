package com.github.kerraway.datastructures.heap;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * @author kerraway
 * @date 2019/2/18
 */
public class MaxHeapTest {

  @Test
  public void functionTest() {
    int total = 1000000;
    MaxHeap<Integer> maxHeap = new MaxHeap<>();
    Random random = new Random();
    for (int i = 0; i < total; i++) {
      maxHeap.add(random.nextInt(Integer.MAX_VALUE));
    }

    int[] arr = new int[total];
    for (int i = 0; i < total; i++) {
      arr[i] = maxHeap.extractMax();
    }
    assertTrue(maxHeap.isEmpty());
    for (int i = 1; i < total; i++) {
      assertTrue(arr[i - 1] >= arr[i]);
    }
  }

  @Test
  public void performanceTest() {
    //with heapify
    performanceTest(false);
    //without heapify
    performanceTest(true);
  }

  private void performanceTest(boolean withHeapify) {
    System.out.println("MaxHeap performance test, with heapify: " + withHeapify);

    long start = System.nanoTime();
    int total = 1000000;
    Random random = new Random();
    Integer[] array = new Integer[total];
    for (int i = 0; i < total; i++) {
      array[i] = random.nextInt(Integer.MAX_VALUE);
    }

    MaxHeap<Integer> maxHeap;
    if (withHeapify) {
      maxHeap = new MaxHeap<>(array);
    } else {
      maxHeap = new MaxHeap<>();
      for (Integer num : array) {
        maxHeap.add(num);
      }
    }

    int[] arr = new int[total];
    for (int i = 0; i < total; i++) {
      arr[i] = maxHeap.extractMax();
    }
    assertTrue(maxHeap.isEmpty());
    for (int i = 1; i < total; i++) {
      assertTrue(arr[i - 1] >= arr[i]);
    }

    System.out.printf("MaxHeap performance test, with heapify: %s, use %s s.\n\n",
        withHeapify, (System.nanoTime() - start) / 1000000000.0);
  }

}