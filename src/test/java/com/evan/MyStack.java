package com.evan;



public class MyStack {
    private int[] array;
    private int maxSize;
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = new int[maxSize];
        top = -1;
    }

    // 压栈
    public void push(int value){
        if (top < maxSize-1){
            array[++top] = value;
        }
    }

    // 出栈
    public int pop(){
        return array[top--];

    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());





    }

}
