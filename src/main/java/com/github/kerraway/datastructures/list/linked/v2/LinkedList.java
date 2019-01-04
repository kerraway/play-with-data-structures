package com.github.kerraway.datastructures.list.linked.v2;

import com.github.kerraway.datastructures.list.List;
import com.github.kerraway.datastructures.util.Assert;

/**
 * Linked list, with dummy head.
 *
 * @author kerraway
 * @date 2018/12/27
 */
public class LinkedList<E> implements List<E> {

  private Node dummyHead;
  private int size;

  public LinkedList() {
    this.dummyHead = new Node();
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
  public void addFirst(E e) {
    add(0, e);
  }

  @Override
  public void addLast(E e) {
    add(size, e);
  }

  @Override
  public void add(int index, E e) {
    Assert.isTrue(index >= 0 && index <= size, "add element failed, index must be in [0, " + size + "].");

    Node prev = dummyHead;
    for (int i = 0; i < index; i++) {
      prev = prev.next;
    }
    prev.next = new Node(e, prev.next);
    size++;
  }

  @Override
  public E getFirst() {
    return get(0);
  }

  @Override
  public E getLast() {
    return get(size - 1);
  }

  @Override
  public E get(int index) {
    Assert.isTrue(index >= 0 && index < size, "get element failed, index must be in [0, " + size + ").");

    Node cursor = dummyHead.next;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    return cursor.e;
  }

  @Override
  public void set(int index, E e) {
    Assert.isTrue(index >= 0 && index < size, "set element failed, index must be in [0, " + size + ").");

    Node cursor = dummyHead.next;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    cursor.e = e;
  }

  @Override
  public boolean contains(E e) {
    Node cursor = dummyHead.next;
    while (cursor != null) {
      if (cursor.e == e || (cursor.e != null && cursor.e.equals(e))) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }

  @Override
  public E removeFirst() {
    return remove(0);
  }

  @Override
  public E removeLast() {
    return remove(size - 1);
  }

  @Override
  public E remove(int index) {
    Assert.isTrue(index >= 0 && index < size, "remove element failed, index must be in [0, " + size + ").");

    Node prev = dummyHead;
    for (int i = 0; i < index - 1; i++) {
      prev = prev.next;
    }

    Node retNode = prev.next;
    prev.next = retNode.next;
    retNode.next = null;
    size--;

    return retNode.e;
  }

  @Override
  public void removeElement(E e) {
    Node prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.e == e || (prev.next.e != null && prev.next.e.equals(e))) {
        break;
      }
      prev = prev.next;
    }
    if (prev.next != null) {
      Node deleteNode = prev.next;
      prev.next = deleteNode.next;
      deleteNode.next = null;
      size--;
    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("LinkedList: size ").append(size).append(", ");
    res.append("elements ");
    Node cursor = dummyHead.next;
    while (cursor != null) {
      res.append(cursor).append(" -> ");
      cursor = cursor.next;
    }
    res.append("NULL");
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
