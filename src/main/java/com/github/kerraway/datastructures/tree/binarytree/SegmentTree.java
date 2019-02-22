package com.github.kerraway.datastructures.tree.binarytree;

import com.github.kerraway.datastructures.util.Assert;

/**
 * The segment tree is a complete binary tree.
 * <pre>
 *                              arr[0, 8]
 *                        /                   \
 *                arr[0, 4]                   arr[5, 8]
 *                /       \                   /       \
 *          arr[0, 2]    arr[3, 4]     arr[5, 6]      arr[7, 8]
 *          /     \       /     \       /     \       /      \
 *     arr[0, 1] arr[2] arr[3] arr[4] arr[5] arr[6] arr[7] arr[8]
 *      /    \
 *   arr[0] arr[1]
 * </pre>
 *
 * @author kerraway
 * @date 2019/2/19
 */
public class SegmentTree<E> {

  private E[] tree;
  private E[] data;
  private Merger<E> merger;

  public SegmentTree(E[] arr, Merger<E> merger) {
    this.data = (E[]) new Object[arr.length];
    for (int i = 0; i < arr.length; i++) {
      data[i] = arr[i];
    }
    this.tree = (E[]) new Object[arr.length * 4];
    this.merger = merger;

    //build segment tree
    buildSegmentTree(0, 0, arr.length - 1);
  }

  public int size() {
    return data.length;
  }

  /**
   * Gets element by the index param.
   *
   * @param index
   * @return E
   */
  public E get(int index) {
    Assert.isTrue(index >= 0 && index < size(), "index must be in [0, " + size() + ").");

    return data[index];
  }

  /**
   * Gets element of range [queryL, queryR].
   *
   * @param queryL
   * @param queryR
   * @return E
   */
  public E query(int queryL, int queryR) {
    Assert.isTrue(queryL >= 0 && queryL < size(), "queryL must be in [0, " + size() + ").");
    Assert.isTrue(queryR >= 0 && queryR < size(), "queryR must be in [0, " + size() + ").");

    return query(0, 0, size() - 1, queryL, queryR);
  }

  /**
   * Sets the element at the index param to the e param.
   *
   * @param index
   * @param e
   */
  public void set(int index, E e) {
    Assert.isTrue(index >= 0 && index < size(), "index must be in [0, " + size() + ").");

    data[index] = e;
    set(0, 0, size() - 1, index, e);
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append('[');
    for (int i = 0; i < tree.length; i++) {
      if (tree[i] != null) {
        res.append(tree[i]);
      } else {
        res.append("null");
      }
      if (i != tree.length - 1) {
        res.append(", ");
      }
    }
    res.append(']');
    return res.toString();
  }

  /**
   * Sets the element at the index param to the e param in the segment tree
   * which root is treeIndex and range is [left, right].
   *
   * @param treeIndex
   * @param left
   * @param right
   * @param index
   * @param e
   */
  private void set(int treeIndex, int left, int right, int index, E e) {
    if (left == right) {
      tree[treeIndex] = e;
      return;
    }

    //divide the element at the treeIndex to parts: [left, middle] & [middle + 1, right]
    int middle = left + (right - left) / 2;
    int leftTreeIndex = getLeftChildIndex(treeIndex);
    int rightTreeIndex = getRightChildIndex(treeIndex);
    if (index >= middle + 1) {
      set(rightTreeIndex, middle + 1, right, index, e);
    } else {
      set(leftTreeIndex, left, middle, index, e);
    }

    tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
  }

  /**
   * Gets element of range [queryL, queryR] from the segment tree
   * which root is treeIndex and range is [left, right].
   *
   * @param treeIndex
   * @param left
   * @param right
   * @param queryL
   * @param queryR
   * @return E
   */
  private E query(int treeIndex, int left, int right, int queryL, int queryR) {
    if (left == queryL && right == queryR) {
      return tree[treeIndex];
    }

    int middle = left + (right - left) / 2;
    int leftTreeIndex = getLeftChildIndex(treeIndex);
    int rightTreeIndex = getRightChildIndex(treeIndex);
    //[left, middle] & [middle + 1, right]   |------|------|
    //[queryL, queryR]                                  |----|
    if (queryL >= middle + 1) {
      return query(rightTreeIndex, middle + 1, right, queryL, queryR);
    }
    //[left, middle] & [middle + 1, right]    |------|------|
    //[queryL, queryR]                      |----|
    if (queryR <= middle) {
      return query(leftTreeIndex, left, middle, queryL, queryR);
    }

    //[left, middle] & [middle + 1, right]    |-----|----|
    //[queryL, queryR]                          |------|
    E leftResult = query(leftTreeIndex, left, middle, queryL, middle);
    E rightResult = query(rightTreeIndex, middle + 1, right, middle + 1, queryR);
    return merger.merge(leftResult, rightResult);
  }

  /**
   * At the treeIndex position, build a segment tree which range is [left, right].
   *
   * @param treeIndex
   * @param left
   * @param right
   */
  private void buildSegmentTree(int treeIndex, int left, int right) {
    if (left > right) {
      return;
    }
    if (left == right) {
      tree[treeIndex] = data[left];
      return;
    }

    int leftTreeIndex = getLeftChildIndex(treeIndex);
    int rightTreeIndex = getRightChildIndex(treeIndex);
    //if use "int middle = (left + right) / 2;",
    //the sum may exceed the limit of Integer
    int middle = left + (right - left) / 2;
    buildSegmentTree(leftTreeIndex, left, middle);
    buildSegmentTree(rightTreeIndex, middle + 1, right);

    //merge children trees
    tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
  }

  /**
   * The array is a complete binary tree.
   * According to the index param, returns the index of its left child node.
   *
   * @param index
   * @return int
   */
  private int getLeftChildIndex(int index) {
    return index * 2 + 1;
  }

  /**
   * The array is a complete binary tree.
   * According to the index param, returns the index of its right child node.
   *
   * @param index
   * @return int
   */
  private int getRightChildIndex(int index) {
    return index * 2 + 2;
  }
}
