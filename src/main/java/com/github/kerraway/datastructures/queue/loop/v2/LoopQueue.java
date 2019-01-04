package com.github.kerraway.datastructures.queue.loop.v2;

import com.github.kerraway.datastructures.queue.Queue;
import com.github.kerraway.datastructures.util.Assert;

/**
 * This version is different from {@link com.github.kerraway.datastructures.queue.loop.v1.LoopQueue},
 * which doesn't waste any space.
 *
 * @author kerraway
 * @date 2018/12/26
 */
public class LoopQueue<E> implements Queue<E> {

  private E[] data;
  private int front, tail;
  private int size;

  public LoopQueue(int capacity) {
    this.data = (E[]) new Object[capacity];
    this.front = 0;
    this.tail = 0;
    this.size = 0;
  }

  public LoopQueue() {
    this(10);
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
    if (size == getCapacity()) {
      resize(getCapacity() * 2);
    }

    data[tail] = e;
    tail = (tail + 1) % data.length;
    size++;
  }

  @Override
  public E dequeue() {
    Assert.isFalse(isEmpty(), "Queue must not be empty.");

    E ret = data[front];
    data[front] = null;
    front = (front + 1) % data.length;
    size--;

    int capacity = getCapacity();
    if (size == capacity / 4 && capacity / 2 != 0) {
      resize(capacity / 2);
    }

    return ret;
  }

  @Override
  public E peek() {
    Assert.isFalse(isEmpty(), "Queue must not be empty.");

    return data[front];
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Queue: head [");
    for (int i = 0; i < size; i++) {
      res.append(data[(front + i) % data.length]);
      if ((front + i + 1) % data.length != tail) {
        res.append(", ");
      }
    }
    res.append("] tail");
    return res.toString();
  }

  /**
   * Get capacity: the length of static array.
   *
   * @return int
   */
  private int getCapacity() {
    return data.length;
  }

  /**
   * Adjust static array's capacity to new capacity.
   *
   * @param newCapacity
   */
  private void resize(int newCapacity) {
    Assert.isTrue(newCapacity > 0, "new capacity must be positive.");

    E[] newData = (E[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[(front + i) % data.length];
    }
    data = newData;
    front = 0;
    tail = size;
  }
}
