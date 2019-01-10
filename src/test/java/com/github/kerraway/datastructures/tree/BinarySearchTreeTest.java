package com.github.kerraway.datastructures.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author kerraway
 * @date 2019/1/8
 */
public class BinarySearchTreeTest {

  /**
   * @see BinarySearchTree#toString()
   * @see BinarySearchTree#preorderTraverse()
   * @see BinarySearchTree#preorderTraverseWithoutRecursion()
   * @see BinarySearchTree#inorderTraverse()
   * @see BinarySearchTree#postorderTraverse()
   * @see BinarySearchTree#levelOrderTraverse()
   */
  @Test
  public void traverseTest() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    int[] nums = {5, 3, 6, 8, 4, 2};
    for (int num : nums) {
      bst.add(num);
    }
    /**
     *     5
     *    /  \
     *   3    6
     *  / \    \
     * 2   4    8
     */
    System.out.println(bst);

    bst.preorderTraverse();
    bst.preorderTraverseWithoutRecursion();
    bst.inorderTraverse();
    bst.postorderTraverse();

    bst.levelOrderTraverse();
  }

  /**
   * @see BinarySearchTree#removeMin()
   * @see BinarySearchTree#removeMax()
   */
  @Test
  public void removeMinAndMaxTest() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    Random random = new Random();
    int n = 10000;

    for (int i = 0; i < n; i++) {
      bst.add(random.nextInt(n));
    }
    List<Integer> list = new ArrayList<>(n);
    while (!bst.isEmpty()) {
      list.add(bst.removeMin());
    }
    System.out.println(list.subList(0, 20));
    for (int i = 1; i < list.size(); i++) {
      assertTrue(list.get(i - 1) < list.get(i));
    }
    System.out.println("BinarySearchTree#removeMin() test completed.\n");

    for (int i = 0; i < n; i++) {
      bst.add(random.nextInt(n));
    }
    list.clear();
    while (!bst.isEmpty()) {
      list.add(bst.removeMax());
    }
    System.out.println(list.subList(0, 20));
    for (int i = 1; i < list.size(); i++) {
      assertTrue(list.get(i - 1) > list.get(i));
    }
    System.out.println("BinarySearchTree#removeMax() test completed.\n");
  }

  /**
   * @see BinarySearchTree#remove(Comparable)
   */
  @Test
  public void removeTest() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    Random random = new Random();
    int n = 10000;

    for (int i = 0; i < n; i++) {
      bst.add(random.nextInt(n));
    }

    List<Integer> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      list.add(i);
    }
    Collections.shuffle(list);

    System.out.printf("Before remove operation, tree's size %d.\n", bst.size());
    for (int i = 0; i < n; i++) {
      Integer num = list.get(i);
      if (bst.contains(num)) {
        bst.remove(num);
        System.out.printf("Remove %d, tree's size %d.\n", num, bst.size());
      }
    }
    assertEquals(0, bst.size());
  }

}