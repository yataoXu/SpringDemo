package com.yatao.demo;

import java.lang.reflect.GenericDeclaration;

public class BinarySearch1 {

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param array
     * @param key
     * @return
     */
    public static int findTwoPoint(int[] array, int key) {
        int start = 0;
        int last = array.length - 1;
        while (start <= last) {
            int mid = (last - start) / 2 + start;//防止直接相加造成int范围溢出
            if (key > array[mid]) {//查找值比当前值大
                start = mid + 1;
            } else if (key < array[mid]) {//查找值比当前值小
                last = mid - 1;
            } else {
                if (mid == 0 || (array[mid - 1] != key)) return mid;
                else last = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param array
     * @param key
     * @return
     */
    public static int findTwoPoint2(int[] array, int key) {
        int start = 0;
        int last = array.length - 1;
        while (start <= last) {
            int mid = (last - start) / 2 + start;//防止直接相加造成int范围溢出
            if (key > array[mid]) {//查找值比当前值大
                start = mid + 1;
            } else if (key < array[mid]) {//查找值比当前值小
                last = mid - 1;
            } else {
                if (mid == last - 1 || (array[mid + 1] != key)) return mid;
                else last = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param array
     * @param key
     * @return
     */
    public static int findTwoPoint3(int[] array, int key) {
        int start = 0;
        int last = array.length - 1;

        while (start <= last) {
            //防止直接相加造成int范围溢出
            int mid = (last - start) / 2 + start;
            if (key > array[mid]) {
                start = mid + 1;
            } else {
                if ((mid == 0) || (array[mid - 1] < key)) return mid;
                else last = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param array
     * @param key
     * @return
     */
    public static int findTwoPoint4(int[] array, int key) {
        int start = 0;
        int last = array.length - 1;

        while (start <= last) {
            //防止直接相加造成int范围溢出
            int mid = (last - start) / 2 + start;
            if (key > array[mid]) {
                start = mid + 1;
            } else {
                if ((mid == mid - 1) || (array[mid + 1] < key)) return mid;
                else last = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 6, 7, 8, 9};
        int key = 5;
        int twoPoint = findTwoPoint(array, key);
        System.out.println(twoPoint);

        int key2 = 5;
        int twoPoint2 = findTwoPoint2(array, key2);
        System.out.println(twoPoint2);

        int key3 = 3;
        int twoPoint3 = findTwoPoint3(array, key3);
        System.out.println(twoPoint3);


        int key4 = 3;
        int twoPoint4 = findTwoPoint4(array, key4);
        System.out.println(twoPoint4);
    }
}
