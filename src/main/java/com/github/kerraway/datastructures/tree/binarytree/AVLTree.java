package com.github.kerraway.datastructures.tree.binarytree;

/**
 * @author kerraway
 * @date 2019/04/19
 */
public class AVLTree<K extends Comparable<K>, V> {

  private Node root;
  private int size;

  public AVLTree() {
    this.root = null;
    this.size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(K key, V value) {

  }

  public V set(K key, V newValue) {
    return null;
  }

  public boolean contains(K key) {
    return false;
  }

  public V get(K key) {
    return null;
  }

  public V remove(K key) {
    return null;
  }

  private class Node {
    private K key;
    private V value;
    private Node left, right;
    private int height;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
      this.height = 1;
    }
  }

}
