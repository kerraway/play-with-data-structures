package com.github.kerraway.stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author kerraway
 * @date 2018/11/28
 */
public class LeetCode20 {

  public boolean isValid(String str) {
    Stack<Character> stack = new ArrayStack<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '[' || c == '(' || c == '{') {
        stack.push(c);
        continue;
      }
      if (stack.isEmpty()) {
        return false;
      }
      char pop = stack.pop();
      if (c == ']' && pop != '[') {
        return false;
      }
      if (c == ')' && pop != '(') {
        return false;
      }
      if (c == '}' && pop != '{') {
        return false;
      }
    }
    return stack.isEmpty();
  }

}
