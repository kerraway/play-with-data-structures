package com.github.kerraway.datastructures.set;

import com.github.kerraway.datastructures.util.FileUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author kerraway
 * @date 2019/1/24
 */
public class SetTest {

  private static final String BOOK_A_TALE_OF_TWO_CITIES = "books/a-tale-of-two-cities.txt";
  private static final String BOOK_PRIDE_AND_PREJUDICE = "books/pride-and-prejudice.txt";

  @Test
  public void functionTest() {
    functionTest(new BinarySearchTreeSet<>(), BOOK_A_TALE_OF_TWO_CITIES);
    functionTest(new BinarySearchTreeSet<>(), BOOK_PRIDE_AND_PREJUDICE);

    functionTest(new LinkedListSet<>(),BOOK_A_TALE_OF_TWO_CITIES);
    functionTest(new LinkedListSet<>(),BOOK_PRIDE_AND_PREJUDICE);
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