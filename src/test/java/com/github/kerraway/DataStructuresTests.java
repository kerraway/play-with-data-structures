package com.github.kerraway;

import com.github.kerraway.array.v1.ArrayV1Test;
import com.github.kerraway.array.v2.ArrayV2Test;
import com.github.kerraway.stack.ArrayStackTest;
import com.github.kerraway.stack.LeetCode20Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    //array
    ArrayV1Test.class,
    ArrayV2Test.class,

    //stack
    ArrayStackTest.class,

    //leetcode
    LeetCode20Test.class,
})
public class DataStructuresTests {
}
