package com.github.kerraway.queue;

import com.github.kerraway.array.v2.Array;

/**
 * @author 小柯
 * @date 2018/11/30
 */
public class ArrayQueue<E> implements Queue<E> {

  private Array<E> array;

  public ArrayQueue(int capacity) {
    array = new Array<>(capacity);
  }

  public ArrayQueue() {
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
  public void enqueue(E e) {
    array.addLast(e);
  }

  @Override
  public E dequeue() {
    return array.removeFirst();
  }

  @Override
  public E peek() {
    return array.getFirst();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Queue: head [");
    for (int i = 0; i < array.size(); i++) {
      res.append(array.get(i));
      if (i != array.size() - 1) {
        res.append(", ");
      }
    }
    res.append("] tail");
    return res.toString();
  }
}
