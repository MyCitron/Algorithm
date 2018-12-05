package com.dengchengchao.algorithm.sort;

import com.dengchengchao.algorithm.util.ResultPlay;
import com.dengchengchao.algorithm.util.SortUtils;

import java.util.Arrays;

/**
 * @author dengchengchao
 * @date 2018/10/23 9:45
 */
public class Insertion {
    public static void sort(int[] a) {
        final int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j]<a[j - 1]; j--) {
                SortUtils.swap(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {5, 2, 1, 4, 3};
        sort(ints);
        assert SortUtils.isSorted(ints);
        ResultPlay.run(() -> System.out.println(Arrays.toString(ints)));

    }
}


