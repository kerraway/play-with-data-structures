package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.queue.PriorityQueue;
import com.github.kerraway.datastructures.queue.Queue;
import com.github.kerraway.datastructures.tree.heap.MaxHeap;

import java.util.*;

/**
 * 347. 前K个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * @author kerraway
 * @date 2019/2/18
 */
public class LeetCode347 {

  /**
   * Use {@link MaxHeap}.
   *
   * @param nums
   * @param k
   * @return List<Integer>
   */
  public List<Integer> topKFrequentV1(int[] nums, int k) {
    Map<Integer, Integer> map = buildMap(nums);

    MaxHeap<Freq> maxHeap = new MaxHeap<>();
    map.forEach((num, freq) -> {
      if (maxHeap.size() < k) {
        maxHeap.add(new Freq4MaxHeap(num, freq));
      } else if (freq > maxHeap.findMax().freq) {
        maxHeap.replaceMax(new Freq4MaxHeap(num, freq));
      }
    });

    List<Integer> list = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
      list.add(maxHeap.extractMax().e);
    }
    return list;
  }

  /**
   * Use {@link com.github.kerraway.datastructures.queue.PriorityQueue}.
   *
   * @param nums
   * @param k
   * @return List<Integer>
   */
  public List<Integer> topKFrequentV2(int[] nums, int k) {
    Map<Integer, Integer> map = buildMap(nums);

    Queue<Freq> queue = new PriorityQueue<>();
    map.forEach((num, freq) -> {
      if (queue.size() < k) {
        queue.enqueue(new Freq4MaxHeap(num, freq));
      } else if (freq > queue.peek().freq) {
        queue.dequeue();
        queue.enqueue(new Freq4MaxHeap(num, freq));
      }
    });

    List<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()) {
      list.add(queue.dequeue().e);
    }
    return list;
  }

  /**
   * Use {@link java.util.PriorityQueue}.
   *
   * @param nums
   * @param k
   * @return List<Integer>
   */
  public List<Integer> topKFrequentV3(int[] nums, int k) {
    Map<Integer, Integer> map = buildMap(nums);

    java.util.Queue<Freq> queue = new java.util.PriorityQueue<>();
    map.forEach((num, freq) -> {
      if (queue.size() < k) {
        queue.add(new Freq4JavaUtilPriorityQueue(num, freq));
      } else if (freq > queue.peek().freq) {
        queue.remove();
        queue.add(new Freq4JavaUtilPriorityQueue(num, freq));
      }
    });

    List<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()) {
      list.add(queue.remove().e);
    }
    return list;
  }

  /**
   * Use {@link java.util.PriorityQueue}.
   *
   * @param nums
   * @param k
   * @return List<Integer>
   */
  public List<Integer> topKFrequentV4(int[] nums, int k) {
    Map<Integer, Integer> map = buildMap(nums);

    //anonymous inner class
    /*java.util.Queue<Freq> queue = new java.util.PriorityQueue<>(new Comparator<Freq>() {
      @Override
      public int compare(Freq a, Freq b) {
        return a.freq - b.freq;
      }
    });*/
    //lamda
    /*java.util.Queue<Freq> queue = new java.util.PriorityQueue<>((a, b) -> a.freq - b.freq);*/
    //Comparator#comparingInt(ToIntFunction)
    java.util.Queue<Freq> queue = new java.util.PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
    map.forEach((num, freq) -> {
      if (queue.size() < k) {
        queue.add(new Freq4JavaUtilPriorityQueue(num, freq));
      } else if (freq > queue.peek().freq) {
        queue.remove();
        queue.add(new Freq4JavaUtilPriorityQueue(num, freq));
      }
    });

    List<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()) {
      list.add(queue.remove().e);
    }
    return list;
  }

  /**
   * Use {@link java.util.PriorityQueue}.
   *
   * @param nums
   * @param k
   * @return List<Integer>
   */
  public List<Integer> topKFrequentV5(int[] nums, int k) {
    Map<Integer, Integer> map = buildMap(nums);

    //lamda
    /*java.util.Queue<Integer> queue = new java.util.PriorityQueue<>((a, b) -> map.get(a) - map.get(b));*/
    //Comparator#comparingInt(ToIntFunction)
    java.util.Queue<Integer> queue = new java.util.PriorityQueue<>(Comparator.comparingInt(map::get));
    map.forEach((num, freq) -> {
      if (queue.size() < k) {
        queue.add(num);
      } else if (freq > map.get(queue.peek())) {
        queue.remove();
        queue.add(num);
      }
    });

    List<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()) {
      list.add(queue.remove());
    }
    return list;
  }

  /**
   * Build map.
   *
   * @param nums
   * @return {@link Map<Integer, Integer>}
   */
  private Map<Integer, Integer> buildMap(int[] nums) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int num : nums) {
      map.merge(num, 1, (freq1, freq2) -> freq1 + freq2);
    }
    return map;
  }

  private static abstract class Freq implements Comparable<Freq> {
    int e;
    int freq;

    public Freq(int e, int freq) {
      this.e = e;
      this.freq = freq;
    }

    @Override
    public String toString() {
      return "Freq{" +
          "e=" + e +
          ", freq=" + freq +
          '}';
    }
  }

  private static class Freq4MaxHeap extends Freq {

    public Freq4MaxHeap(int e, int freq) {
      super(e, freq);
    }

    @Override
    public int compareTo(Freq another) {
      if (this.freq < another.freq) {
        return 1;
      }
      if (this.freq > another.freq) {
        return -1;
      }
      return 0;
    }
  }

  private static class Freq4JavaUtilPriorityQueue extends Freq {

    public Freq4JavaUtilPriorityQueue(int e, int freq) {
      super(e, freq);
    }

    @Override
    public int compareTo(Freq another) {
      if (this.freq < another.freq) {
        return -1;
      }
      if (this.freq > another.freq) {
        return 1;
      }
      return 0;
    }
  }

}
