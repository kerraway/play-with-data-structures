package com.github.kerraway.datastructures.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/26
 */
public class LeetCode380Test {

  @Test
  public void test() {
    //v1 HashMap
    test(new LeetCode380.RandomizedSetWithHashMapV1());
    //v2 HashMap
    test(new LeetCode380.RandomizedSetWithHashMapV2());
    //v3 Trie
    test(new LeetCode380.RandomizedSetWithTrieMap());
    //v4 TrieInRecursion
    test(new LeetCode380.RandomizedSetWithTrieInRecursion());
  }

  private void test(LeetCode380.RandomizedSet randomSet) {
    //向集合中插入 1 。返回 true 表示 1 被成功地插入。
    assertTrue(randomSet.insert(1));
    //返回 false ，表示集合中不存在 2 。
    assertFalse(randomSet.remove(2));
    //向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
    assertTrue(randomSet.insert(2));

    //getRandom 应随机返回 1 或 2 。
    //Ref https://stackoverflow.com/questions/19004611/junit-assert-or-condition-in-my-test-case
    assertThat(randomSet.getRandom(), anyOf(is(1), is(2)));
    assertThat(randomSet.getRandom(), either(is(1)).or(is(2)));

    //从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
    assertTrue(randomSet.remove(1));
    //2 已在集合中，所以返回 false 。
    assertFalse(randomSet.insert(2));

    //由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
    assertEquals(2, randomSet.getRandom());

    //添加 113，返回 true
    assertTrue(randomSet.insert(113));
    //添加 11，返回 true
    assertTrue(randomSet.insert(11));
    //添加 112，返回 true
    assertTrue(randomSet.insert(112));
    //移除 11，返回 true
    assertTrue(randomSet.remove(11));
    //移除 1，返回 false（不存在 1）
    assertFalse(randomSet.remove(1));
    //移除 113，返回 true
    assertTrue(randomSet.remove(113));
    //移除 112，返回 true
    assertTrue(randomSet.remove(112));
    //返回 2（只剩下 2）
    assertEquals(2, randomSet.getRandom());
    //移除 2，返回 true
    assertTrue(randomSet.remove(2));

    //空 set
    //true
    assertTrue(randomSet.insert(0));
    //true
    assertTrue(randomSet.insert(1));
    //true
    assertTrue(randomSet.remove(0));
    //true
    assertTrue(randomSet.insert(2));
    //true
    assertTrue(randomSet.remove(1));
    //返回 2（只剩下 2）
    assertEquals(2, randomSet.getRandom());
  }

}