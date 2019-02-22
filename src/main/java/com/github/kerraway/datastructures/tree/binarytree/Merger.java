package com.github.kerraway.datastructures.tree.binarytree;

/**
 * @author kerraway
 * @date 2019/2/20
 */
public interface Merger<E> {

  /**
   * Merges two elements to a new element, and returns it.
   *
   * @param a
   * @param b
   * @return E
   */
  E merge(E a, E b);

}
