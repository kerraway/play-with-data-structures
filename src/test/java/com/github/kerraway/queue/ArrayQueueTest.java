package com.github.kerraway.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/11/30
 */
public class ArrayQueueTest {

  @Test
  public void test() {
    Queue<Integer> queue = new ArrayQueue<>();
    int start = 0, size = 20;
    for (int i = start; i < size; i++) {
      queue.enqueue(i);
      assertEquals((Integer) start, queue.peek());
    }
    System.out.println(queue);

    Integer element = queue.dequeue();
    assertEquals((Integer) start, element);
    System.out.println(queue);

    for (int i = start + 1; i < 10; i++) {
      assertEquals((Integer) i, queue.dequeue());
    }
    System.out.println(queue);
  }

}