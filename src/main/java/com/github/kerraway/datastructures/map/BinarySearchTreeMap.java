package com.github.kerraway.datastructures.map;

/**
 * @author kerraway
 * @date 2019/2/15
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

  private Node root;
  private int size;

  public BinarySearchTreeMap() {
    this.root = null;
    this.size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void add(K key, V value) {
    root = add(root, key, value);
  }

  @Override
  public void set(K key, V newValue) {
    Node node = getNode(root, key);
    if (node != null) {
      node.value = newValue;
    }
  }

  @Override
  public V get(K key) {
    Node node = getNode(root, key);
    return node != null ? node.value : null;
  }

  @Override
  public boolean contains(K key) {
    return getNode(root, key) != null;
  }

  @Override
  public V remove(K key) {
    Node node = getNode(root, key);
    if (node != null) {
      root = removeNode(root, key);
      return node.value;
    }
    return null;
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

    return node;
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

    //removes nodes from node's left subtree
    if (key.compareTo(node.key) < 0) {
      node.left = removeNode(node.left, key);
      return node;
    }
    //removes nodes from node's right subtree
    if (key.compareTo(node.key) > 0) {
      node.right = removeNode(node.right, key);
      return node;
    }
    //hits the target
    //node's left subtree is null
    if (node.left == null) {
      Node rightNode = node.right;
      node.right = null;
      size--;
      return rightNode;
    }
    //node's right subtree is null
    if (node.right == null) {
      Node leftNode = node.left;
      node.left = null;
      size--;
      return leftNode;
    }
    //node's left and right subtrees aren't null
    //gets a successor which is the minimum node of node's right subtree
    //and uses it to replace the node
    Node successor = getMinNode(node.right);
    successor.right = removeMinNode(node.right);
    successor.left = node.left;
    node.left = node.right = null;
    return successor;
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

  /**
   * Removes minimum node from tree which root is the node param,
   * then returns the root of the processed tree.
   *
   * @param node
   * @return Node
   */
  private Node removeMinNode(Node node) {
    if (node == null) {
      return null;
    }
    if (node.left == null) {
      Node rightNode = node.right;
      node.right = null;
      size--;
      return rightNode;
    }

    node.left = removeMinNode(node.left);
    return node;
  }

  private class Node {
    K key;
    V value;
    Node left, right;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }

    @Override
    public String toString() {
      return key + " : " + value;
    }
  }
}
