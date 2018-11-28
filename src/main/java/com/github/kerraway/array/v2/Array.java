package com.github.kerraway.array.v2;

import com.github.kerraway.util.Assert;

/**
 * Array, support generic.
 *
 * @author 小柯
 * @date 2018/11/26
 */
public class Array<E> {

  /**
   * Default initial capacity.
   */
  private static final int DEFAULT_CAPACITY = 10;
  /**
   * Resize factor.
   */
  private static final int RESIZE_FACTOR = 2;

  /**
   * static array
   */
  private E[] data;
  /**
   * the size of elements
   */
  private int size;

  /**
   * Constructor, init static array by the capacity argument.
   *
   * @param capacity
   */
  public Array(int capacity) {
    this.data = (E[]) new Object[capacity];
    this.size = 0;
  }

  /**
   * No argument constructor, default capacity is 10.
   */
  public Array() {
    this(DEFAULT_CAPACITY);
  }

  /**
   * Get capacity: the length of static array.
   *
   * @return int
   */
  public int capacity() {
    return data.length;
  }

  /**
   * Get size of elements.
   *
   * @return int
   */
  public int size() {
    return size;
  }

  /**
   * If the size of elements is 0, return true.
   *
   * @return boolean
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Add a element at the first of array.
   *
   * @param e
   */
  public void addFirst(E e) {
    add(0, e);
  }

  /**
   * Add a element at the end of array.
   *
   * @param e
   */
  public void addLast(E e) {
    add(size, e);
  }

  /**
   * Add a element at the specific index of array.
   *
   * @param index
   * @param e
   */
  public void add(int index, E e) {
    Assert.isTrue(index >= 0 && index <= size, "add element failed, index must be in [0, " + size + "].");

    if (size == capacity()) {
      resize(RESIZE_FACTOR * capacity());
    }
    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = e;
    size++;
  }

  /**
   * Get element which is at the index of array.
   *
   * @param index
   * @return E
   */
  public E get(int index) {
    Assert.isTrue(index >= 0 && index < size, "get element failed, index must be in [0, " + size + ").");

    return data[index];
  }

  /**
   * Set element at the index of array.
   *
   * @param index
   * @param e
   */
  public void set(int index, E e) {
    Assert.isTrue(index >= 0 && index < size, "set element failed, index must be in [0, " + size + ").");

    data[index] = e;
  }

  /**
   * If array contains e, return true.
   *
   * @param e
   * @return boolean
   */
  public boolean contains(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e || (data[i] != null && data[i].equals(e))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Find e from array, and return the index of e.
   * If e doesn't exist in array, return - 1.
   *
   * @param e
   * @return int
   */
  public int index(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e || (data[i] != null && data[i].equals(e))) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Remove the first element of array, and return this element.
   *
   * @return E
   */
  public E removeFirst() {
    return remove(0);
  }

  /**
   * Remove the last element of array, and return this element.
   *
   * @return E
   */
  public E removeLast() {
    return remove(size - 1);
  }

  /**
   * Remove element at the index of array, and return this element.
   *
   * @param index
   * @return E
   */
  public E remove(int index) {
    Assert.isTrue(index >= 0 && index < size, "remove element failed, index must be in [0, " + size + ").");

    E ret = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size--;
    //if size equals to 1/3 capacity, resize capacity to 1/2 capacity
    if (size == capacity() / 3) {
      resize(capacity() / RESIZE_FACTOR);
    }
    return ret;
  }

  /**
   * Remove element which equals to e from array.
   *
   * @param e
   */
  public void removeElement(E e) {
    int index = index(e);
    if (index != -1) {
      remove(index);
    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Array: size = ").append(size).append(", ");
    res.append("capacity = ").append(capacity()).append(", ");
    res.append("elements = [");
    for (int i = 0; i < size; i++) {
      res.append(data[i]);
      if (i != size - 1) {
        res.append(", ");
      }
    }
    res.append("]");
    return res.toString();
  }

  /**
   * Adjust static array's capacity to new capacity.
   *
   * @param newCapacity
   */
  private void resize(int newCapacity) {
    E[] newData = (E[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }
}
