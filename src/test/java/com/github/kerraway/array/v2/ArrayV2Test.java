package com.github.kerraway.array.v2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 小柯
 * @date 2018/11/28
 */
public class ArrayV2Test {

  @Test
  public void test1() {
    int capacity = 20;
    Array<Integer> array = new Array<>(capacity);
    assertEquals(capacity, array.capacity());

    int size = 10;
    for (int i = 0; i < size; i++) {
      array.addLast(i);
    }
    assertEquals(size, array.size());
    for (int i = 0; i < size; i++) {
      assertEquals((Integer) i, array.get(i));
    }
    System.out.println(array);

    int index = 1;
    Integer e = 100;
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
    Integer remove = array.remove(index);
    assertEquals(e, remove);
    System.out.println(array);

    index = 4;
    e = -10;
    array.add(index, e);
    size += 1;
    assertEquals(size, array.size());
    assertTrue(array.contains(e));
    assertEquals(index, array.indexOf(e));
    array.removeElement(e);
    size -= 1;
    assertEquals(size, array.size());
    assertFalse(array.contains(e));
    assertNotEquals(e, array.get(index));
    System.out.println(array);
  }

  @Test
  public void test2() {
    Array<Foo> array = new Array<>(20);
    int size = 10;
    for (int i = 0; i < size; i++) {
      array.addLast(new Foo(i, "name" + i));
    }
    for (int i = 0; i < size; i++) {
      assertTrue(array.contains(new Foo(i, "name" + i)));
    }
    System.out.println(array);
  }

  @Test
  public void test3() {
    int capacity = 10;
    Array<Integer> array = new Array<>(capacity);
    int size = capacity;
    for (int i = 0; i < size; i++) {
      array.addLast(i);
    }
    assertEquals(capacity, array.capacity());
    assertEquals(capacity, array.size());
    System.out.println(array);

    array.addLast(10);
    size += 1;
    assertEquals(size, array.size());
    assertEquals(2 * capacity, array.capacity());
    System.out.println(array);

    int arraySize = size;
    for (int i = 0; i < arraySize; i++) {
      array.removeFirst();
      size--;
    }
    assertEquals(size, array.size());
    assertTrue(capacity > array.capacity());
    System.out.println(array);
  }

}