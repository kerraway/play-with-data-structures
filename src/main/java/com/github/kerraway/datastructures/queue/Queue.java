package com.github.kerraway.datastructures.queue;

/**
 * FIFO (First in, First out)
 *
 * @author kerraway
 * @date 2018/11/30
 */
public interface Queue<E> {

  /**
   * Get size of queue.
   *
   * @return int
   */
  int size();

  /**
   * If queue is empty, return true.
   *
   * @return boolean
   */
  boolean isEmpty();

  /**
   * Enqueue an element into queue.
   *
   * @param e
   */
  void enqueue(E e);

  /**
   * Dequeue an element from queue.
   *
   * @return E
   */
  E dequeue();

  /**
   * Peek element from the head of queue, but don't remove it.
   *
   * @return E
   */
  E peek();
}
