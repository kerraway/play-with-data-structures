package com.github.kerraway.datastructures.set;

import com.github.kerraway.datastructures.tree.binarytree.BinarySearchTree;

/**
 * @author kerraway
 * @date 2019/1/24
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

  private BinarySearchTree<E> bst;

  public BinarySearchTreeSet() {
    this.bst = new BinarySearchTree<>();
  }

  @Override
  public int size() {
    return bst.size();
  }

  @Override
  public boolean isEmpty() {
    return bst.isEmpty();
  }

  @Override
  public void add(E e) {
    bst.add(e);
  }

  @Override
  public boolean contains(E e) {
    return bst.contains(e);
  }

  @Override
  public void remove(E e) {
    bst.remove(e);
  }
}
