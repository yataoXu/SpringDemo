package com.yatao.demo;

import org.junit.Test;

public class test {
//    public static void main(String[] args) {
//        int[] a = new int[2];
//
//        String[] b = new String [2];
//        b[0] ="abc";
//        b[1] = "cde";
//        for (int i = 0; i < b.length; i++) {
//            System.out.println(b[i]);
//        }
//
//    }


    @Test
    public void testSingleLinkedList(){
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
    }

}