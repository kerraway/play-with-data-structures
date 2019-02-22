package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.tree.SegmentTree;

import java.util.Arrays;

/**
 * 307. 区域和检索 - 数组可修改
 * https://program-think.blogspot.com/2019/01/Security-Guide-for-Political-Activists.html
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 示例:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * <p>
 * 说明:
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 * @author kerraway
 * @date 2019/2/22
 * @see LeetCode303
 */
public class LeetCode307 {

  private SegmentTree<Integer> segmentTree;

  public LeetCode307(int[] nums) {
    this.segmentTree = new SegmentTree<>(Arrays.stream(nums).boxed().toArray(Integer[]::new), (a, b) -> a + b);
  }

  public void update(int index, int value) {
    segmentTree.set(index, value);
  }

  public int sumRange(int left, int right) {
    return segmentTree.query(left, right);
  }

  public int get(int index) {
    return segmentTree.get(index);
  }
}
