class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i < 11; i++)
            System.out.println(" this thread is running ... ");
    }
}