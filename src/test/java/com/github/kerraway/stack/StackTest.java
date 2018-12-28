package com.github.kerraway.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/11/28
 */
public class StackTest {

  @Test
  public void functionTest() {
    //ArrayStack
    Stack<Integer> arrayStack = new ArrayStack<>();
    functionTest(arrayStack);

    //LinkedStack
    Stack<Integer> linkedStack = new LinkedStack<>();
    functionTest(linkedStack);
  }

  private void functionTest(Stack<Integer> stack) {
    System.out.println("Stack function test for " + stack.getClass().getName());

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
    System.out.println();
  }
}