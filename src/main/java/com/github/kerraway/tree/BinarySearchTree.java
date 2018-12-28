package com.github.kerraway.tree;

import com.github.kerraway.util.Assert;

/**
 * Binary search tree.
 *
 * @author kerraway
 * @date 2018/12/28
 */
public class BinarySearchTree<E extends Comparable<E>> {

  private Node root;
  private int size;

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(E e) {
    Assert.notNull(e, "e must not be null.");

    if (root == null) {
      root = new Node(e);
      size++;
      return;
    }

    add(root, e);
  }

  /**
   * Add element into the binary search tree which root is node.
   * This method is recursive method.
   *
   * @param node
   * @param e
   */
  private void add(Node node, E e) {
    if (e.equals(node.e)) {
      return;
    }
    if (e.compareTo(node.e) < 0 && node.left == null) {
      node.left = new Node(e);
      size++;
      return;
    }
    if (e.compareTo(node.e) > 0 && node.right == null) {
      node.right = new Node(e);
      size++;
      return;
    }

    if (e.compareTo(node.e) < 0) {
      add(node.left, e);
      return;
    }
    //e.compareTo(node.e) > 0
    add(node.right, e);
  }

  private class Node {
    private E e;
    private Node left, right;

    public Node(E e) {
      this.e = e;
      this.left = null;
      this.right = null;
    }
  }
}
