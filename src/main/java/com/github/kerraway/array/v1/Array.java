package com.github.kerraway.array.v1;

import com.github.kerraway.util.Assert;

/**
 * Simple Array, only support storage int element.
 *
 * @author kerraway
 * @date 2018/11/26
 */
public class Array {

  /**
   * Default initial capacity.
   */
  private static final int DEFAULT_CAPACITY = 10;

  /**
   * static array
   */
  private int[] data;
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
    this.data = new int[capacity];
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
  public void addFirst(int e) {
    add(0, e);
  }

  /**
   * Add a element at the end of array.
   *
   * @param e
   */
  public void addLast(int e) {
    add(size, e);
  }

  /**
   * Add a element at the specific index of array.
   *
   * @param index
   * @param e
   */
  public void add(int index, int e) {
    Assert.isTrue(size < capacity(), "add element failed, the data array is full.");
    Assert.isTrue(index >= 0 && index <= size, "add element failed, index must be in [0, " + size + "].");

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
   * @return int
   */
  public int get(int index) {
    Assert.isTrue(index >= 0 && index < size, "get element failed, index must be in [0, " + size + ").");

    return data[index];
  }

  /**
   * Set element at the index of array.
   *
   * @param index
   * @param e
   */
  public void set(int index, int e) {
    Assert.isTrue(index >= 0 && index < size, "set element failed, index must be in [0, " + size + ").");

    data[index] = e;
  }

  /**
   * If array contains e, return true.
   *
   * @param e
   * @return boolean
   */
  public boolean contains(int e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e) {
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
  public int indexOf(int e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Remove the first element of array, and return this element.
   *
   * @return int
   */
  public int removeFirst() {
    return remove(0);
  }

  /**
   * Remove the last element of array, and return this element.
   *
   * @return int
   */
  public int removeLast() {
    return remove(size - 1);
  }

  /**
   * Remove element at the index of array, and return this element.
   *
   * @param index
   * @return int
   */
  public int remove(int index) {
    Assert.isTrue(index >= 0 && index < size, "remove element failed, index must be in [0, " + size + ").");

    int ret = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size--;
    return ret;
  }

  /**
   * Remove element which equals to e from array.
   *
   * @param e
   */
  public void removeElement(int e) {
    int index = indexOf(e);
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
}
