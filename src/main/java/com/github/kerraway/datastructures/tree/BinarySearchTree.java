package com.github.kerraway.datastructures.tree;

import com.github.kerraway.datastructures.util.Assert;

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

    root = add(root, e);
  }

  /**
   * Add element into the binary search tree which root is node.
   * This method is recursive method.
   *
   * @param node
   * @param e
   * @return Node
   */
  private Node add(Node node, E e) {
    if (node == null) {
      size++;
      return new Node(e);
    }

    if (e.compareTo(node.e) < 0) {
      node.left = add(node.left, e);
    } else if (e.compareTo(node.e) > 0) {
      node.right = add(node.right, e);
    }
    return node;
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
