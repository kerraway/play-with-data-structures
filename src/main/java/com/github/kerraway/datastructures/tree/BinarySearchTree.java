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

  public boolean contains(E e) {
    Assert.notNull(e, "e must not be null.");

    return contains(root, e);
  }

  /**
   * Preorder traversal.
   */
  public void preorderTraverse() {
    System.out.print("Preorder traversal: ");
    preorderTraverse(root);
    System.out.println();
  }

  /**
   * Inorder traversal.
   */
  public void inorderTraverse() {
    System.out.print("Inorder traversal: ");
    inorderTraverse(root);
    System.out.println();
  }

  /**
   * Post traversal.
   */
  public void postTraverse() {
    System.out.print("Postorder traversal: ");
    postTraverse(root);
    System.out.println();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    toString(root, 0, res);
    return res.toString();
  }

  /**
   * Adds element into the binary search tree which root is node.
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

  /**
   * If e is same as node's element, returns true.
   * If e is less than node's element, finds result in node's left subtree.
   * If e is greater than node's element, finds result in node's right subtree.
   * This method is recursive method.
   *
   * @param node
   * @param e
   * @return boolean
   */
  private boolean contains(Node node, E e) {
    if (node == null) {
      return false;
    }

    if (e.compareTo(node.e) == 0) {
      return true;
    }
    if (e.compareTo(node.e) < 0) {
      return contains(node.left, e);
    }
    return contains(node.right, e);
  }

  private void preorderTraverse(Node node) {
    if (node == null) {
      return;
    }

    System.out.printf("%s ", node.e);
    preorderTraverse(node.left);
    preorderTraverse(node.right);
  }

  private void inorderTraverse(Node node) {
    if (node == null) {
      return;
    }

    inorderTraverse(node.left);
    System.out.printf("%s ", node.e);
    inorderTraverse(node.right);
  }

  private void postTraverse(Node node) {
    if (node == null) {
      return;
    }

    postTraverse(node.left);
    postTraverse(node.right);
    System.out.printf("%s ", node.e);
  }

  /**
   * To string with current node, and appends string into res.
   * This method is recursive method.
   *
   * @param node
   * @param depth
   * @param res
   */
  private void toString(Node node, int depth, StringBuilder res) {
    if (node == null) {
      res.append(buildIndent(depth)).append((String) null).append('\n');
      return;
    }

    res.append(buildIndent(depth)).append(node.e).append('\n');
    toString(node.left, depth + 1, res);
    toString(node.right, depth + 1, res);
  }

  /**
   * Build indent for {@link #toString(Node, int, StringBuilder)} method.
   *
   * @param depth
   * @return String
   */
  private String buildIndent(int depth) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      res.append("--");
    }
    return res.toString();
  }

  private class Node {
    private E e;
    private Node left, right;

    Node(E e) {
      this.e = e;
      this.left = null;
      this.right = null;
    }
  }
}
