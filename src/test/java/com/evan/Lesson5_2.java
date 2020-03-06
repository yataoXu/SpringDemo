package com.evan;

import java.util.ArrayList;

/**
 * 一个整数可以被分解为多个整数的乘积，例如，6 可以分解为 2x3。
 * 请使用递归编程的方法，为给定的整数 n，找到所有可能的分解（1 在解中最多只能出现 1 次）。
 * 例如，输入8，输出是可以是 1x8, 8x1, 2x4, 4x2, 1x2x2x2, 1x2x4,
 */
public class Lesson5_2 {
    public static void main(String[] args) {
        int num = 8;
        Lesson5_2.recursion(num, new ArrayList<Integer>());

    }

    public static void recursion(int num, ArrayList<Integer> result) {
        if (num == 1) {
            if (!result.contains(1)) {
                result.add(1);
            }
            System.out.println(result);
        } else {
            for (int i = 1; i <= num; i++) {
                if ((i == 1) && result.contains(1)) continue;
                ArrayList<Integer> newResult = (ArrayList<Integer>) (result.clone());
                newResult.add(i);
                if (num % i != 0) {
                    continue;
                }
                recursion(num / i, newResult);
            }
        }

    }

}
