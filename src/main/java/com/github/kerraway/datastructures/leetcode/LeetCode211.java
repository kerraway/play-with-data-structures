package com.github.kerraway.datastructures.leetcode;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * <p>
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <pre>
 *  void addWord(word)
 *  bool search(word)
 * </pre>
 * <p>
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。
 * . 可以表示任何一个字母。
 * <p>
 * 示例:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * <p>
 * 说明:
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 *
 * @author kerraway
 * @date 2019/2/25
 */
public class LeetCode211 {

  private Node root;

  /**
   * Initialize your data structure here.
   */
  public LeetCode211() {
    this.root = new Node();
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
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
   * Returns if the word is in the data structure.
   * A word could contain the dot character '.' to represent any one letter.
   */
  public boolean search(String word) {
    return search(root, word, 0);
  }

  private boolean search(Node node, String word, int index) {
    if (index == word.length()) {
      return node.isWord;
    }

    char ch = word.charAt(index);
    //ch isn't '.'
    if (ch != '.') {
      Node next = node.next.get(ch);
      if (next == null) {
        return false;
      }
      return search(next, word, index + 1);
    }
    //ch is '.'
    Set<Character> possibleChs = node.next.keySet();
    for (Character possibleCh : possibleChs) {
      if (search(node.next.get(possibleCh), word, index + 1)) {
        return true;
      }
    }
    return false;
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
