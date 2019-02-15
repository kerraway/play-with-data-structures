package com.github.kerraway.datastructures.leetcode;

import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/12/28
 */
public class LeetCode804Test {

  @Test
  public void uniqueMorseRepresentations() {
    Pair<String[], Integer>[] argsArr = new Pair[]{
        new Pair<>(new String[]{"gin", "zen", "gig", "msg"}, 2),
        new Pair<>(new String[]{"gin", "zen", "gig"}, 2),
        new Pair<>(new String[]{"gin", "gig"}, 2),
        new Pair<>(new String[]{"gin", "zen"}, 1),
    };
    for (Pair<String[], Integer> pair : argsArr) {
      String[] words = pair.getKey();
      int count = pair.getValue();
      //solution v1
      assertEquals(count, new LeetCode804().uniqueMorseRepresentationsV1(words));
      //solution v2
      assertEquals(count, new LeetCode804().uniqueMorseRepresentationsV2(words));
      //solution v3
      assertEquals(count, new LeetCode804().uniqueMorseRepresentationsV3(words));
    }
  }

}