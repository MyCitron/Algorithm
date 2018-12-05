package com.dengchengchao.algorithm.sort;

import com.dengchengchao.algorithm.util.SortUtils;


/**
 * @author dengchengchao
 * @date 2018/10/22 10:17
 */
public class Selection implements  Sortable{

    @Override
    public void sort(int[] a) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;//用来寻找集合中最小数字
            for (int j = i + 1; j < N; j++) {
                if (a[j]<a[min]) {
                    min = j;
                }
            }
            SortUtils.swap(a, i, min);
        }
    }

    public static void main(String[] args) {
       assert  SortUtils.testRepeatedly(new Selection()); //add VM Option: -ea
    }
}
