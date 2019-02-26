package com.github.kerraway.datastructures.leetcode;

import java.util.*;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * <p>
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * <p>
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <ul>
 * <li>insert(val)：当元素 val 不存在时，向集合中插入该项。</li>
 * <li>remove(val)：元素 val 存在时，从集合中移除该项。</li>
 * <li>getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。</li>
 * </ul>
 * <p>
 * 示例 :
 * <pre>
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 * </pre>
 *
 * @author kerraway
 * @date 2019/2/26
 */
public class LeetCode380 {

  public interface RandomizedSet {
    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    boolean insert(int val);

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    boolean remove(int val);

    /**
     * Get a random element from the set.
     */
    int getRandom();
  }

  /**
   * Use {@link HashMap}.
   */
  public static class RandomizedSetWithHashMapV1 implements RandomizedSet {

    private Map<String, Integer> map;
    private List<Integer> nums;

    private static final Random RANDOM = new Random();

    public RandomizedSetWithHashMapV1() {
      this.map = new HashMap<>();
      this.nums = new ArrayList<>();
    }

    @Override
    public boolean insert(int val) {
      String key = String.valueOf(val);
      if (map.containsKey(key)) {
        return false;
      }

      nums.add(val);
      map.put(key, nums.size() - 1);
      return true;
    }

    @Override
    public boolean remove(int val) {
      String key = String.valueOf(val);
      Integer index = map.remove(key);
      if (index == null) {
        return false;
      }

      Integer lastNum = nums.remove(nums.size() - 1);
      if (lastNum != val) {
        nums.set(index, lastNum);
        map.put(String.valueOf(lastNum), index);
      }
      return true;
    }

    @Override
    public int getRandom() {
      int index = RANDOM.nextInt(nums.size());
      return nums.get(index);
    }
  }

  /**
   * Use {@link HashMap}.
   */
  public static class RandomizedSetWithHashMapV2 implements RandomizedSet {

    private Map<String, Integer> map;

    private static final Random RANDOM = new Random();

    public RandomizedSetWithHashMapV2() {
      this.map = new HashMap<>();
    }

    @Override
    public boolean insert(int val) {
      String key = String.valueOf(val);
      if (map.containsKey(key)) {
        return false;
      }

      map.put(key, val);
      return true;
    }

    @Override
    public boolean remove(int val) {
      String key = String.valueOf(val);
      return map.remove(key) != null;
    }

    @Override
    public int getRandom() {
      int index = RANDOM.nextInt(map.size());
      return new ArrayList<>(map.values()).get(index);
    }
  }

  /**
   * Use {@link TrieMap}.
   */
  public static class RandomizedSetWithTrieMap implements RandomizedSet {

    private TrieMap trieMap;
    private List<Integer> nums;

    private static final Random RANDOM = new Random();

    public RandomizedSetWithTrieMap() {
      this.trieMap = new TrieMap();
      this.nums = new ArrayList<>();
    }

    @Override
    public boolean insert(int val) {
      String key = String.valueOf(val);
      if (trieMap.contains(key)) {
        return false;
      }

      nums.add(val);
      trieMap.add(key, nums.size() - 1);
      return true;
    }

    @Override
    public boolean remove(int val) {
      String key = String.valueOf(val);
      if (!trieMap.contains(key)) {
        return false;
      }

      int index = trieMap.get(key);
      trieMap.remove(key);

      Integer lastNum = nums.remove(nums.size() - 1);
      if (lastNum != val) {
        nums.set(index, lastNum);
        trieMap.add(String.valueOf(lastNum), index);
      }

      return true;
    }

    @Override
    public int getRandom() {
      int index = RANDOM.nextInt(nums.size());
      return nums.get(index);
    }
  }

  /**
   * Use {@link TrieMapInRecursion}.
   */
  public static class RandomizedSetWithTrieInRecursion implements RandomizedSet {

    private TrieMapInRecursion trieMap;
    private List<Integer> nums;

    private static final Random RANDOM = new Random();

    public RandomizedSetWithTrieInRecursion() {
      this.trieMap = new TrieMapInRecursion();
      this.nums = new ArrayList<>();
    }

    @Override
    public boolean insert(int val) {
      String key = String.valueOf(val);
      if (trieMap.contains(key)) {
        return false;
      }

      nums.add(val);
      trieMap.add(key, nums.size() - 1);
      return true;
    }

    @Override
    public boolean remove(int val) {
      String key = String.valueOf(val);
      if (!trieMap.contains(key)) {
        return false;
      }

      int index = trieMap.get(key);
      trieMap.remove(key);

      Integer lastNum = nums.remove(nums.size() - 1);
      if (lastNum != val) {
        nums.set(index, lastNum);
        trieMap.add(String.valueOf(lastNum), index);
      }

      return true;
    }

    @Override
    public int getRandom() {
      int index = RANDOM.nextInt(nums.size());
      return nums.get(index);
    }
  }

  public static class TrieMap {

    private Node root;
    private int size;

    public TrieMap() {
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
     * @param value
     */
    public void add(String word, int value) {
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
      cursor.value = value;
    }

    /**
     * Gets value by word from the trie.
     *
     * @param word
     * @return int
     */
    public int get(String word) {
      Node cursor = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        Node next = cursor.next.get(ch);
        if (next == null) {
          throw new IllegalArgumentException("Can't get value from trie.");
        }
        cursor = next;
      }
      return cursor.value;
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
      int value;

      Node(boolean isWord, int value) {
        this.isWord = isWord;
        this.next = new TreeMap<>();
        this.value = value;
      }

      Node() {
        this(false, -1);
      }
    }

  }

  public static class TrieMapInRecursion {

    private Node root;
    private int size;

    public TrieMapInRecursion() {
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
     * @param value
     */
    public void add(String word, int value) {
      add(root, word, value, 0);
    }

    /**
     * Gets value by word from the trie.
     *
     * @param word
     * @return int
     */
    public int get(String word) {
      return get(root, word, 0);
    }

    /**
     * Remove word from the trie.
     *
     * @param word
     * @return boolean
     */
    public boolean remove(String word) {
      if (word == null || word.equals("")) {
        return false;
      }
      return remove(root, word, 0);
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
     * @param value
     * @param index
     */
    private void add(Node node, String word, int value, int index) {
      if (index == word.length()) {
        if (!node.isWord) {
          node.isWord = true;
          size++;
        }
        node.value = value;
        return;
      }

      char ch = word.charAt(index);
      Node next = node.next.get(ch);
      if (next == null) {
        node.next.put(ch, (next = new Node()));
      }
      add(next, word, value, index + 1);
    }

    /**
     * Gets value by word from the trie by recursion.
     *
     * @param node
     * @param word
     * @param index
     * @return int
     */
    private int get(Node node, String word, int index) {
      if (word.length() == index) {
        return node.value;
      }

      char ch = word.charAt(index);
      Node next = node.next.get(ch);
      if (next == null) {
        throw new IllegalArgumentException("Can't get value from trie.");
      }
      return get(next, word, index + 1);
    }

    /**
     * Remove word from the trie by recursion.
     *
     * @param node
     * @param word
     * @param index
     * @return boolean
     */
    private boolean remove(Node node, String word, int index) {
      if (word.length() == index) {
        if (!node.isWord) {
          return false;
        }
        node.isWord = false;
        size--;
        return true;
      }

      char ch = word.charAt(index);
      Node next = node.next.get(ch);
      if (next == null) {
        return false;
      }
      boolean ret = remove(next, word, index + 1);
      if (!next.isWord && next.next.isEmpty()) {
        node.next.remove(ch);
      }
      return ret;
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
      int value;

      Node(boolean isWord, int value) {
        this.isWord = isWord;
        this.next = new TreeMap<>();
        this.value = value;
      }

      Node() {
        this(false, -1);
      }
    }

  }
}
