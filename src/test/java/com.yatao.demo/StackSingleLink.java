package com.yatao.demo;

public class StackSingleLink {

    private int size;//链表节点的个数
    private Node head;//头节点

    public StackSingleLink() {
        size = 0;
        head = null;
    }


    private class Node {
        private Object data;//每个节点的数据
        private Node next;//每个节点指向下一个节点的连接

        public Node(Object data) {
            this.data = data;
        }
    }


    //添加元素
    public void push(Object obj) {
        addHead(obj);
    }


    //在链表头添加元素
    public Object addHead(Object obj){
        Node newNode = new Node(obj);
        if (size ==0){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
        return obj;
    }

    //移除栈顶元素
    public Object pop() {
        Object obj = deleteHead();
        return obj;
    }

    public Object deleteHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //判断是否为空
    public boolean isEmpty() {
        return (size==0);
    }

    //打印栈内元素信息
    public void display() {
        if(size >0){
            Node node = head;
            int tempSize = size;
            if(tempSize == 1){//当前链表只有一个节点
                System.out.println("["+node.data+"]");
                return;
            }
            while(tempSize>0){
                if(node.equals(head)){
                    System.out.print("["+node.data+"->");
                }else if(node.next == null){
                    System.out.print(node.data+"]");
                }else{
                    System.out.print(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else{//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }
    }


    public static void main(String[] args) {
        StackSingleLink stackSingleLink = new StackSingleLink();
        stackSingleLink.push("abc");
        stackSingleLink.push("def");
        System.out.println(stackSingleLink.pop());
        System.out.println(stackSingleLink.pop());
    }
}
