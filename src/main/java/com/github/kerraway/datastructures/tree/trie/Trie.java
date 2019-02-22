package com.github.kerraway.datastructures.tree.trie;

import java.util.TreeMap;

/**
 * @author kerraway
 * @date 2019/2/22
 */
public class Trie {

  private Node root;
  private int size;

  public Trie() {
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
    Node cursor = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node next = cursor.next.get(ch);
      if (next == null) {
        cursor.next.put(ch, (next = new Node()));
      }
      cursor = next;
    }

    if (!cursor.isWord) {
      cursor.isWord = true;
      size++;
    }
  }

  /**
   * If the trie contains word, returns true.
   *
   * @param word
   * @return boolean
   */
  public boolean contains(String word) {
    Node cursor = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node next = cursor.next.get(ch);
      if (next == null) {
        return false;
      }
      cursor = next;
    }
    return cursor.isWord;
  }

  private class Node {
    boolean isWord;
    TreeMap<Character, Node> next;

    Node(boolean isWord) {
      this.isWord = isWord;
      this.next = new TreeMap<>();
    }

    Node() {
      this(false);
    }
  }

}
