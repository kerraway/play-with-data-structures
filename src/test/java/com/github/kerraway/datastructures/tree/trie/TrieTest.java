package com.github.kerraway.datastructures.tree.trie;

import com.github.kerraway.datastructures.tree.binarytree.BinarySearchTree;
import com.github.kerraway.datastructures.util.FileUtils;
import org.junit.Test;

import java.util.*;

import static com.github.kerraway.datastructures.Constants.BOOK_PATH_A_TALE_OF_TWO_CITIES;
import static com.github.kerraway.datastructures.Constants.BOOK_PATH_PRIDE_AND_PREJUDICE;
import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2019/2/22
 */
public class TrieTest {

  /**
   * @see Trie
   * @see TrieInRecursion
   */
  @Test
  public void functionTest() {
    functionTest4Trie();
    functionTest4TrieInRecursion();
  }

  /**
   * Performance test
   *
   * @see Trie
   * @see TrieInRecursion
   * @see BinarySearchTree
   */
  @Test
  public void performanceTest() {
    List<String> words1 = FileUtils.readWords(BOOK_PATH_PRIDE_AND_PREJUDICE);
    List<String> words2 = FileUtils.readWords(BOOK_PATH_A_TALE_OF_TWO_CITIES);
    List<String> words = new ArrayList<>(words1);
    words.addAll(words2);

    //warm up
    for (int i = 0; i < 5; i++) {
      performanceTest(words, true);
    }
    //official game
    performanceTest(words, false);
  }

  private void performanceTest(List<String> words, boolean isWarmUp) {
    //BinarySearchTree
    long start = System.nanoTime();
    BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
    for (String word : words) {
      binarySearchTree.add(word);
    }
    for (String word : words) {
      assertTrue(binarySearchTree.contains(word));
    }
    if (!isWarmUp) {
      System.out.printf("%s handle %s words, use %s s.\n", BinarySearchTree.class.getName(),
          binarySearchTree.size(), (System.nanoTime() - start) / 1000000000.0);
    }

    //Trie
    start = System.nanoTime();
    Trie trie = new Trie();
    for (String word : words) {
      trie.add(word);
    }
    for (String word : words) {
      assertTrue(trie.contains(word));
    }
    if (!isWarmUp) {
      System.out.printf("%s handle %s words, use %s s.\n", Trie.class.getName(),
          trie.size(), (System.nanoTime() - start) / 1000000000.0);
    }

    //TrieInRecursion
    start = System.nanoTime();
    TrieInRecursion trieInRecursion = new TrieInRecursion();
    for (String word : words) {
      trieInRecursion.add(word);
    }
    for (String word : words) {
      assertTrue(trieInRecursion.contains(word));
    }
    if (!isWarmUp) {
      System.out.printf("%s handle %s words, use %s s.\n", TrieInRecursion.class.getName(),
          trieInRecursion.size(), (System.nanoTime() - start) / 1000000000.0);
    }
  }

  private void functionTest4Trie() {
    Trie trie = new Trie();
    String[] words = {"this", "is", "a", "book", "about", "java", "concurrence", "programing",
        "written", "by", "someone", "crazy", "about", "java"};
    for (String word : words) {
      trie.add(word);
    }
    TreeSet<String> wordSet = new TreeSet<>(Arrays.asList(words));
    assertEquals(wordSet.size(), trie.size());

    for (String word : words) {
      assertTrue(trie.contains(word));
    }
    String[] prefixes = {"th", "bo", "con"};
    for (String prefix : prefixes) {
      assertTrue(trie.startsWith(prefix));
    }
    String[] otherWords = {"other", "words", "that", "are", "not", "contained", "in", "the", "trie"};
    for (String otherWord : otherWords) {
      assertFalse(trie.contains(otherWord));
    }
  }

  private void functionTest4TrieInRecursion() {
    TrieInRecursion trie = new TrieInRecursion();
    String[] words = {"this", "is", "a", "book", "about", "java", "concurrence", "programing",
        "written", "by", "someone", "crazy", "about", "java"};
    for (String word : words) {
      trie.add(word);
    }
    TreeSet<String> wordSet = new TreeSet<>(Arrays.asList(words));
    assertEquals(wordSet.size(), trie.size());

    for (String word : words) {
      assertTrue(trie.contains(word));
    }
    String[] prefixes = {"th", "bo", "con"};
    for (String prefix : prefixes) {
      assertTrue(trie.startsWith(prefix));
    }
    String[] otherWords = {"other", "words", "that", "are", "not", "contained", "in", "the", "trie"};
    for (String otherWord : otherWords) {
      assertFalse(trie.contains(otherWord));
    }
  }

}