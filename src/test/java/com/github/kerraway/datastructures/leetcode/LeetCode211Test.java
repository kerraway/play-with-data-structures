package com.github.kerraway.datastructures.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/25
 */
public class LeetCode211Test {

  @Test
  public void test() {
    LeetCode211 instance = new LeetCode211();
    instance.addWord("bad");
    instance.addWord("dad");
    instance.addWord("mad");

    assertTrue(instance.search("bad"));
    assertFalse(instance.search("pad"));
    assertTrue(instance.search(".ad"));
    assertTrue(instance.search("b.."));
    assertFalse(instance.search("b."));
    assertTrue(instance.search(".a."));
  }

}