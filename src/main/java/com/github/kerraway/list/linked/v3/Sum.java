package com.github.kerraway.list.linked.v3;

/**
 * @author kerraway
 * @date 2018/12/28
 */
public class Sum {

  /**
   * Sum by traverse algorithm.
   *
   * @param arr
   * @return int
   */
  public int sumByTraverse(int[] arr) {
    if (arr == null) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }

  /**
   * Sum by recursive algorithm.
   *
   * @param arr
   * @return int
   */
  public int sumByRecursive(int[] arr) {
    if (arr == null) {
      return 0;
    }

    return sumByRecursive(arr, 0);
  }

  /**
   * Recursive method.
   *
   * @param arr
   * @param index
   * @return int
   */
  private int sumByRecursive(int[] arr, int index) {
    if (index == arr.length) {
      return 0;
    }

    return arr[index] + sumByRecursive(arr, index + 1);
  }

}
