package com.github.kerraway;

import com.github.kerraway.leetcode.LeetCode102Test;
import com.github.kerraway.leetcode.LeetCode203Test;
import com.github.kerraway.leetcode.LeetCode20Test;
import com.github.kerraway.leetcode.LeetCode804Test;
import com.github.kerraway.list.ListTest;
import com.github.kerraway.list.array.v1.ArrayListV1Test;
import com.github.kerraway.list.array.v2.ArrayListV2Test;
import com.github.kerraway.list.linked.v3.SumTest;
import com.github.kerraway.queue.QueueTest;
import com.github.kerraway.stack.StackTest;
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
