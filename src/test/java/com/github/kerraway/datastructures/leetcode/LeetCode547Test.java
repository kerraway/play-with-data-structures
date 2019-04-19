package com.github.kerraway.datastructures.leetcode;

import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/04/19
 */
public class LeetCode547Test {

  @Test
  public void findCircleNum() {
    Pair<Integer[][], Integer>[] argsArr = new Pair[]{
        new Pair<>(new Integer[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
        new Pair<>(new Integer[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, 1),
    };
    for (Pair<Integer[][], Integer> pair : argsArr) {
      Integer[][] matrix = pair.getKey();
      Integer count = pair.getValue();
      assertEquals((int) count, new LeetCode547().findCircleNum(matrix));
    }
  }

}