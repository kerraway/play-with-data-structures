package com.github.kerraway.datastructures.tree.binarytree;

import com.github.kerraway.datastructures.util.Assert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
   * Get min element from tree.
   *
   * @return E
   */
  public E getMin() {
    if (isEmpty()) {
      return null;
    }

    Node minNode = getMinNode(root);
    return minNode.e;
  }

  /**
   * Get max element from tree.
   *
   * @return E
   */
  public E getMax() {
    if (isEmpty()) {
      return null;
    }

    Node maxNode = getMaxNode(root);
    return maxNode.e;
  }

  /**
   * Remove min element from tree.
   *
   * @return E
   */
  public E removeMin() {
    if (isEmpty()) {
      return null;
    }

    E ret = getMin();
    root = removeMinNode(root);
    return ret;
  }

  /**
   * Remove max element from tree.
   *
   * @return E
   */
  public E removeMax() {
    if (isEmpty()) {
      return null;
    }

    E ret = getMax();
    root = removeMaxNode(root);
    return ret;
  }

  /**
   * Remove node that's e equals to e.
   *
   * @param e
   */
  public void remove(E e) {
    Assert.notNull(e, "e must not be null.");

    root = remove(root, e);
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
   * Preorder traversal without recursion.
   */
  public void preorderTraverseWithoutRecursion() {
    System.out.print("Preorder traversal without recursion: ");

    if (root == null) {
      return;
    }
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      System.out.printf("%s ", node.e);

      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
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
   * Postorder traversal.
   */
  public void postorderTraverse() {
    System.out.print("Postorder traversal: ");
    postorderTraverse(root);
    System.out.println();
  }

  /**
   * Level order traversal.
   */
  public void levelOrderTraverse() {
    System.out.print("Level order traversal: ");

    if (root == null) {
      return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      System.out.printf("%s ", node.e);

      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
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

  /**
   * Get min node with recursion.
   *
   * @param node
   * @return Node
   */
  private Node getMinNode(Node node) {
    if (node.left == null) {
      return node;
    }

    return getMinNode(node.left);
  }

  /**
   * Get max node with recursion.
   *
   * @param node
   * @return Node
   */
  private Node getMaxNode(Node node) {
    if (node.right == null) {
      return node;
    }

    return getMaxNode(node.right);
  }

  /**
   * Remove min node with recursion.
   *
   * @param node
   * @return Node
   */
  private Node removeMinNode(Node node) {
    if (node.left == null) {
      Node rightNode = node.right;
      node.right = null;
      size--;
      return rightNode;
    }

    node.left = removeMinNode(node.left);
    return node;
  }

  /**
   * Remove max node with recursion.
   *
   * @param node
   * @return Node
   */
  private Node removeMaxNode(Node node) {
    if (node.right == null) {
      Node leftNode = node.left;
      node.left = null;
      size--;
      return leftNode;
    }

    node.right = removeMaxNode(node.right);
    return node;
  }

  /**
   * Remove node with recursion.
   *
   * @param node
   * @param e
   */
  private Node remove(Node node, E e) {
    Assert.notNull(e, "e must not be null.");

    if (node == null) {
      return null;
    }

    if (e.compareTo(node.e) < 0) {
      node.left = remove(node.left, e);
      return node;
    }
    if (e.compareTo(node.e) > 0) {
      node.right = remove(node.right, e);
      return node;
    }
    //e.compareTo(node.e) == 0
    if (node.left == null) {
      Node rightNode = node.right;
      node.right = null;
      size--;
      return rightNode;
    }
    if (node.right == null) {
      Node leftNode = node.left;
      node.left = null;
      size--;
      return leftNode;
    }
    //node's left and right aren't null, find a node that's e is greater than node's e,
    //namely the min node in node's right, and use it to replace node.
    Node successor = getMinNode(node.right);
    successor.right = removeMinNode(node.right);
    successor.left = node.left;
    node.left = node.right = null;
    return successor;
  }

  /**
   * Preorder traversal with recursion.
   */
  private void preorderTraverse(Node node) {
    if (node == null) {
      return;
    }

    System.out.printf("%s ", node.e);
    preorderTraverse(node.left);
    preorderTraverse(node.right);
  }

  /**
   * Inorder traversal with recursion.
   */
  private void inorderTraverse(Node node) {
    if (node == null) {
      return;
    }

    inorderTraverse(node.left);
    System.out.printf("%s ", node.e);
    inorderTraverse(node.right);
  }

  /**
   * Postorder traversal with recursion.
   */
  private void postorderTraverse(Node node) {
    if (node == null) {
      return;
    }

    postorderTraverse(node.left);
    postorderTraverse(node.right);
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
