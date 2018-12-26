package com.github.kerraway.queue;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author kerraway
 * @date 2018/12/26
 */
public class QueueTest {

  @Test
  public void functionTest() {
    //ArrayQueue
    Queue<Integer> arrayQueue = new ArrayQueue<>();
    functionTest(arrayQueue);

    //LoopQueue V1
    Queue<Integer> loopQueueV1 = new com.github.kerraway.queue.loop.v1.LoopQueue<>();
    functionTest(loopQueueV1);

    //LoopQueue V2
    Queue<Integer> loopQueueV2 = new com.github.kerraway.queue.loop.v2.LoopQueue<>();
    functionTest(loopQueueV2);
  }

  @Test
  public void performanceTest() {
    //ArrayQueue
    Queue<Integer> arrayQueue = new ArrayQueue<>();
    performanceTest(arrayQueue);

    //LoopQueue V1
    Queue<Integer> loopQueueV1 = new com.github.kerraway.queue.loop.v1.LoopQueue<>();
    performanceTest(loopQueueV1);

    //LoopQueue V2
    Queue<Integer> loopQueueV2 = new com.github.kerraway.queue.loop.v2.LoopQueue<>();
    performanceTest(loopQueueV2);
  }

  private void functionTest(Queue<Integer> queue) {
    System.out.println("Queue function test for " + queue.getClass().getName());

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

  private void performanceTest(Queue<Integer> queue) {
    System.out.println("Queue performance test for " + queue.getClass().getName());

    Instant start = Instant.now();
    Random random = new Random();
    int total = 100000;
    for (int i = 0; i < total; i++) {
      queue.enqueue(random.nextInt(Integer.MAX_VALUE));
    }
    for (int i = 0; i < total; i++) {
      queue.dequeue();
    }

    System.out.printf("Queue performance test for %s, use %s s.\n",
        queue.getClass().getName(), Duration.between(start, Instant.now()).toMillis() / 1000.0);
  }

}