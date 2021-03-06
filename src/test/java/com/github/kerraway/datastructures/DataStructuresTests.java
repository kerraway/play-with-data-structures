package com.github.kerraway.datastructures;

import com.github.kerraway.datastructures.leetcode.*;
import com.github.kerraway.datastructures.list.ListTest;
import com.github.kerraway.datastructures.list.array.v1.ArrayListV1Test;
import com.github.kerraway.datastructures.list.array.v2.ArrayListV2Test;
import com.github.kerraway.datastructures.list.linked.v3.SumTest;
import com.github.kerraway.datastructures.map.MapTest;
import com.github.kerraway.datastructures.queue.QueueTest;
import com.github.kerraway.datastructures.set.SetTest;
import com.github.kerraway.datastructures.stack.StackTest;
import com.github.kerraway.datastructures.tree.binarytree.AVLTreeTest;
import com.github.kerraway.datastructures.tree.binarytree.BinarySearchTreeTest;
import com.github.kerraway.datastructures.tree.binarytree.SegmentTreeTest;
import com.github.kerraway.datastructures.tree.heap.MaxHeapTest;
import com.github.kerraway.datastructures.tree.trie.MapSumTest;
import com.github.kerraway.datastructures.tree.trie.TrieTest;
import com.github.kerraway.datastructures.unionfind.UnionFindTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    //list
    ArrayListV1Test.class,
    ArrayListV2Test.class,
    ListTest.class,

    //stack
    StackTest.class,

    //queue
    QueueTest.class,

    //set
    SetTest.class,

    //map
    MapTest.class,

    //recursive
    SumTest.class,

    //binary tree
    BinarySearchTreeTest.class,
    SegmentTreeTest.class,
    AVLTreeTest.class,

    //heap
    MaxHeapTest.class,

    //trie
    TrieTest.class,
    MapSumTest.class,

    //union-find
    UnionFindTest.class,

    //leetcode
    LeetCode20Test.class,
    LeetCode102Test.class,
    LeetCode203Test.class,
    LeetCode804Test.class,
    LeetCode94Test.class,
    LeetCode145Test.class,
    LeetCode144Test.class,
    LeetCode349Test.class,
    LeetCode350Test.class,
    LeetCode347Test.class,
    LeetCode303Test.class,
    LeetCode307Test.class,
    LeetCode211Test.class,
    LeetCode380Test.class,
    LeetCode208Test.class,
    LeetCode547Test.class,
})
public class DataStructuresTests {
}
