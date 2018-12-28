package com.github.kerraway;

import com.github.kerraway.list.ListTest;
import com.github.kerraway.list.array.v1.ArrayListV1Test;
import com.github.kerraway.list.array.v2.ArrayListV2Test;
import com.github.kerraway.queue.LeetCode102Test;
import com.github.kerraway.queue.QueueTest;
import com.github.kerraway.stack.StackTest;
import com.github.kerraway.stack.LeetCode20Test;
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

    //leetcode
    LeetCode20Test.class,
    LeetCode102Test.class,
})
public class DataStructuresTests {
}
