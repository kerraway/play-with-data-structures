package com.github.kerraway.datastructures.queue;

import com.github.kerraway.datastructures.heap.MaxHeap;

/**
 * @author kerraway
 * @date 2019/2/18
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

  private MaxHeap<E> maxHeap;

  public PriorityQueue() {
    this.maxHeap = new MaxHeap<>();
  }

  @Override
  public int size() {
    return maxHeap.size();
  }

  @Override
  public boolean isEmpty() {
    return maxHeap.isEmpty();
  }

  @Override
  public void enqueue(E e) {
    maxHeap.add(e);
  }

  @Override
  public E dequeue() {
    return maxHeap.extractMax();
  }

  @Override
  public E peek() {
    return maxHeap.findMax();
  }

}
