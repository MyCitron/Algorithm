package com.dengchengchao.algorithm.util;

import com.dengchengchao.algorithm.sort.Sortable;

import java.util.Arrays;
import java.util.Random;
import java.util.SortedSet;

/**
 * @author dengchengchao
 * @date 2018/10/22 10:37
 */
public  class SortUtils {

   private SortUtils(){}

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i]<a[i - 1]) return false;
        }
        return true;
    }

    public static int[] getRandomIntNum(int length) {
        Random random = new Random();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = random.nextInt(length);
        }
        return ints;
    }

    public static boolean resultTest(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean testRepeatedly(Sortable sortAction){
        int[] lengths = {10,50,100,500,1000};
        for (int i=0;i<10;i++) {
            int count = new Random().nextInt(10);
            for (int j = 0; j < count; j++) {
                for (int length : lengths) {
                    int ints[] = getRandomIntNum(length);
                    sortAction.sort(ints);
                    boolean result = resultTest(ints);
                    if (!result) {
                        System.out.println(Arrays.toString(ints));
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
