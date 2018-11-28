package com.github.kerraway.stack;

import com.github.kerraway.array.v2.Array;

/**
 * @author 小柯
 * @date 2018/11/28
 */
public class ArrayStack<E> implements Stack<E> {

  private Array<E> array;

  public ArrayStack(int capacity) {
    array = new Array<>(capacity);
  }

  public ArrayStack() {
    array = new Array<>();
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
    res.append("Stack: ").append("[");
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
