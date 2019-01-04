package com.github.kerraway.datastructures.stack;

import com.github.kerraway.datastructures.list.array.v2.ArrayList;

/**
 * @author kerraway
 * @date 2018/11/28
 */
public class ArrayStack<E> implements Stack<E> {

  private ArrayList<E> array;

  public ArrayStack(int capacity) {
    array = new ArrayList<>(capacity);
  }

  public ArrayStack() {
    array = new ArrayList<>();
  }

  @Override
  public int size() {
    return array.size();
  }

  @Override
  public boolean isEmpty() {
    return array.isEmpty();
  }

  @Override
  public void push(E e) {
    array.addLast(e);
  }

  @Override
  public E peek() {
    return array.getLast();
  }

  @Override
  public E pop() {
    return array.removeLast();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("LinkedStack: ").append("[");
    for (int i = 0; i < array.size(); i++) {
      res.append(array.get(i));
      if (i != array.size() - 1) {
        res.append(", ");
      }
    }
    res.append("] top");
    return res.toString();
  }
}
