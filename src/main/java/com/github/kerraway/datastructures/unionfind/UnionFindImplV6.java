package com.github.kerraway.datastructures.unionfind;

import com.github.kerraway.datastructures.util.Assert;

/**
 * V6 implement, based on v5 implement, path compression uses recursive algorithm.
 *
 * @author kerraway
 * @date 2019/04/16
 */
public class UnionFindImplV6 implements UnionFind {

  /**
   * parentIds[i] denotes the index of this element's parent element.
   */
  private int[] parentIds;
  /**
   * ranks[i] denotes the rank of elements in the tree which root is i.
   */
  private int[] ranks;

  public UnionFindImplV6(int size) {
    this.parentIds = new int[size];
    this.ranks = new int[size];
    //init
    for (int i = 0; i < size; i++) {
      //every element points to itself
      parentIds[i] = i;
      //and rank is 1
      ranks[i] = 1;
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

    //merge the tree with smaller rank into the tree with bigger rank
    //the tree which root is pFinalParentId is smaller
    if (ranks[pFinalParentId] < ranks[qFinalParentId]) {
      parentIds[pFinalParentId] = qFinalParentId;
    }
    //the tree which root is qFinalParentId is smaller
    else if (ranks[pFinalParentId] > ranks[qFinalParentId]) {
      parentIds[qFinalParentId] = pFinalParentId;
    }
    //if two trees' rank is equal, merge and maintain the rank
    else {
      parentIds[pFinalParentId] = qFinalParentId;
      ranks[qFinalParentId] += 1;
    }
  }

  /**
   * Gets union id of the element i.
   * Time complexity: O(h), h is the height of tree.
   *
   * @param i
   * @return union id
   */
  public int get(int i) {
    Assert.isTrue(i >= 0 && i < size(), "i must be in [0, " + size() + ").");

    //path compression v2, recursive algorithm.
    if (i != parentIds[i]) {
      parentIds[i] = parentIds[parentIds[i]];
      i = parentIds[i];
    }
    return i;
  }

}
