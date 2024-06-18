class Runnable1 {
    public static void main(String[] args) {

        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);
        thread2.start();
        
    }
}