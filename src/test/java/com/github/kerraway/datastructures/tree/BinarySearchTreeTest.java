package com.github.kerraway.datastructures.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * @author kerraway
 * @date 2019/1/8
 */
public class BinarySearchTreeTest {

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

}