package com.github.kerraway.datastructures.map;

import com.github.kerraway.datastructures.util.FileUtils;
import org.junit.Test;

import java.util.List;

import static com.github.kerraway.datastructures.Constants.BOOK_PATH_PRIDE_AND_PREJUDICE;

/**
 * @author kerraway
 * @date 2019/2/15
 */
public class MapTest {

  @Test
  public void functionTest() {
    functionTest(new LinkedListMap<>());
  }

  private void functionTest(Map<String, Integer> map) {
    String filePath = BOOK_PATH_PRIDE_AND_PREJUDICE;
    System.out.printf("Map function test for %s, book: %s\n", map.getClass().getName(), filePath);

    long start = System.nanoTime();
    List<String> words = FileUtils.readWords(filePath);
    for (String word : words) {
      String wordLowerCase = word.toLowerCase();
      Integer count = map.get(wordLowerCase);
      if (count == null) {
        map.add(wordLowerCase, 1);
      } else {
        map.set(wordLowerCase, count + 1);
      }
    }
    System.out.printf("Total words: %s, total different words: %s.\n", words.size(), map.size());
    System.out.printf("Word frequency, pride: %s, prejudice: %s.\n", map.get("pride"), map.get("prejudice"));

    System.out.printf("Map function test for %s, use %s s.\n\n",
        map.getClass().getName(), (System.nanoTime() - start) / 1000000000.0);
  }

}