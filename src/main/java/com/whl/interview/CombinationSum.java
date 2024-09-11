package com.whl.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Hello-world
 * @description:
 * @author: whl
 * @create: 2024-09-06 17:22
 **/
public class CombinationSum {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 6, 8};
        int x = 8;
        List<List<Integer>> result = combinationSum(a, x);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] a, int x) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(a, x, 0, combination, result);
        return result;
    }

    private static void backtrack(int[] a, int remaining, int start, List<Integer> combination, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < a.length; i++) {
            if (a[i] <= remaining) {
                combination.add(a[i]);
                backtrack(a, remaining - a[i], i, combination, result); // Allowing the same element
                combination.remove(combination.size() - 1); // Backtrack
            }
        }
    }
}
