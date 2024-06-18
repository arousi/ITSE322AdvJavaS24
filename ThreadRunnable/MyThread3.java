public class MyThread3 extends Thread {
    public void run() {
        for (int k = 1; k <= 5; k++) {
            System.out.println("Thread 3 =  " + k);
        }
        System.out.println("Exit from Th3");
    }
}