package com.github.kerraway.list.array.v1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/11/28
 */
public class ArrayListV1Test {

  @Test
  public void test() {
    int capacity = 20;
    ArrayList arrayList = new ArrayList(capacity);
    assertEquals(capacity, arrayList.capacity());

    int size = 10;
    for (int i = 0; i < size; i++) {
      arrayList.addLast(i);
    }
    assertEquals(size, arrayList.size());
    for (int i = 0; i < size; i++) {
      assertEquals((Integer) i, arrayList.get(i));
    }
    System.out.println(arrayList);

    int index = 1;
    Integer e = 100;
    size += 1;
    arrayList.add(index, e);
    assertEquals(size, arrayList.size());
    assertEquals((Integer) e, arrayList.get(index));
    System.out.println(arrayList);

    index = 1;
    e = 10;
    arrayList.set(index, e);
    assertEquals(e, arrayList.get(index));
    System.out.println(arrayList);

    e = 100;
    size += 1;
    arrayList.addFirst(e);
    assertEquals(size, arrayList.size());
    assertEquals(e, arrayList.get(0));
    System.out.println(arrayList);

    index = 2;
    e = 55;
    arrayList.set(index, e);
    size -= 1;
    Integer remove = arrayList.remove(index);
    assertEquals(e, remove);
    System.out.println(arrayList);

    index = 4;
    e = -10;
    arrayList.add(index, e);
    size += 1;
    assertEquals(size, arrayList.size());
    assertTrue(arrayList.contains(e));
    assertEquals(index, arrayList.indexOf(e));
    arrayList.removeElement(e);
    size -= 1;
    assertEquals(size, arrayList.size());
    assertFalse(arrayList.contains(e));
    assertNotEquals(e, arrayList.get(index));
    System.out.println(arrayList);
  }

}