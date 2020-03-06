package com.evan;

public class BinarySearch {

    public static int findTwoPoint(int[] array, int key) {
        int start = 0;
        int last = array.length - 1;
        while (start <= last) {
            int mid = (last - start) / 2 + start;//防止直接相加造成int范围溢出
            if (key == array[mid]) {//查找值等于当前值，返回数组下标
                return mid;
            }
            if (key > array[mid]) {//查找值比当前值大
                start = mid + 1;
            }
            if (key < array[mid]) {//查找值比当前值小
                last = mid - 1;
            }
        }
        return -1;
    }


    public static int search(int[] arrays, int key, int low, int hight) {
        int mid = (hight - low) / 2 - low;
        if (key == arrays[mid]) {
            return mid;
        } else if (low > hight) {
            return -1;
        } else {
            if (key < arrays[mid]) {
                return search(arrays, key, low, mid - 1);
            }
            if (key > arrays[mid]) {
                return search(arrays, key, mid + 1, hight);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;
        int twoPoint = findTwoPoint(array, key);
        System.out.println(twoPoint);

        int search = search(array, key, 0, array.length - 1);
        System.out.println(search);

    }
}
