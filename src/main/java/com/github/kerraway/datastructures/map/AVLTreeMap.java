package com.github.kerraway.datastructures.map;

import com.github.kerraway.datastructures.tree.binarytree.AVLTree;

/**
 * @author kerraway
 * @date 2019/05/01
 */
public class AVLTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

  private AVLTree<K, V> avlTree;

  public AVLTreeMap() {
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
  public void add(K key, V value) {
    avlTree.add(key, value);
  }

  @Override
  public void set(K key, V newValue) {
    avlTree.set(key, newValue);
  }

  @Override
  public V get(K key) {
    return avlTree.get(key);
  }

  @Override
  public boolean contains(K key) {
    return avlTree.contains(key);
  }

  @Override
  public V remove(K key) {
    return avlTree.remove(key);
  }
}
