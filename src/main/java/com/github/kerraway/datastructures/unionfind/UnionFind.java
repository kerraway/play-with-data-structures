package com.github.kerraway.datastructures.unionfind;

/**
 * @author kerraway
 * @date 2019/2/26
 */
public interface UnionFind {

  /**
   * Gets the size of elements.
   *
   * @return the size of elements
   */
  int size();

  /**
   * If the two elements 'p' and 'q' are connected, returns true.
   *
   * @param p
   * @param q
   * @return whether connected
   */
  boolean isConnected(int p, int q);

  /**
   * Unions two elements 'p' and 'q'.
   *
   * @param p
   * @param q
   */
  void unionElements(int p, int q);

}
