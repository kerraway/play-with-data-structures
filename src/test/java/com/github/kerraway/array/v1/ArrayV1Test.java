package com.github.kerraway.array.v1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 小柯
 * @date 2018/11/28
 */
public class ArrayV1Test {

  @Test
  public void test() {
    int capacity = 20;
    Array array = new Array(capacity);
    assertEquals(capacity, array.capacity());

    int size = 10;
    for (int i = 0; i < size; i++) {
      array.addLast(i);
    }
    assertEquals(size, array.size());
    for (int i = 0; i < size; i++) {
      assertEquals(i, array.get(i));
    }
    System.out.println(array);

    int index = 1, e = 100;
    size += 1;
    array.add(index, e);
    assertEquals(size, array.size());
    assertEquals(e, array.get(index));
    System.out.println(array);

    index = 1;
    e = 10;
    array.set(index, e);
    assertEquals(e, array.get(index));
    System.out.println(array);

    e = 100;
    size += 1;
    array.addFirst(e);
    assertEquals(size, array.size());
    assertEquals(e, array.get(0));
    System.out.println(array);

    index = 2;
    e = 55;
    array.set(index, e);
    size -= 1;
    int remove = array.remove(index);
    assertEquals(e, remove);
    System.out.println(array);

    index = 4;
    e = -10;
    array.add(index, e);
    size += 1;
    assertEquals(size, array.size());
    assertTrue(array.contains(e));
    assertEquals(index, array.index(e));
    array.removeElement(e);
    size -= 1;
    assertEquals(size, array.size());
    assertFalse(array.contains(e));
    assertNotEquals(e, array.get(index));
    System.out.println(array);
  }

}