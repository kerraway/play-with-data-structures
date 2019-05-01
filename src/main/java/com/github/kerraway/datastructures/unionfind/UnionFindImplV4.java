package com.github.kerraway.datastructures.unionfind;

import com.github.kerraway.datastructures.util.Assert;

/**
 * V4 implement, uses an array, names {@link #parentIds}, to record
 * the index of element's parent element, and uses another array,
 * names {@link #heights}, to record the height of elements tree.
 *
 * @author kerraway
 * @date 2019/04/16
 */
public class UnionFindImplV4 implements UnionFind {

  /**
   * parentIds[i] denotes the index of this element's parent element.
   */
  private int[] parentIds;
  /**
   * heights[i] denotes the rank of elements in the tree which root is i.
   */
  private int[] heights;

  public UnionFindImplV4(int size) {
    this.parentIds = new int[size];
    this.heights = new int[size];
    //init
    for (int i = 0; i < size; i++) {
      //every element points to itself
      parentIds[i] = i;
      //and height is 1
      heights[i] = 1;
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

    //merge the tree with smaller height into the tree with bigger height
    //the tree which root is pFinalParentId is smaller
    if (heights[pFinalParentId] < heights[qFinalParentId]) {
      parentIds[pFinalParentId] = qFinalParentId;
    }
    //the tree which root is qFinalParentId is smaller
    else if (heights[pFinalParentId] > heights[qFinalParentId]) {
      parentIds[qFinalParentId] = pFinalParentId;
    }
    //if two trees' height is equal, merge and maintain the height
    else {
      parentIds[pFinalParentId] = qFinalParentId;
      heights[qFinalParentId] += 1;
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

    while (i != parentIds[i]) {
      i = parentIds[i];
    }
    return i;
  }
}
