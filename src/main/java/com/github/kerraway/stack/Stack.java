package com.github.kerraway.stack;

/**
 * @author 小柯
 * @date 2018/11/28
 */
public interface Stack<E> {

  /**
   * Get size of stack.
   *
   * @return int
   */
  int size();

  /**
   * If stack is empty, return true.
   *
   * @return boolean
   */
  boolean isEmpty();

  /**
   * Push element to the head of stack.
   *
   * @param e
   */
  void push(E e);

  /**
   * Peek element from the head of stack, but don't remove it.
   *
   * @return E
   */
  E peek();

  /**
   * Pop element from the head of stack.
   *
   * @return E
   */
  E pop();

}
