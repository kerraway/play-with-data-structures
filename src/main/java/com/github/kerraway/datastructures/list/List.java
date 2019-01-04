package com.github.kerraway.datastructures.list;

/**
 * @author 小柯
 * @date 2018/12/27
 */
public interface List<E> {

  /**
   * Get size of elements.
   *
   * @return int
   */
  int size();

  /**
   * If the size of elements is 0, return true.
   *
   * @return boolean
   */
  boolean isEmpty();

  /**
   * Add a element at the first of array.
   *
   * @param e
   */
  void addFirst(E e);

  /**
   * Add a element at the end of array.
   *
   * @param e
   */
  void addLast(E e);

  /**
   * Add a element at the specific index of array.
   *
   * @param index
   * @param e
   */
  void add(int index, E e);

  /**
   * Get the first element of array.
   *
   * @return E
   */
  E getFirst();

  /**
   * Get the last element of array.
   *
   * @return E
   */
  E getLast();

  /**
   * Get element which is at the index of array.
   *
   * @param index
   * @return E
   */
  E get(int index);

  /**
   * Set element at the index of array.
   *
   * @param index
   * @param e
   */
  void set(int index, E e);

  /**
   * If array contains e, return true.
   *
   * @param e
   * @return boolean
   */
  boolean contains(E e);

  /**
   * Remove the first element of array, and return this element.
   *
   * @return E
   */
  E removeFirst();

  /**
   * Remove the last element of array, and return this element.
   *
   * @return E
   */
  E removeLast();

  /**
   * Remove element at the index of array, and return this element.
   *
   * @param index
   * @return E
   */
  E remove(int index);

  /**
   * Remove element which equals to e from array.
   *
   * @param e
   */
  void removeElement(E e);

}
