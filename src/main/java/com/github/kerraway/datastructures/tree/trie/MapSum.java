package com.github.kerraway.datastructures.tree.trie;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author kerraway
 * @date 2019/2/25
 */
public class MapSum {

  private Node root;

  public MapSum() {
    this.root = new Node();
  }

  /**
   * Inserts key and value.
   *
   * @param key
   * @param value
   */
  public void insert(String key, int value) {
    Node cursor = root;
    for (int i = 0; i < key.length(); i++) {
      char ch = key.charAt(i);
      Node next = cursor.next.get(ch);
      if (next == null) {
        cursor.next.put(ch, (next = new Node()));
      }
      cursor = next;
    }
    cursor.value = value;
  }

  /**
   * Returns the sum of values which starts with prefix.
   *
   * @param prefix
   * @return int
   */
  public int sum(String prefix) {
    Node cursor = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      Node next = cursor.next.get(ch);
      if (next == null) {
        return 0;
      }
      cursor = next;
    }
    return sum(cursor);
  }

  /**
   * Returns the sum of node and node's sub nodes.
   *
   * @param node
   * @return int
   */
  private int sum(Node node) {
    int res = node.value;
    Collection<Node> nextNodes = node.next.values();
    for (Node nextNode : nextNodes) {
      res += sum(nextNode);
    }
    return res;
  }

  private class Node {
    int value;
    Map<Character, Node> next;

    Node(int value) {
      this.value = value;
      this.next = new TreeMap<>();
    }

    Node() {
      this(0);
    }
  }

}