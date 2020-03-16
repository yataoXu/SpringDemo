package com.evan.jvm;

import java.net.InetAddress;
import java.util.Map;
import java.util.Properties;

public class L1CacheMiss {
    private static final int RUNS = 10;
    private static final int DIMENSION_1 = 1024 * 1024;
    private static final int DIMENSION_2 = 62;

    private static long[][] longs;

    public static void main(String[] args) throws Exception {
        longs = new long[DIMENSION_1][];
        for (int i = 0; i < DIMENSION_1; i++) {
            longs[i] = new long[DIMENSION_2];
        }

        Properties props=System.getProperties();
        System.out.println("操作系统的名称："+props.getProperty("os.name"));

        System.out.println("starting....");


        final long start = System.nanoTime();
        long sum = 0L;
        for (int r = 0; r < RUNS; r++) {
            // 1. slow
//            for (int j = 0; j < DIMENSION_2; j++) {
//                for (int i = 0; i < DIMENSION_1; i++) {
//                    sum += longs[i][j];
//                }
//            }

            // 2. fast
            for (int i = 0; i < DIMENSION_1; i++) {
                for (int j = 0; j < DIMENSION_2; j++) {
                    sum += longs[i][j];
                }
            }
        }
        System.out.println("duration = " + (System.nanoTime() - start));
    }
}
