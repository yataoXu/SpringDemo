package com.evan;

public class Demo1 {

    public static void main(String[] args) {
        int a = 1;
        int ret;
        int res;
        ret = add(3, 5);
        res = ret + a;
        System.out.println(res);

    }

    public static int add(int x, int y) {
        int sum = 0;
        sum = x + y;
        return sum;
    }
}
