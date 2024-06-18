class MyThread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 1 = " + i);
        }
        System.out.println("Exit from Th1");
    }
}
