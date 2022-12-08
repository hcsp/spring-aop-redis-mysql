package com.github.hcsp.entity;

import java.util.LinkedList;

public class Stack {
    private final LinkedList<Object> data = new LinkedList<>();
    public void push(Object obj) {
        data.add(obj);
    }
    public Object pop(){
        return data.removeFirst();
    }
    public Object peek() {
        return data.getLast();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push("a");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
