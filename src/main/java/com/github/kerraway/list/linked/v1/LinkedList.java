package com.github.kerraway.list.linked.v1;

import com.github.kerraway.list.List;
import com.github.kerraway.util.Assert;

/**
 * Linked list, support generic.
 *
 * @author kerraway
 * @date 2018/12/27
 */
public class LinkedList<E> implements List<E> {

  private Node head;
  private int size;

  public LinkedList() {
    this.head = null;
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
    //new node -> head
    /*Node node = new Node(e);
    node.next = head;
    head = node;*/

    //new node -> head
    //above three lines can be replaced by next line
    head = new Node(e, head);

    size++;
  }

  @Override
  public void addLast(E e) {
    add(size, e);
  }

  @Override
  public void add(int index, E e) {
    Assert.isTrue(index >= 0 && index <= size, "add element failed, index must be in [0, " + size + "].");

    if (index == 0) {
      addFirst(e);
      return;
    }
    Node prev = head;
    for (int i = 0; i < index - 1; i++) {
      prev = prev.next;
    }

    //node 3 -> new node -> node 4
    /*Node node = new Node(e);
    node.next = prev.next;
    prev.next = node;*/

    //node 3 -> new node -> node 4
    //above three lines can be replaced by next line
    prev.next = new Node(e, prev.next);

    size++;
  }

  @Override
  public E getFirst() {
    return null;
  }

  @Override
  public E getLast() {
    return null;
  }

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public void set(int index, E e) {

  }

  @Override
  public boolean contains(E e) {
    return false;
  }

  @Override
  public int indexOf(E e) {
    return 0;
  }

  @Override
  public E removeFirst() {
    return null;
  }

  @Override
  public E removeLast() {
    return null;
  }

  @Override
  public E remove(int index) {
    return null;
  }

  @Override
  public void removeElement(E e) {

  }

  @Override
  public String toString() {
    return null;
  }

  private class Node {
    E e;
    Node next;

    public Node(E e, Node next) {
      this.e = e;
      this.next = next;
    }

    public Node(E e) {
      this(e, null);
    }

    public Node() {
      this(null, null);
    }

    @Override
    public String toString() {
      return e.toString();
    }
  }
}
