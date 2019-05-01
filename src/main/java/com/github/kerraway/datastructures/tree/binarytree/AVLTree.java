package com.github.kerraway.datastructures.tree.binarytree;

import com.github.kerraway.datastructures.util.Assert;

/**
 * AVL tree.
 *
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
    root = add(root, key, value);
  }

  public void set(K key, V newValue) {
    Node node = getNode(root, key);
    if (node != null) {
      node.value = newValue;
    }
  }

  public V get(K key) {
    Node node = getNode(root, key);
    return node != null ? node.value : null;
  }

  public boolean contains(K key) {
    return getNode(root, key) != null;
  }

  public V remove(K key) {
    Node node = getNode(root, key);
    if (node != null) {
      root = removeNode(root, key);
      return node.value;
    }
    return null;
  }

  /**
   * If the tree is a binary search tree, returns true.
   *
   * @return is a binary search tree or not.
   */
  public boolean isBinarySearchTree() {
    return isBinarySearchTree(root);
  }

  /**
   * If the tree is balanced, returns true.
   *
   * @return is balanced or not.
   */
  public boolean isBalanced() {
    return isBalanced(root);
  }

  /**
   * Gets the height of node.
   *
   * @param node
   * @return the height of node.
   */
  private int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  /**
   * Calculates the height of node.
   *
   * @param node
   * @return the height of node.
   */
  private int calcHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
  }

  /**
   * Gets the balance factor of node.
   *
   * @param node
   * @return the balance factor of node.
   */
  private int getBalanceFactor(Node node) {
    if (node == null) {
      return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  /**
   * If the tree, which root is the node, is balanced, returns true.
   *
   * @param node
   * @return the tree, which root is the node, is balanced or not.
   */
  private boolean isBalanced(Node node) {
    if (node == null) {
      return true;
    }

    int balanceFactor = getBalanceFactor(node);
    if (Math.abs(balanceFactor) > 1) {
      return false;
    }
    return isBalanced(node.left) && isBalanced(node.right);
  }

  /**
   * If the tree, which root is the node, is a binary search tree, returns true.
   *
   * @param node
   * @return the tree, which root is the node, is a binary search tree or not.
   */
  private boolean isBinarySearchTree(Node node) {
    if (node == null) {
      return true;
    }

    if ((node.left != null && node.left.key.compareTo(node.key) > 0)
        || (node.right != null && node.key.compareTo(node.right.key) > 0)) {
      return false;
    }
    return isBinarySearchTree(node.left) && isBinarySearchTree(node.right);
  }

  /**
   * The node is the root of tree, adds key and value into the tree,
   * then returns the root of tree.
   *
   * @param node
   * @param key
   * @param value
   * @return Node
   */
  private Node add(Node node, K key, V value) {
    if (node == null) {
      size++;
      return new Node(key, value);
    }

    //adds key and value into node's left subtree
    if (key.compareTo(node.key) < 0) {
      node.left = add(node.left, key, value);
    }
    //adds key and value into node's right subtree
    else if (key.compareTo(node.key) > 0) {
      node.right = add(node.right, key, value);
    }
    //replaces node's value
    else {
      node.value = value;
    }

    //updates height
    node.height = calcHeight(node);
    //maintains balance
    return maintainBalance(node);
  }

  /**
   * Maintains the balance of tree which root is node.
   *
   * @param node
   * @return the tree's root.
   */
  private Node maintainBalance(Node node) {
    Assert.notNull(node, "node must not be null.");

    //calculates balance factor
    int balanceFactor = getBalanceFactor(node);
    //maintains balance if unbalanced
    //LL
    if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
      return rightRotate(node);
    }
    //RR
    if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
      return leftRotate(node);
    }
    //LR
    if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
      //converts to LL
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    //RL
    if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
      //converts to RR
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    //already balanced
    return node;
  }

  /**
   * Rotates node y to right, and returns the new root x.
   * <pre>
   *        y                                    x
   *       / \                                 /   \
   *      x  t4                               z     y
   *     / \     -- rotates y to right -->   / \   / \
   *    z  t3                               t1 t2 t3 t4
   *   / \
   *  t1 t2
   * </pre>
   *
   * @param y
   * @return the tree's new root x.
   */
  private Node rightRotate(Node y) {
    Assert.notNull(y, "y must not be null.");
    Assert.notNull(y.left, "y.left must not be null.");

    Node x = y.left;
    Node t3 = x.right;
    //rotates y to right
    x.right = y;
    y.left = t3;
    //updates height
    y.height = calcHeight(y);
    x.height = calcHeight(x);
    //returns new root
    return x;
  }

  /**
   * Rotates node y to left, and returns the new root x.
   * <pre>
   *    y                                        x
   *   / \                                     /   \
   *  t1  x                                   y     z
   *     / \     -- rotates y to left -->    / \   / \
   *    t2  z                               t1 t2 t3 t4
   *       / \
   *      t3 t4
   * </pre>
   *
   * @param y
   * @return the tree's new root x.
   */
  private Node leftRotate(Node y) {
    Assert.notNull(y, "y must not be null.");
    Assert.notNull(y.right, "y.right must not be null.");

    Node x = y.right;
    Node t2 = x.left;
    //rotates y to left
    x.left = y;
    y.right = t2;
    //updates height
    y.height = calcHeight(y);
    x.height = calcHeight(x);
    //returns new root
    return x;
  }

  /**
   * The node is the root of tree, finds node which key equals the key param,
   * then returns the node.
   *
   * @param node
   * @param key
   * @return Node
   */
  private Node getNode(Node node, K key) {
    if (node == null) {
      return null;
    }

    //gets node from node's left subtree
    if (key.compareTo(node.key) < 0) {
      return getNode(node.left, key);
    }
    //gets node from node's right subtree
    if (key.compareTo(node.key) > 0) {
      return getNode(node.right, key);
    }
    //hits the target
    return node;
  }

  /**
   * The node is the root of tree, removes node which key equals the key param,
   * then returns the root of the processed tree.
   *
   * @param node
   * @param key
   * @return Node
   */
  private Node removeNode(Node node, K key) {
    if (node == null) {
      return null;
    }

    Node retNode;
    //removes nodes from node's left subtree
    if (key.compareTo(node.key) < 0) {
      node.left = removeNode(node.left, key);
      retNode = node;
    }
    //removes nodes from node's right subtree
    else if (key.compareTo(node.key) > 0) {
      node.right = removeNode(node.right, key);
      retNode = node;
    }
    //hits the target
    //node's left subtree is null
    else if (node.left == null) {
      Node rightNode = node.right;
      node.right = null;
      size--;
      retNode = rightNode;
    }
    //node's right subtree is null
    else if (node.right == null) {
      Node leftNode = node.left;
      node.left = null;
      size--;
      retNode = leftNode;
    }
    //node's left and right subtrees aren't null
    //gets a successor which is the minimum node of node's right subtree
    //and uses it to replace the node
    else {
      Node successor = getMinNode(node.right);
      successor.right = removeNode(node.right, successor.key);
      successor.left = node.left;
      node.left = node.right = null;
      retNode = successor;
    }

    if (retNode == null) {
      return null;
    }
    //updates height
    retNode.height = calcHeight(retNode);
    //maintains balance
    return maintainBalance(retNode);
  }

  /**
   * Gets minimum node from tree which root is the node param.
   *
   * @param node
   * @return Node
   */
  private Node getMinNode(Node node) {
    if (node == null) {
      return null;
    }
    if (node.left == null) {
      return node;
    }
    return getMinNode(node.left);
  }

  private class Node {
    K key;
    V value;
    Node left, right;
    int height;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
      this.height = 1;
    }

    @Override
    public String toString() {
      return key + " : " + value;
    }
  }
}
