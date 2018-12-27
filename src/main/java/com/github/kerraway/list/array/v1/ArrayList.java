package com.github.kerraway.list.array.v1;

import com.github.kerraway.list.List;
import com.github.kerraway.util.Assert;

/**
 * Simple array list, only support storage {@link Integer} element.
 *
 * @author kerraway
 * @date 2018/11/26
 */
public class ArrayList implements List<Integer> {

  /**
   * Default initial capacity.
   */
  private static final int DEFAULT_CAPACITY = 10;

  /**
   * static array
   */
  private Integer[] data;
  /**
   * the size of elements
   */
  private int size;

  /**
   * Constructor, init static array by the capacity argument.
   *
   * @param capacity
   */
  public ArrayList(int capacity) {
    this.data = new Integer[capacity];
    this.size = 0;
  }

  /**
   * No argument constructor, default capacity is 10.
   */
  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }

  /**
   * Get capacity: the length of static array.
   *
   * @return int
   */
  @Override
  public int capacity() {
    return data.length;
  }

  /**
   * Get size of elements.
   *
   * @return int
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * If the size of elements is 0, return true.
   *
   * @return boolean
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Add a element at the first of array.
   *
   * @param e
   */
  @Override
  public void addFirst(Integer e) {
    add(0, e);
  }

  /**
   * Add a element at the end of array.
   *
   * @param e
   */
  @Override
  public void addLast(Integer e) {
    add(size, e);
  }

  /**
   * Add a element at the specific index of array.
   *
   * @param index
   * @param e
   */
  @Override
  public void add(int index, Integer e) {
    Assert.isTrue(size < capacity(), "add element failed, the data array is full.");
    Assert.isTrue(index >= 0 && index <= size, "add element failed, index must be in [0, " + size + "].");

    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = e;
    size++;
  }

  /**
   * Get the first element of array.
   *
   * @return E
   */
  @Override
  public Integer getFirst() {
    return get(0);
  }

  /**
   * Get the last element of array.
   *
   * @return E
   */
  @Override
  public Integer getLast() {
    return get(size - 1);
  }

  /**
   * Get element which is at the index of array.
   *
   * @param index
   * @return int
   */
  @Override
  public Integer get(int index) {
    Assert.isTrue(index >= 0 && index < size, "get element failed, index must be in [0, " + size + ").");

    return data[index];
  }

  /**
   * Set element at the index of array.
   *
   * @param index
   * @param e
   */
  @Override
  public void set(int index, Integer e) {
    Assert.isTrue(index >= 0 && index < size, "set element failed, index must be in [0, " + size + ").");

    data[index] = e;
  }

  /**
   * If array contains e, return true.
   *
   * @param e
   * @return boolean
   */
  @Override
  public boolean contains(Integer e) {
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
  @Override
  public int indexOf(Integer e) {
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
  @Override
  public Integer removeFirst() {
    return remove(0);
  }

  /**
   * Remove the last element of array, and return this element.
   *
   * @return int
   */
  @Override
  public Integer removeLast() {
    return remove(size - 1);
  }

  /**
   * Remove element at the index of array, and return this element.
   *
   * @param index
   * @return int
   */
  @Override
  public Integer remove(int index) {
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
  @Override
  public void removeElement(Integer e) {
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
