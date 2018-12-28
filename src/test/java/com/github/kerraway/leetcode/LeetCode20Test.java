package com.github.kerraway.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author kerraway
 * @date 2018/11/28
 */
public class LeetCode20Test {

  @Test
  public void isValid() {
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
      Assert.assertEquals(expected, new LeetCode20().isValid(str));
    }
  }

}