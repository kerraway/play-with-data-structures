package com.github.kerraway.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author kerraway
 * @date 2018/12/28
 */
public class LeetCode203 {

  public ListNode removeElementsV1(ListNode head, int val) {
    while (head != null && head.val == val) {
      ListNode deleteNode = head;
      head = head.next;
      deleteNode.next = null;
    }

    if (head == null) {
      return null;
    }

    ListNode prev = head;
    while (prev.next != null) {
      if (prev.next.val == val) {
        ListNode deleteNode = prev.next;
        prev.next = deleteNode.next;
        deleteNode.next = null;
      } else {
        prev = prev.next;
      }
    }
    return head;
  }

  public ListNode removeElementsV2(ListNode head, int val) {
    while (head != null && head.val == val) {
      head = head.next;
    }

    if (head == null) {
      return null;
    }

    ListNode prev = head;
    while (prev.next != null) {
      if (prev.next.val == val) {
        prev.next = prev.next.next;
      } else {
        prev = prev.next;
      }
    }
    return head;
  }

  public ListNode removeElementsV3(ListNode head, int val) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;

    ListNode prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.val == val) {
        prev.next = prev.next.next;
      } else {
        prev = prev.next;
      }
    }

    return dummyHead.next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}
