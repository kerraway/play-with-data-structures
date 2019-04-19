package com.github.kerraway.datastructures.unionfind;

import org.junit.Test;

import java.util.Random;

/**
 * @author kerraway
 * @date 2019/2/26
 */
public class UnionFindTest {

  @Test
  public void performanceTest() {
    int size = 100000;
    int operateCount = 10000;
    System.out.printf("Union-find size: %s, operate count: %s.\n", size, operateCount);
    //performance: v1 < v2 < v3
    //v1
    performanceTest(new UnionFindImplV1(size), operateCount);
    //v2
    performanceTest(new UnionFindImplV2(size), operateCount);
    //v3
    performanceTest(new UnionFindImplV3(size), operateCount);
    //v4
    performanceTest(new UnionFindImplV4(size), operateCount);

    size = 100000;
    operateCount = 80000;
    System.out.printf("\nUnion-find size: %s, operate count: %s.\n", size, operateCount);
    //performance: v2 < v3 < v4
    //v2
    performanceTest(new UnionFindImplV2(size), operateCount);
    //v3
    performanceTest(new UnionFindImplV3(size), operateCount);
    //v4
    performanceTest(new UnionFindImplV4(size), operateCount);

    size = 10000000;
    operateCount = 10000000;
    System.out.printf("\nUnion-find size: %s, operate count: %s.\n", size, operateCount);
    //performance: v3 < v4 < v5 ≈ v6
    //v3
    performanceTest(new UnionFindImplV3(size), operateCount);
    //v4
    performanceTest(new UnionFindImplV4(size), operateCount);
    //v5
    performanceTest(new UnionFindImplV5(size), operateCount);
    //v6
    performanceTest(new UnionFindImplV6(size), operateCount);
  }

  private void performanceTest(UnionFind unionFind, int operateCount) {
    long start = System.nanoTime();
    Random random = new Random();
    int size = unionFind.size();
    //union elements
    for (int i = 0; i < operateCount; i++) {
      int p = random.nextInt(size);
      int q = random.nextInt(size);
      unionFind.unionElements(p, q);
    }
    //check union relations
    for (int i = 0; i < operateCount; i++) {
      int p = random.nextInt(size);
      int q = random.nextInt(size);
      unionFind.isConnected(p, q);
    }

    System.out.printf("Union-find performance test for %s, use %s s.\n",
        unionFind.getClass().getName(), (System.nanoTime() - start) / 1000000000.0);
  }

}