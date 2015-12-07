package com.kblyumkin.lecture8.examples.mystack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(stack.toString());
        System.out.println("Popping 2 elements");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("In my stack left on two elements less");
        System.out.println(stack.toString());
        System.out.println("Pushing 3 elements - 11, 12, 17");
        stack.push(11);
        stack.push(12);
        stack.push(17);
        System.out.println(stack.toString());

        for (int i : stack) {
            System.out.print(i + ", ");
            System.out.println(stack.toString());
        }

    }
}
