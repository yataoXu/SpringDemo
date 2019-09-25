package com.yatao.demo;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
//        array = bubbleSort(array);
//        array = insertionSort(array);
        array = mergesSort(array);
        System.out.println("-----------------------");
        System.out.println("经过排序后的数组顺序为：");
        display(array);
    }


    public static int[] mergesSort(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        if (array.length == 1) {
            return array;
        }

        // 将数组分为两半
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        System.out.println("array");
        display(array);
        // 嵌套调用，对两半分别进行排序
        left = mergesSort(left);
        right = mergesSort(right);
        System.out.println("left");
        display(left);
        System.out.println("right");
        display(right);


        // 合并排序后的数组
        int[] merged = merge(left, right);

        return merged;
    }

    /**
     * @param left- 第一个数组，- 第二个数组
     * @return int[]- 合并后的数组
     * @Description: 合并两个已经排序完毕的数组（从小到大）
     */
    private static int[] merge(int[] left, int[] right) {
        if (left == null) left = new int[0];
        if (right == null) right = new int[0];
        int[] merged = new int[left.length + right.length];

        int mi = 0, li = 0, ri = 0;
        // 轮流从两个数组中取出较小的值，放入合并后的数组中
        while (li < left.length && ri < right.length) {
            if(left[li] <= right[ri]){
                merged[mi] = left[li];
                li ++;

            }else {
                merged[mi] = right[ri];
                ri ++;
            }
            mi++;

        }

        // 将某个数组内剩余的数字放入合并后的数组中
        if (li <left.length){
            for (int i = li; i < left.length ; i++) {
                merged[mi]=left[i];
                mi ++;
            }

        }else{
            for (int i = ri; i < right.length; i++) {
                merged[mi] = right[i];
                mi++;
            }
        }

        return merged;
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
