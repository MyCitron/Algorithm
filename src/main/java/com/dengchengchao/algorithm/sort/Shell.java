package com.dengchengchao.algorithm.sort;

import com.dengchengchao.algorithm.util.ResultPlay;
import com.dengchengchao.algorithm.util.SortUtils;

import java.util.Arrays;

/**
 * @author dengchengchao
 * @date 2018/10/25 15:08
 */
public class Shell {

    public static void sort(int[] a) {
        final int n = a.length;
        for (int h = n / 2; h > 0; h /= 2){ //设置增量
            for (int i = h; i < n ; i++){
                for (int j = i; j>=h  && a[j] < a[j - h]; j -= h) {//以冒泡排序的方式，从后向前冒泡
                    SortUtils.swap(a, j, j -h);
                }
            }
        }
    }

    public static void sort2(int[] a){
        final int n = a.length;
        for(int h=n/2;h>0;h/=2){//设置增量
            for(int i=0;i<n-h;i++){ //循环遍历
                int min=a[i];
                for(int j=i+h;j<n&&a[j]<min ;j+=h){ //只和每间隔相邻元素的元素排序
                        min=a[j];
                        SortUtils.swap(a,j,i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {10, 14, 13, 25, 33, 27, 25,59,39,65};

        int[] ts = {4, 5, 3, 2, 1};
        sort(ts);
        assert SortUtils.isSorted(ints);
        ResultPlay.run(() -> System.out.println(Arrays.toString(ts)));

    }
}
