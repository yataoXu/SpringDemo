package com.evan;

public class Sorts {
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
            //第 i轮排序的结果为
            System.out.print("第" + i + "轮排序后的结果为:");
            display(array);
        }
        return array;
    }


    public static int[] insertionSort(int[] array) {

        int j;
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            //记录要插入的数据
            int tmp = array[i];
            j = i;
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            array[j] = tmp;

            //第 i轮排序的结果为
            System.out.print("第" + i + "轮排序后的结果为:");
            display(array);
        }


        return array;
    }


    public static int[] choiceSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
//                array[i] = array[i] ^ array[min];
//                array[min] = array[i] ^ array[min];
//                array[i] = array[i] ^ array[min];
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            //第 i轮排序的结果为
            System.out.print("第" + (i ) + "轮排序后的结果为:");
            display(array);
        }
        return array;
    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
//        array = bubbleSort(array);
//        array = insertionSort(array);
        array = choiceSort(array);
        System.out.println("-----------------------");
        System.out.println("经过冒泡排序后的数组顺序为：");
        display(array);
    }

}