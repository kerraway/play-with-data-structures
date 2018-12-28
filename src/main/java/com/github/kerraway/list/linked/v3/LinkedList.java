package com.github.kerraway.list.linked.v3;

import com.github.kerraway.list.List;
import com.github.kerraway.util.Assert;
import javafx.util.Pair;

/**
 * Linked list, without dummy head, use recursive algorithm.
 *
 * @author kerraway
 * @date 2018/12/28
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
    add(0, e);
  }

  @Override
  public void addLast(E e) {
    add(size, e);
  }

  @Override
  public void add(int index, E e) {
    Assert.isTrue(index >= 0 && index <= size, "add element failed, index must be in [0, " + size + "].");

    head = add(head, index, e);
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

    return get(head, index);
  }

  @Override
  public void set(int index, E e) {
    Assert.isTrue(index >= 0 && index < size, "set element failed, index must be in [0, " + size + ").");

    set(head, index, e);
  }

  @Override
  public boolean contains(E e) {
    return contains(head, e);
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

    Pair<Node, E> res = remove(head, index);
    head = res.getKey();
    size--;
    return res.getValue();
  }

  @Override
  public void removeElement(E e) {
    head = removeElement(head, e);
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("LinkedList: size ").append(size).append(", ");
    res.append("elements ");
    Node cursor = head;
    while (cursor != null) {
      res.append(cursor).append(" -> ");
      cursor = cursor.next;
    }
    res.append("NULL");
    return res.toString();
  }

  /**
   * The param node is the head of linked list, and add e into index of the linked list.
   * This method is recursive method.
   *
   * @param node
   * @param index
   * @param e
   * @return Node
   */
  private Node add(Node node, int index, E e) {
    if (index == 0) {
      return new Node(e, node);
    }

    node.next = add(node.next, index - 1, e);
    return node;
  }

  /**
   * The param node is the head of linked list, and find the element at index of the linked list.
   * This method is recursive method.
   *
   * @param node
   * @param index
   * @return E
   */
  private E get(Node node, int index) {
    if (index == 0) {
      return node.e;
    }

    return get(node.next, index - 1);
  }

  /**
   * The param node is the head of linked list, and replace the element at index of the linked list.
   * This method is recursive method.
   *
   * @param node
   * @param index
   * @param e
   */
  private void set(Node node, int index, E e) {
    if (index == 0) {
      node.e = e;
      return;
    }

    set(node.next, index - 1, e);
  }

  /**
   * The param node is the head of linked list, if the element of node equals to the param e, returns true.
   * This method is recursive method.
   *
   * @param node
   * @param e
   * @return boolean
   */
  private boolean contains(Node node, E e) {
    if (node == null) {
      return false;
    }
    if (node.e == e || (node.e != null && node.e.equals(e))) {
      return true;
    }

    return contains(node.next, e);
  }

  /**
   * The param node is the head of linked list, and remove the element at index of the linked list,
   * returns the head of processed linked list and removed element, use {@link Pair} to hold them.
   * This method is recursive method.
   *
   * @param node
   * @param index
   * @return {@link Pair<Node, E>}
   */
  private Pair<Node, E> remove(Node node, int index) {
    if (index == 0) {
      return new Pair<>(node.next, node.e);
    }

    Pair<Node, E> res = remove(node.next, index - 1);
    node.next = res.getKey();
    return new Pair<>(node, res.getValue());
  }

  /**
   * The param node is the head of linked list, if the element of node equals to the param e, remove it.
   * This method is recursive method.
   *
   * @param node
   * @param e
   * @return Node
   */
  private Node removeElement(Node node, E e) {
    if (node == null) {
      return null;
    }
    if (node.e == e || (node.e != null && node.e.equals(e))) {
      size--;
      return node.next;
    }

    node.next = removeElement(node.next, e);
    return node;
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
