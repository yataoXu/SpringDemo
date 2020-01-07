package com.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {


    public static void incrementSameThreadId() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + "::" + ThreadLoalId.get() + "::");
        }
    }

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    incrementSameThreadId();
                    System.out.println("++++++++++++++++++++");
                }
            }).start();

        }
    }


}

class ThreadLoalId {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.incrementAndGet();
        }
    };

    public static int get() {
        return threadId.get();
    }

    public static void remove() {
        threadId.remove();
    }

    public static void set(int id) {
        threadId.set(id);
    }


}


