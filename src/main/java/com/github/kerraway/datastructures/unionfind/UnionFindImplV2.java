package com.github.kerraway.datastructures.unionfind;

import com.github.kerraway.datastructures.util.Assert;

/**
 * V2 implement, uses an array, names {@link #parentIds}, to record
 * the index of element's parent element.
 *
 * @author kerraway
 * @date 2019/2/27
 */
public class UnionFindImplV2 implements UnionFind {

  /**
   * parentIds[i] means the index of this element's parent element.
   */
  private int[] parentIds;

  public UnionFindImplV2(int size) {
    this.parentIds = new int[size];
    //init
    for (int i = 0; i < size; i++) {
      //every element points to itself
      parentIds[i] = i;
    }
  }

  @Override
  public int size() {
    return parentIds.length;
  }

  /**
   * If the two elements 'p' and 'q' are connected, returns true.
   * Time complexity: O(h), h is the height of tree.
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
   * Time complexity: O(h), h is the height of tree.
   *
   * @param p
   * @param q
   */
  @Override
  public void unionElements(int p, int q) {
    int pFinalParentId = get(p);
    int qFinalParentId = get(q);
    if (pFinalParentId == qFinalParentId) {
      return;
    }
    parentIds[pFinalParentId] = qFinalParentId;
  }

  /**
   * Gets union id of the element i.
   * Time complexity: O(h), h is the height of tree.
   *
   * @param i
   * @return union id
   */
  private int get(int i) {
    Assert.isTrue(i >= 0 && i < size(), "i must be in [0, " + size() + ").");

    //uses loop to get the root element
    while (i != parentIds[i]) {
      i = parentIds[i];
    }
    return i;
  }

}
