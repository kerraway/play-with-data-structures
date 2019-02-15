package com.github.kerraway.datastructures.set;

/**
 * @author kerraway
 * @date 2019/1/24
 */
public interface Set<E> {

  /**
   * Gets size of elements.
   *
   * @return int
   */
  int size();

  /**
   * If the size of elements is 0, returns true.
   *
   * @return boolean
   */
  boolean isEmpty();

  /**
   * Adds element.
   *
   * @param e
   */
  void add(E e);

  /**
   * If contains element, returns true.
   *
   * @param e
   * @return boolean
   */
  boolean contains(E e);

  /**
   * Removes element.
   *
   * @param e
   */
  void remove(E e);

}
