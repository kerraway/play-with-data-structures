package com.github.kerraway.datastructures.list;

import com.github.kerraway.datastructures.list.array.v2.ArrayList;
import com.github.kerraway.datastructures.list.linked.v1.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kerraway
 * @date 2018/12/28
 */
public class ListTest {

  @Test
  public void functionTest() {
    //ArrayList V2
    List<Integer> arrayListV2 = new ArrayList<>();
    functionTest(arrayListV2);

    //LinkedList V1
    List<Integer> linkedListV1 = new LinkedList<>();
    functionTest(linkedListV1);

    //LinkedList V2
    List<Integer> linkedListV2 = new com.github.kerraway.datastructures.list.linked.v2.LinkedList<>();
    functionTest(linkedListV2);

    //LinkedList V3, use recursive algorithm
    List<Integer> linkedListV3 = new com.github.kerraway.datastructures.list.linked.v3.LinkedList<>();
    functionTest(linkedListV3);
  }

  private void functionTest(List<Integer> list) {
    System.out.println("List function test for " + list.getClass().getName());

    int count = 10;
    for (int i = 0; i < count; i++) {
      list.addFirst(i);
    }
    assertEquals(count, list.size());
    System.out.println(list);

    list.remove(3);
    count--;
    assertEquals(count, list.size());
    System.out.println(list);

    int index = 2;
    Integer e = 777;
    list.add(index, e);
    count++;
    assertEquals(count, list.size());
    System.out.println(list);

    assertEquals(e, list.get(index));
    assertTrue(list.contains(e));

    list.removeElement(e);
    count--;
    assertEquals(count, list.size());
    System.out.println(list);

    assertFalse(list.contains(e));

    list.set(3, e);
    assertEquals(count, list.size());
    System.out.println(list);

    assertTrue(list.contains(e));

    System.out.println();
  }

}
