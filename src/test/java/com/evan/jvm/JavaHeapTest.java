package com.evan.jvm;

/**
 * @Description
 * @ClassName JavaHeapTest
 * @Author Evan
 * @date 2020.03.16 21:01
 */
public class JavaHeapTest {
    public final static int OUTOFMEMORY = Integer.MAX_VALUE;

    private String oom;

    private int length;

    StringBuffer tempOOM = new StringBuffer();

    public JavaHeapTest(int len) {
        this.length = len;

        int i = 0;
        while (i < len) {
            i++;
            try {
                tempOOM.append("a");
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }

}
