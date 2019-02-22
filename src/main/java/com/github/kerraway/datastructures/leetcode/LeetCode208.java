package com.github.kerraway.datastructures.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * <p>
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <pre>
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * </pre>
 * <p>
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * @author kerraway
 * @date 2019/2/22
 */
public class LeetCode208 {

  private Node root;

  /**
   * Initialize your data structure here.
   */
  public LeetCode208() {
    this.root = new Node();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    Node cursor = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node next = cursor.next.get(ch);
      if (next == null) {
        cursor.next.put(ch, (next = new Node()));
      }
      cursor = next;
    }
    cursor.isWord = true;
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
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
   * Returns if there is any word in the trie that starts with the given prefix.
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
