package com.github.kerraway.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/11/28
 */
public class ArrayStackTest {

  @Test
  public void test() {
    Stack<Integer> stack = new ArrayStack<>();
    int size = 10;
    for (int i = 0; i < size; i++) {
      stack.push(i);
      assertEquals((Integer) i, stack.peek());
      assertEquals(i + 1, stack.size());
      System.out.println(stack);
    }
    for (int i = 0; i < 5; i++) {
      Integer peekElement = stack.peek();
      Integer popElement = stack.pop();
      assertEquals(peekElement, popElement);
      assertEquals((Integer) (size - i - 1), popElement);
      System.out.println(stack);
    }
  }

}