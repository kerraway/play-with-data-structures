package com.github.kerraway.queue.loop.v1;

import com.github.kerraway.queue.Queue;
import com.github.kerraway.util.Assert;

/**
 * This version wastes one space to insure ({@link #tail} + 1)
 * % {@link #data}.length < {@link #front}.
 * And use {@link #size} to simplify methods.
 *
 * @author kerraway
 * @date 2018/12/26
 */
public class LoopQueue<E> implements Queue<E> {

  private E[] data;
  private int front, tail;
  private int size;

  public LoopQueue(int capacity) {
    this.data = (E[]) new Object[capacity + 1];
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
    return front == tail;
  }

  @Override
  public void enqueue(E e) {
    if ((tail + 1) % data.length == front) {
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
    for (int i = front; i != tail; i = (i + 1) % data.length) {
      res.append(data[i]);
      if ((i + 1) % data.length != tail) {
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
    return data.length - 1;
  }

  /**
   * Adjust static array's capacity to new capacity.
   *
   * @param newCapacity
   */
  private void resize(int newCapacity) {
    Assert.isTrue(newCapacity > 0, "new capacity must be positive.");

    E[] newData = (E[]) new Object[newCapacity + 1];
    for (int i = 0; i < size; i++) {
      newData[i] = data[(front + i) % data.length];
    }
    data = newData;
    front = 0;
    tail = size;
  }
}
