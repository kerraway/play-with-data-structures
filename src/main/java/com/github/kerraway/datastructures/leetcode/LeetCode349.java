package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.set.BinarySearchTreeSet;
import com.github.kerraway.datastructures.set.LinkedListSet;
import com.github.kerraway.datastructures.set.Set;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * <p>
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author kerraway
 * @date 2019/2/15
 */
public class LeetCode349 {

  /**
   * Use {@link LinkedListSet}.
   *
   * @param nums1
   * @param nums2
   * @return int[]
   */
  public int[] intersectionV1(int[] nums1, int[] nums2) {
    Set<Integer> set = new LinkedListSet<>();
    for (int num : nums1) {
      set.add(num);
    }

    List<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      if (set.contains(num)) {
        list.add(num);
        set.remove(num);
      }
    }

    return buildArray(list);
  }

  /**
   * Use {@link BinarySearchTreeSet}.
   *
   * @param nums1
   * @param nums2
   * @return int[]
   */
  public int[] intersectionV2(int[] nums1, int[] nums2) {
    Set<Integer> set = new BinarySearchTreeSet<>();
    for (int num : nums1) {
      set.add(num);
    }

    List<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      if (set.contains(num)) {
        list.add(num);
        set.remove(num);
      }
    }

    return buildArray(list);
  }

  /**
   * Use {@link TreeSet}.
   *
   * @param nums1
   * @param nums2
   * @return int[]
   */
  public int[] intersectionV3(int[] nums1, int[] nums2) {
    java.util.Set<Integer> set = new TreeSet<>();
    for (int num : nums1) {
      set.add(num);
    }

    List<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      if (set.contains(num)) {
        list.add(num);
        set.remove(num);
      }
    }

    return buildArray(list);
  }

  private int[] buildArray(List<Integer> list) {
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

}
