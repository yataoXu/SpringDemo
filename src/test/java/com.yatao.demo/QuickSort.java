package com.yatao.demo;


/**
 *  快速排序
 *
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
    }

    private static int[] quick_sort(int[] array, int p, int r) {


        if (p >= r) {
            return array;
        }
        //设置最左边的元素为基准值
        int key = array[p];

        System.out.println("-----------------------");
        System.out.println("排序前数组顺序为");
        display(array);
        System.out.println("基准值为：" + key);
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = p;
        int j = r;

        System.out.println("p 所指的下标值" + i + ",p 对应的值" + array[i]);
        System.out.println("r 所指的下标值" + j + ",p 对应的值" + array[j]);
        while (i < j) {
            // j 向左移，直到遇到比key小的值
            while (array[j] > key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (array[i] <= key && i < j) {
                i++;
            }


            System.out.println(" 需要交换的下标值" + i + ", 对应的值" + array[i]);
            System.out.println(" 需要交换的下标值" + j + ", 对应的值" + array[j]);
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            System.out.println("排序后数组顺序为：");
            display(array);
            System.out.println("-----------------------");

        }

        array[p] = array[i];
        array[i] = key;

        quick_sort(array, p, i - 1);
        quick_sort(array, i + 1, r);


        return array;

    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
