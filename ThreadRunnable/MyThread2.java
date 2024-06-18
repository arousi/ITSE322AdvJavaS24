class MyThread2 extends Thread {
    public void run() {
        for (int j = 1; j <= 5; j++) {
            System.out.println("Thread 2 =  " + j);
        }
        System.out.println("Exit from Th2");
    }
}
