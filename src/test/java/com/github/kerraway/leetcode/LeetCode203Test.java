package com.github.kerraway.leetcode;

import org.junit.Test;

import static com.github.kerraway.leetcode.LeetCode203.*;
import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/12/28
 */
public class LeetCode203Test {

  @Test
  public void removeElements() {
    int[][][] argsArr = {
        {{}, {2}},
        {{2, 2, 2, 3, 4, 5, 6}, {2}},
        {{2, 2, 2, 3, 4, 5, 6, 2, 2, 2, 7, 8}, {2}},
        {{1, 2, 3, 4, 5, 6, 7}, {100}}
    };
    LeetCode203 leetCode203 = new LeetCode203();
    for (int[][] args : argsArr) {
      int[] values = args[0];
      int remove = args[1][0];
      //solution v1
      assertTrue(isValid(leetCode203.removeElementsV1(newListNode(values), remove), remove));
      //solution v2
      assertTrue(isValid(leetCode203.removeElementsV2(newListNode(values), remove), remove));
      //solution v3
      assertTrue(isValid(leetCode203.removeElementsV3(newListNode(values), remove), remove));
    }
  }

  private boolean isValid(ListNode head, int val) {
    if (head == null) {
      return true;
    }
    ListNode cursor = head;
    while (cursor != null) {
      if (cursor.val == val) {
        return false;
      }
      cursor = cursor.next;
    }
    return true;
  }

  private ListNode newListNode(int[] values) {
    ListNode dummyHead = new ListNode(0);
    ListNode cursor = dummyHead;
    for (int value : values) {
      cursor.next = new ListNode(value);
      cursor = cursor.next;
    }
    return dummyHead.next;
  }
}