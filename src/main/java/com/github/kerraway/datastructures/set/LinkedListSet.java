package com.github.kerraway.datastructures.set;

import com.github.kerraway.datastructures.list.linked.v2.LinkedList;

/**
 * @author kerraway
 * @date 2019/2/15
 */
public class LinkedListSet<E> implements Set<E> {

  private LinkedList<E> list;

  public LinkedListSet() {
    this.list = new LinkedList<>();
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public void add(E e) {
    if (!list.contains(e)) {
      list.addFirst(e);
    }
  }

  @Override
  public boolean contains(E e) {
    return list.contains(e);
  }

  @Override
  public void remove(E e) {
    list.removeElement(e);
  }
}
