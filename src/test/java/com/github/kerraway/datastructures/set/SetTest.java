package com.github.kerraway.datastructures.set;

import com.github.kerraway.datastructures.util.FileUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author kerraway
 * @date 2019/1/24
 */
public class SetTest {

  @Test
  public void functionTest() {
    functionTest(new BinarySearchTreeSet<>(), "books/a-tale-of-two-cities.txt");
    functionTest(new BinarySearchTreeSet<>(), "books/pride-and-prejudice.txt");
  }

  private void functionTest(Set<String> set, String filePath) {
    System.out.printf("Set function test for %s, book: %s\n", set.getClass().getName(), filePath);

    List<String> words = FileUtils.readWords(filePath);
    System.out.println("Total words: " + words.size());
    for (String word : words) {
      set.add(word.toLowerCase());
    }
    System.out.println("Total different words: " + set.size());
  }

}