package com.github.kerraway.datastructures.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/22
 */
public class LeetCode208Test {

  @Test
  public void test() {
    LeetCode208 trie = new LeetCode208();

    trie.insert("apple");
    assertTrue(trie.search("apple"));
    assertFalse(trie.search("app"));
    assertTrue(trie.startsWith("app"));

    trie.insert("app");
    assertTrue(trie.search("app"));
    assertTrue(trie.startsWith("app"));
  }

}