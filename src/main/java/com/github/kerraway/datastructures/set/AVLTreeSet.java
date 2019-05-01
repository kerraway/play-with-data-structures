package com.github.kerraway.datastructures.set;

import com.github.kerraway.datastructures.tree.binarytree.AVLTree;

/**
 * @author kerraway
 * @date 2019/05/01
 */
public class AVLTreeSet<E extends Comparable<E>> implements Set<E> {

  private AVLTree<E, Object> avlTree;

  public AVLTreeSet() {
    this.avlTree = new AVLTree<>();
  }

  @Override
  public int size() {
    return avlTree.size();
  }

  @Override
  public boolean isEmpty() {
    return avlTree.isEmpty();
  }

  @Override
  public void add(E e) {
    avlTree.add(e, null);
  }

  @Override
  public boolean contains(E e) {
    return avlTree.contains(e);
  }

  @Override
  public void remove(E e) {
    avlTree.remove(e);
  }
}
