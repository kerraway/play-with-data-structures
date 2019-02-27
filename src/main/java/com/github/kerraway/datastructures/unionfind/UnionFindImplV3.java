package com.github.kerraway.datastructures.unionfind;

import com.github.kerraway.datastructures.util.Assert;

/**
 * @author kerraway
 * @date 2019/2/27
 */
public class UnionFindImplV3 implements UnionFind {

  /**
   * parentIds[i] denotes the index of this element's parent element.
   */
  private int[] parentIds;
  /**
   * sizes[i] denotes the size of elements in the tree which root is i.
   */
  private int[] sizes;

  public UnionFindImplV3(int size) {
    this.parentIds = new int[size];
    this.sizes = new int[size];
    //init
    for (int i = 0; i < size; i++) {
      //every element points to itself
      parentIds[i] = i;
      //and size is 1
      sizes[i] = 1;
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

    //merge the tree with less elements into the tree with more elements
    if (sizes[pFinalParentId] < sizes[qFinalParentId]) {
      parentIds[pFinalParentId] = qFinalParentId;
      sizes[qFinalParentId] += sizes[pFinalParentId];
    } else {
      parentIds[qFinalParentId] = parentIds[pFinalParentId];
      sizes[pFinalParentId] += sizes[qFinalParentId];
    }
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
