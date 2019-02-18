package com.github.kerraway.datastructures.heap;

import com.github.kerraway.datastructures.list.array.v2.ArrayList;
import com.github.kerraway.datastructures.util.Assert;

/**
 * The heap is a complete binary tree.
 * <pre>
 *          50
 *          [0]
 *      /         \
 *     40         60
 *     [1]        [2]
 *    /    \      /  \
 *   25    45    55   65
 *   [3]   [4]   [5]  [6]
 *   / \   /
 *  12 20 30
 *  [7][8][9]
 * </pre>
 * Use an array to store this heap.
 * <pre>
 * elements:  50, 40, 60, 25, 45, 55, 65, 12, 20, 30
 * index:     [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
 * </pre>
 *
 * @author kerraway
 * @date 2019/2/18
 */
public class MaxHeap<E extends Comparable<E>> {

  private ArrayList<E> array;

  public MaxHeap(int capacity) {
    this.array = new ArrayList<>(capacity);
  }

  public MaxHeap() {
    this.array = new ArrayList<>();
  }

  /**
   * Constructor, init the array by the param array, and heapify the array.
   *
   * @param array
   */
  public MaxHeap(E[] array) {
    this.array = new ArrayList<>(array);
    for (int i = getParentIndex(array.length); i >= 0; i--) {
      siftDown(i);
    }
  }

  /**
   * Gets size of the heap.
   *
   * @return int
   */
  public int size() {
    return array.size();
  }

  /**
   * If the heap is empty, returns true.
   *
   * @return boolean
   */
  public boolean isEmpty() {
    return array.isEmpty();
  }

  /**
   * Adds element into the heap.
   *
   * @param e
   */
  public void add(E e) {
    array.addLast(e);
    siftUp(size() - 1);
  }

  /**
   * Find the max element from the heap.
   *
   * @return E
   */
  public E findMax() {
    Assert.isFalse(isEmpty(), "Heap is empty.");

    return array.get(0);
  }

  /**
   * Extract the max element from the heap.
   *
   * @return E
   */
  public E extractMax() {
    E max = findMax();

    swap(0, size() - 1);
    array.removeLast();
    siftDown(0);

    return max;
  }

  /**
   * Extract the max element from the heap, and replace it with the param e.
   *
   * @param e
   * @return E
   */
  public E replaceMax(E e) {
    E max = findMax();

    array.set(0, e);
    siftDown(0);

    return max;
  }

  /**
   * Sifts up.
   *
   * @param index
   */
  private void siftUp(int index) {
    while (index > 0 && array.get(getParentIndex(index)).compareTo(array.get(index)) < 0) {
      swap(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  /**
   * Sifts down.
   *
   * @param index
   */
  private void siftDown(int index) {
    while (getLeftChildIndex(index) < size()) {
      int leftChildIndex = getLeftChildIndex(index);
      int rightChildIndex = getRightChildIndex(index);
      //get largish child node's index
      int largishChildIndex = rightChildIndex < size()
          && array.get(rightChildIndex).compareTo(array.get(leftChildIndex)) > 0
          ? rightChildIndex : leftChildIndex;

      //if the node is greater than the largin child node, break
      if (array.get(index).compareTo(array.get(largishChildIndex)) >= 0) {
        break;
      }

      //swap
      swap(index, largishChildIndex);
      index = largishChildIndex;
    }
  }

  /**
   * Swaps two elements.
   *
   * @param i
   * @param j
   */
  private void swap(int i, int j) {
    Assert.isTrue(i >= 0 && i < size(), "i must be in the range of array.");
    Assert.isTrue(j >= 0 && j < size(), "j must be in the range of array.");

    E temp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, temp);
  }

  /**
   * The array is a complete binary tree.
   * According to the param index, returns the index of the parent node.
   *
   * @param index
   * @return int
   */
  private int getParentIndex(int index) {
    Assert.isTrue(index > 0, "index must be greater than 0.");

    return (index - 1) / 2;
  }

  /**
   * The array is a complete binary tree.
   * According to the param index, returns the index of the left child node.
   *
   * @param index
   * @return int
   */
  private int getLeftChildIndex(int index) {
    return index * 2 + 1;
  }

  /**
   * The array is a complete binary tree.
   * According to the param index, returns the index of the right child node.
   *
   * @param index
   * @return int
   */
  private int getRightChildIndex(int index) {
    return index * 2 + 2;
  }
}
