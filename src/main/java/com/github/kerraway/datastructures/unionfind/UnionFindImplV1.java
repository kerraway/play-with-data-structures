package com.github.kerraway.datastructures.unionfind;

import com.github.kerraway.datastructures.util.Assert;

/**
 * V1 implement, without any optimizations.
 *
 * @author kerraway
 * @date 2019/2/26
 */
public class UnionFindImplV1 implements UnionFind {

  private int[] unionIds;

  public UnionFindImplV1(int size) {
    this.unionIds = new int[size];
    //init
    for (int i = 0; i < size; i++) {
      //every element points to itself
      unionIds[i] = i;
    }
  }

  @Override
  public int size() {
    return unionIds.length;
  }

  /**
   * If the two elements 'p' and 'q' are connected, returns true.
   * Time complexity: O(1).
   *
   * @param p
   * @param q
   * @return whether connected
   */
  @Override
  public boolean isConnected(int p, int q) {
    return get(p) == get(q);
  }

  /**
   * Unions two elements 'p' and 'q'.
   * Time complexity: O(n).
   *
   * @param p
   * @param q
   */
  @Override
  public void unionElements(int p, int q) {
    int pUnionId = get(p);
    int qUnionId = get(q);
    if (pUnionId == qUnionId) {
      return;
    }

    //traverse all elements
    for (int i = 0; i < unionIds.length; i++) {
      if (unionIds[i] == pUnionId) {
        unionIds[i] = qUnionId;
      }
    }
  }

  /**
   * Gets union id of the element i.
   * Time complexity: O(1).
   *
   * @param i
   * @return union id
   */
  private int get(int i) {
    Assert.isTrue(i >= 0 && i < size(), "i must be in [0, " + size() + ").");

    return unionIds[i];
  }
}
