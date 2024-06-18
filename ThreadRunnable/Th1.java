import java.util.*;

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i != 0; i++)
            System.out.println(" this thread is running ... "+i);
    }
}

public class Th1 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();

    }
}