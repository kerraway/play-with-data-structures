package com.github.kerraway.datastructures.tree;

import org.junit.Test;

import static org.junit.Assert.*;

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
    bst.inorderTraverse();
    bst.postTraverse();
  }

}