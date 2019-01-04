package com.github.kerraway.datastructures;

import com.github.kerraway.datastructures.leetcode.LeetCode20Test;
import com.github.kerraway.datastructures.leetcode.LeetCode102Test;
import com.github.kerraway.datastructures.leetcode.LeetCode203Test;
import com.github.kerraway.datastructures.leetcode.LeetCode804Test;
import com.github.kerraway.datastructures.list.ListTest;
import com.github.kerraway.datastructures.list.array.v1.ArrayListV1Test;
import com.github.kerraway.datastructures.list.array.v2.ArrayListV2Test;
import com.github.kerraway.datastructures.list.linked.v3.SumTest;
import com.github.kerraway.datastructures.queue.QueueTest;
import com.github.kerraway.datastructures.stack.StackTest;
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

    //recursive
    SumTest.class,

    //leetcode
    LeetCode20Test.class,
    LeetCode102Test.class,
    LeetCode203Test.class,
    LeetCode804Test.class,
})
public class DataStructuresTests {
}
