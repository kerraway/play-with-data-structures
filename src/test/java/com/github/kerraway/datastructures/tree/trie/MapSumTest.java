package com.github.kerraway.datastructures.tree.trie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/25
 */
public class MapSumTest {

  /**
   * "0"      ->    0
   * "01"			->    1
   * "012"		->    2
   * "0123"		->    3
   * "01234"	->    4
   * "012345"	->    5
   */
  @Test
  public void functionTest() {
    MapSum mapSum = new MapSum();
    int n = 100;
    int[] sums = new int[n + 1];
    sums[0] = 0;
    for (int i = 0; i < n; i++) {
      mapSum.insert(buildKey(i), i);
      sums[i + 1] = sums[i] + i;
    }
    for (int i = 0; i < n; i++) {
      int expected = getSum(sums, i);
      int actual = mapSum.sum(buildKey(i));
      assertEquals(expected, actual);
    }
  }

  private int getSum(int[] sums, int i) {
    return sums[sums.length - 1] - sums[i];
  }

  private String buildKey(int i) {
    StringBuilder keyBuilder = new StringBuilder();
    for (int j = 0; j <= i; j++) {
      keyBuilder.append(j);
    }
    return keyBuilder.toString();
  }

}