import java.util.*;


public class MyThreadTest {
    public static void main(String args[]) {
        MyThread1 tr1 = new MyThread1();
        MyThread2 tr2 = new MyThread2();
        MyThread3 tr3 = new MyThread3();
        tr1.start();
        tr2.start();
        tr3.start();
    }
}