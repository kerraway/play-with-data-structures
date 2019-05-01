package com.github.kerraway.datastructures.set;

import com.github.kerraway.datastructures.util.FileUtils;
import org.junit.Test;

import java.util.List;

import static com.github.kerraway.datastructures.Constants.BOOK_PATH_A_TALE_OF_TWO_CITIES;
import static com.github.kerraway.datastructures.Constants.BOOK_PATH_PRIDE_AND_PREJUDICE;

/**
 * @author kerraway
 * @date 2019/1/24
 */
public class SetTest {

  @Test
  public void functionTest() {
    String[] bookPaths = {BOOK_PATH_A_TALE_OF_TWO_CITIES, BOOK_PATH_PRIDE_AND_PREJUDICE};
    for (String bookPath : bookPaths) {
      functionTest(new LinkedListSet<>(), bookPath);
      functionTest(new BinarySearchTreeSet<>(), bookPath);
      functionTest(new AVLTreeSet<>(), bookPath);
      System.out.println();
    }
  }

  private void functionTest(Set<String> set, String bookPath) {
    long start = System.nanoTime();
    List<String> words = FileUtils.readWords(bookPath);
    for (String word : words) {
      set.add(word.toLowerCase());
    }
    System.out.printf("Set function test for %s, book: %s, total words: %s, total different words: %s, use %s s.\n",
        set.getClass().getName(), bookPath, words.size(), set.size(), (System.nanoTime() - start) / 1000000000.0);
  }

}