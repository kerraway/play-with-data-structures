package com.github.kerraway.datastructures.map;

/**
 * @author kerraway
 * @date 2019/2/15
 */
public class LinkedListMap<K, V> implements Map<K, V> {

  private Node dummyHead;
  private int size;

  public LinkedListMap() {
    this.dummyHead = new Node();
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
    Node node = getNode(key);
    if (node == null) {
      dummyHead.next = new Node(key, value, dummyHead.next);
      size++;
    } else {
      node.value = value;
    }
  }

  @Override
  public void set(K key, V newValue) {
    Node node = getNode(key);
    if (node != null) {
      node.value = newValue;
    }
  }

  @Override
  public V get(K key) {
    Node node = getNode(key);
    return node != null ? node.value : null;
  }

  @Override
  public boolean contains(K key) {
    return getNode(key) != null;
  }

  @Override
  public V remove(K key) {
    Node prev = this.dummyHead;
    while (prev.next != null) {
      if (prev.next.key.equals(key)) {
        break;
      }
      prev = prev.next;
    }
    if (prev.next != null) {
      Node deleteNode = prev.next;
      prev.next = deleteNode.next;
      deleteNode.next = null;
      size--;
      return deleteNode.value;
    }
    return null;
  }

  /**
   * Get node by key from linked list.
   *
   * @param key
   * @return Node
   */
  private Node getNode(K key) {
    Node cursor = dummyHead.next;
    while (cursor != null) {
      if (cursor.key.equals(key)) {
        return cursor;
      }
      cursor = cursor.next;
    }
    return null;
  }

  private class Node {
    K key;
    V value;
    Node next;

    public Node(K key, V value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public Node(K key, V value) {
      this(key, value, null);
    }

    public Node() {
      this(null, null, null);
    }

    @Override
    public String toString() {
      return key + " : " + value;
    }
  }
}
