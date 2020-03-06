package com.evan;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 增强功能版栈
 */
public class ArrayStack {
    private Object[] elementData;
    private int top;
    private int size;

    public ArrayStack() {
        elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("初始化容量小于0");
        }
        elementData = new Object[initSize];
        this.top = -1;
        this.size = initSize;
    }

    public void push(Object value){
        isGrow(top+1);
        elementData[++top] = value;
    }

    //弹出栈顶元素
    public Object pop(){
        Object obj = peek();
        remove(top);
        return obj;
    }

    //获取栈顶元素
    public Object peek(){
        if(top == -1){
            throw new EmptyStackException();
        }
        return elementData[top];
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //删除栈顶元素
    public void remove(int top){
        //栈顶元素置为null
        elementData[top] = null;
        this.top--;
    }

    public boolean isGrow(int minCapacity){
        int oldCapacity = size;
        if (minCapacity >= oldCapacity){
            int newCapacity= 0;
            if ((oldCapacity<<1) -Integer.MAX_VALUE >0){
                newCapacity = Integer.MAX_VALUE;
            }else {
                newCapacity = (oldCapacity<<1);
            }
            this.size = newCapacity;
            int[] newArray = new int[size];
            elementData = Arrays.copyOf(elementData,size);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push("abc");
        stack.push("wers");
        stack.push(new BigDecimal(1000));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
