package com.dengchengchao.algorithm.stack;

import java.util.LinkedList;

/**
 * @author dengchengchao
 * @date 2018/10/19 10:57
 */
public class Stack<T> {

    private LinkedList<T> linkedList=new LinkedList<>();


    public void push(T o){
        linkedList.push(o);
    }

    public T pop(){
        return linkedList.poll();
    }

    public T top(){
        return linkedList.peek();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

}
