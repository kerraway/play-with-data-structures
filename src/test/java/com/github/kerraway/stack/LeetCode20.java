package com.github.kerraway.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author 小柯
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

  @Test
  public void test() {
    Object[][] argsArr = {
        {"", true},
        {"()", true},
        {"()[]{}", true},
        {"(]", false},
        {"([)]", false},
        {"{[]}", true},
    };
    for (Object[] args : argsArr) {
      String str = (String) args[0];
      boolean expected = (boolean) args[1];
      assertEquals(expected, new LeetCode20().isValid(str));
    }
  }

}
