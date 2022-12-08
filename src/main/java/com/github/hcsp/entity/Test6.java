package com.github.hcsp.entity;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        System.out.println(isValid("{()}"));
        System.out.println(isValid("[{]}"));
        System.out.println(isValid("[(]) "));
    }

    public static boolean isValid(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for (Character ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (!stack.isEmpty() && stack.peek() == map.get(ch)) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }

                default:
                    throw new IllegalArgumentException();
            }
        }
        return stack.isEmpty();


    }


}
