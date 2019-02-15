package com.github.kerraway.datastructures.map;

/**
 * @author kerraway
 * @date 2019/2/15
 */
public interface Map<K, V> {

  /**
   * Gets size of map.
   *
   * @return int
   */
  int size();

  /**
   * If the size of map is 0, returns true.
   *
   * @return boolean
   */
  boolean isEmpty();

  /**
   * Adds key and value into map.
   *
   * @param key
   * @param value
   */
  void add(K key, V value);

  /**
   * If map contains key, replace the key's value with new vlaue.
   * Otherwise, do nothing.
   *
   * @param key
   * @param newValue
   */
  void set(K key, V newValue);

  /**
   * Get value by key from map.
   *
   * @param key
   * @return V
   */
  V get(K key);

  /**
   * If map contains key, returns true.
   *
   * @param key
   * @return boolean
   */
  boolean contains(K key);

  /**
   * If map contains key, removes the key and its value, and returns value.
   * Otherwise, returns {@code null}.
   *
   * @param key
   * @return V
   */
  V remove(K key);
}
