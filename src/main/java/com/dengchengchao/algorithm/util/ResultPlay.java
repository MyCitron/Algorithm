package com.dengchengchao.algorithm.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author dengchengchao
 * @date 2018/10/18 14:04
 *
 * 打印测试时间
 */
public class ResultPlay {

    private static final String LINE="----------------";

    public static void run(Test test) {

        System.out.println(LINE);
        long beginTime = System.nanoTime();
        test.action();
        System.out.println(LINE);

        StringBuilder playLine = new StringBuilder();
        playLine.append("测试完成：\n");
        playLine.append("运行时间：").append((System.nanoTime() - beginTime)/1000).append(" ms\n");
        System.out.println(playLine);
    }



    public static void run(List<Test> testList){
        System.out.println(LINE);


        int count=1;
        long beginTime;
        for (Test test:testList){
            System.out.println("开始测试: 编号"+ count++);
            System.out.println("- - - - - - - - -");
            beginTime = System.nanoTime();
            test.action();
            StringBuilder playLine = new StringBuilder();
            playLine.append("编号：").append(count-1).append(" 测试完成：\n");
            playLine.append("运行时间：").append((System.nanoTime() - beginTime)/1000).append(" ms\n\n");
            System.out.println("- - - - - - - - -");
            System.out.println(playLine);
            System.out.println(LINE);
        }
    }

}
