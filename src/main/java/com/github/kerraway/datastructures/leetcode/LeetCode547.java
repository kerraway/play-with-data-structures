package com.github.kerraway.datastructures.leetcode;

import com.github.kerraway.datastructures.unionfind.UnionFindImplV6;

import java.util.Set;
import java.util.TreeSet;

/**
 * 547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 * <p>
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，
 * B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0], [1,1,0], [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。第2个学生自己在一个朋友圈。所以返回2。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [[1,1,0], [1,1,1], [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * <p>
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 *
 * @author kerraway
 * @date 2019/04/19
 */
public class LeetCode547 {

  public int findCircleNum(Integer[][] matrix) {
    int n = matrix.length;
    UnionFindImplV6 unionFind = new UnionFindImplV6(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (matrix[i][j] == 1) {
          unionFind.unionElements(i, j);
        }
      }
    }

    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      set.add(unionFind.get(i));
    }
    return set.size();
  }

}
