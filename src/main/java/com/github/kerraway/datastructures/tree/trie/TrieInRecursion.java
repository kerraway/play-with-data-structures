package com.github.kerraway.datastructures.tree.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author kerraway
 * @date 2019/2/25
 */
public class TrieInRecursion {

  private Node root;
  private int size;

  public TrieInRecursion() {
    this.root = new Node();
    this.size = 0;
  }

  /**
   * Gets the count of words from the trie.
   *
   * @return int
   */
  public int size() {
    return size;
  }

  /**
   * If the count of words equals to 0, returns true.
   *
   * @return boolean
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Adds word into the trie.
   *
   * @param word
   */
  public void add(String word) {
    add(root, word, 0);
  }

  /**
   * If the trie contains word, returns true.
   *
   * @param word
   * @return boolean
   */
  public boolean contains(String word) {
    return contains(root, word, 0);
  }

  /**
   * If the trie contains word which starts with prefix, returns true.
   *
   * @param prefix
   * @return boolean
   */
  public boolean startsWith(String prefix) {
    return startsWith(root, prefix, 0);
  }

  /**
   * Adds word into the trie by recursion.
   *
   * @param node
   * @param word
   * @param index
   */
  private void add(Node node, String word, int index) {
    if (index == word.length()) {
      if (!node.isWord) {
        node.isWord = true;
        size++;
      }
      return;
    }

    char ch = word.charAt(index);
    Node next = node.next.get(ch);
    if (next == null) {
      node.next.put(ch, (next = new Node()));
    }
    add(next, word, index + 1);
  }

  /**
   * Judge the word's existence by recursion.
   *
   * @param node
   * @param word
   * @param index
   * @return boolean
   */
  private boolean contains(Node node, String word, int index) {
    if (word.length() == index) {
      return node.isWord;
    }

    char ch = word.charAt(index);
    Node next = node.next.get(ch);
    if (next == null) {
      return false;
    }
    return contains(next, word, index + 1);
  }

  /**
   * Judge the prefix's existence by recursion.
   *
   * @param node
   * @param prefix
   * @param index
   * @return boolean
   */
  private boolean startsWith(Node node, String prefix, int index) {
    if (prefix.length() == index) {
      return true;
    }

    char ch = prefix.charAt(index);
    Node next = node.next.get(ch);
    if (next == null) {
      return false;
    }
    return startsWith(next, prefix, index + 1);
  }

  private class Node {
    boolean isWord;
    Map<Character, Node> next;

    Node(boolean isWord) {
      this.isWord = isWord;
      this.next = new TreeMap<>();
    }

    Node() {
      this(false);
    }
  }

}
