package com.github.kerraway.datastructures.tree.trie;

import java.util.Map;
import java.util.Stack;
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
   * Remove word from the trie.
   *
   * @param word
   * @return boolean
   */
  public boolean remove(String word) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node next = stack.peek().next.get(ch);
      if (next == null) {
        return false;
      }
      stack.push(next);
    }

    Node tailNode = stack.peek();
    if (!tailNode.isWord) {
      return false;
    }

    //set the tail node of word to false
    tailNode.isWord = false;
    size--;

    //if the tail node's next is not empty, means the trie has other words
    if (tailNode.next.size() > 0) {
      return true;
    }

    stack.pop();
    for (int i = word.length() - 1; i >= 0; i--) {
      stack.peek().next.remove(word.charAt(i));
      //if pre node is word, or its next is not empty, ends loop
      if (stack.peek().isWord || stack.peek().next.size() > 0) {
        return true;
      }
      stack.pop();
    }
    return true;
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

  /**
   * If the trie contains word which starts with prefix, returns true.
   *
   * @param prefix
   * @return boolean
   */
  public boolean startsWith(String prefix) {
    Node cursor = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      Node next = cursor.next.get(ch);
      if (next == null) {
        return false;
      }
      cursor = next;
    }
    return true;
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
