package com.github.kerraway.datastructures.stack;

import com.github.kerraway.datastructures.list.linked.v2.LinkedList;

/**
 * @author kerraway
 * @date 2018/12/28
 */
public class LinkedStack<E> implements Stack<E> {

  private LinkedList<E> list;

  public LinkedStack() {
    this.list = new LinkedList<>();
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public void push(E e) {
    list.addFirst(e);
  }

  @Override
  public E peek() {
    return list.getFirst();
  }

  @Override
  public E pop() {
    return list.removeFirst();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("LinkedStack: ").append("[");
    int size = list.size();
    for (int i = size - 1; i >= 0; i--) {
      res.append(list.get(i));
      if (i != 0) {
        res.append(", ");
      }
    }
    res.append("] top");
    return res.toString();
  }
}
