package com.github.kerraway.datastructures.queue;

import com.github.kerraway.datastructures.util.Assert;

/**
 * @author kerraway
 * @date 2018/12/28
 */
public class LinkedQueue<E> implements Queue<E> {

  private Node head;
  private Node tail;
  private int size;

  public LinkedQueue() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void enqueue(E e) {
    if (tail == null) {
      tail = new Node(e);
      head = tail;
    } else {
      tail.next = new Node(e);
      tail = tail.next;
    }
    size++;
  }

  @Override
  public E dequeue() {
    Assert.isFalse(isEmpty(), "Queue must not be empty.");

    Node retNode = head;
    head = retNode.next;
    retNode.next = null;
    if (head == null) {
      tail = null;
    }
    size--;

    return retNode.e;
  }

  @Override
  public E peek() {
    Assert.isFalse(isEmpty(), "Queue must not be empty.");

    return head.e;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Queue: head ");
    Node cursor = head;
    while (cursor != null) {
      res.append(cursor).append(" -> ");
      cursor = cursor.next;
    }
    res.append("Null tail");
    return res.toString();
  }

  private class Node {
    E e;
    Node next;

    Node(E e, Node next) {
      this.e = e;
      this.next = next;
    }

    Node(E e) {
      this(e, null);
    }

    Node() {
      this(null, null);
    }

    @Override
    public String toString() {
      return e.toString();
    }
  }
}
