package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.tree.SegmentTree;
import com.github.kerraway.datastructures.util.Assert;

import java.util.Arrays;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * 说明:
 * 你可以假设数组不可变，且会多次调用 sumRange 方法。
 *
 * @author kerraway
 * @date 2019/2/20
 * @see LeetCode307
 */
public class LeetCode303 {

  /**
   * Use {@link SegmentTree}.
   */
  public static class NumArrayV1 {

    private SegmentTree<Integer> segmentTree;

    public NumArrayV1(int[] nums) {
      this.segmentTree = new SegmentTree<>(Arrays.stream(nums).boxed().toArray(Integer[]::new), (a, b) -> a + b);
    }

    public int sumRange(int i, int j) {
      Assert.notNull(segmentTree);

      return segmentTree.query(i, j);
    }
  }

  /**
   * Use a array to store sums.
   */
  public static class NumArrayV2 {

    private int[] sums;

    public NumArrayV2(int[] nums) {
      sums = new int[nums.length + 1];
      sums[0] = 0;
      for (int i = 1; i < sums.length; i++) {
        sums[i] = sums[i - 1] + nums[i - 1];
      }
    }

    public int sumRange(int i, int j) {
      return sums[j + 1] - sums[i];
    }
  }

}
