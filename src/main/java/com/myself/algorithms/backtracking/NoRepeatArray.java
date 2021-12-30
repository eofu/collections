package com.myself.algorithms.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法-给定一个不重复数组，输出所有不同的排列组合
 */
public class NoRepeatArray {
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] i = {1, 2, 3};
        List<List<Integer>> permute = permute(i);
        System.out.println(permute.size());
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    static List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int num : nums) {
            // 排除不合法的选择
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}
