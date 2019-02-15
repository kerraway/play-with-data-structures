package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.set.BinarySearchTreeSet;
import com.github.kerraway.datastructures.set.LinkedListSet;
import com.github.kerraway.datastructures.set.Set;
import com.github.kerraway.datastructures.tree.BinarySearchTree;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 * <p>
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * <p>
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 * <p>
 * 返回我们可以获得所有词不同单词翻译的数量。
 * <p>
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * <p>
 * <p>
 * 注意:
 * <p>
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 *
 * @author kerraway
 * @date 2018/12/28
 */
public class LeetCode804 {

  private static final String[] MORSE_CODES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
      "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

  /**
   * Use {@link BinarySearchTree}.
   *
   * @param words
   * @return int
   */
  public int uniqueMorseRepresentationsV1(String[] words) {
    BinarySearchTree<String> bst = new BinarySearchTree<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      String morseCode = buildMorseCode(word);
      bst.add(morseCode);
    }
    return bst.size();
  }

  /**
   * Use {@link BinarySearchTreeSet}.
   *
   * @param words
   * @return int
   */
  public int uniqueMorseRepresentationsV2(String[] words) {
    Set<String> set = new BinarySearchTreeSet<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      String morseCode = buildMorseCode(word);
      set.add(morseCode);
    }
    return set.size();
  }

  /**
   * Use {@link LinkedListSet}.
   *
   * @param words
   * @return int
   */
  public int uniqueMorseRepresentationsV3(String[] words) {
    Set<String> set = new LinkedListSet<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      String morseCode = buildMorseCode(word);
      set.add(morseCode);
    }
    return set.size();
  }

  private String buildMorseCode(String word) {
    word = word.toLowerCase();
    StringBuilder res = new StringBuilder();
    for (int j = 0; j < word.length(); j++) {
      res.append(MORSE_CODES[word.charAt(j) - 'a']);
    }
    return res.toString();
  }

}
