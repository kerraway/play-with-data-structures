package com.github.kerraway.datastructures.tree.binarytree;

import com.github.kerraway.datastructures.util.FileUtils;
import org.junit.Test;

import java.util.List;

import static com.github.kerraway.datastructures.Constants.BOOK_PATH_PRIDE_AND_PREJUDICE;
import static org.junit.Assert.assertTrue;

/**
 * @author kerraway
 * @date 2019/05/01
 */
public class AVLTreeTest {

  @Test
  public void functionTest() {
    String filePath = BOOK_PATH_PRIDE_AND_PREJUDICE;
    System.out.printf("Function test, book: %s\n", filePath);

    AVLTree<String, Integer> avlTree = new AVLTree<>();
    List<String> words = FileUtils.readWords(filePath);
    for (String word : words) {
      String lowerCaseWord = word.toLowerCase();
      Integer count = avlTree.get(lowerCaseWord);
      if (count == null) {
        avlTree.add(lowerCaseWord, 1);
      } else {
        avlTree.set(lowerCaseWord, count + 1);
      }
    }

    System.out.printf("Total words: %s, total different words: %s.\n", words.size(), avlTree.size());
    String[] checkWords = {"pride", "prejudice", "and", "is", "the"};
    for (String checkWord : checkWords) {
      System.out.printf("Word frequency '%s': %s.\n", checkWord, avlTree.get(checkWord));
    }
    System.out.printf("The tree is a binary search tree: %s.\n", avlTree.isBinarySearchTree());
    System.out.printf("The tree is balanced: %s.\n", avlTree.isBalanced());

    assertTrue(avlTree.isBinarySearchTree());
    assertTrue(avlTree.isBalanced());

    for (String word : words) {
      String lowerCaseWord = word.toLowerCase();
      avlTree.remove(lowerCaseWord);
      assertTrue(avlTree.isBinarySearchTree());
      assertTrue(avlTree.isBalanced());
    }
    assertTrue(avlTree.isEmpty());
  }

}