package com.github.kerraway.datastructures.queue;

import com.github.kerraway.datastructures.queue.loop.v2.LoopQueue;
import org.junit.Test;

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
    Queue<Integer> loopQueueV1 = new com.github.kerraway.datastructures.queue.loop.v1.LoopQueue<>();
    functionTest(loopQueueV1);

    //LoopQueue V2
    Queue<Integer> loopQueueV2 = new LoopQueue<>();
    functionTest(loopQueueV2);

    //LoopQueue V3
    Queue<Integer> loopQueueV3 = new com.github.kerraway.datastructures.queue.loop.v3.LoopQueue<>();
    functionTest(loopQueueV3);

    //LinkedQueue
    Queue<Integer> linkedQueue = new LinkedQueue<>();
    functionTest(linkedQueue);
  }

  @Test
  public void performanceTest() {
    //ArrayQueue
    Queue<Integer> arrayQueue = new ArrayQueue<>();
    performanceTest(arrayQueue);

    //LoopQueue V1
    Queue<Integer> loopQueueV1 = new com.github.kerraway.datastructures.queue.loop.v1.LoopQueue<>();
    performanceTest(loopQueueV1);

    //LoopQueue V2
    Queue<Integer> loopQueueV2 = new LoopQueue<>();
    performanceTest(loopQueueV2);

    //LoopQueue V3
    Queue<Integer> loopQueueV3 = new com.github.kerraway.datastructures.queue.loop.v3.LoopQueue<>();
    performanceTest(loopQueueV3);

    //LinkedQueue
    Queue<Integer> linkedQueue = new LinkedQueue<>();
    performanceTest(linkedQueue);
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
    System.out.println();
  }

  private void performanceTest(Queue<Integer> queue) {
    System.out.println("Queue performance test for " + queue.getClass().getName());

    long start = System.nanoTime();
    Random random = new Random();
    int total = 100000;
    for (int i = 0; i < total; i++) {
      queue.enqueue(random.nextInt(Integer.MAX_VALUE));
    }
    for (int i = 0; i < total; i++) {
      queue.dequeue();
    }

    System.out.printf("Queue performance test for %s, use %s s.\n\n",
        queue.getClass().getName(), (System.nanoTime() - start) / 1000000000.0);
  }

}