// Note: the tasks executed in a thread are executed serially

public class ThreadExample {

    class DownloadImage{
        public synchronized void downloadImage(String image, int size){
            for (int i = 0; i < size; i++) {
                System.out.println("..downloading pipopipo" + image + i + ".jpg");
            }
        }
    }


    class YourThread extends Thread{
        DownloadImage dref; // reference variable
        YourThread (DownloadImage dref){
            this.dref = dref;
        }

        @Override
        public void run(){
            dref.downloadImage("cat", 1000);
        }
    }


    static class MyThread extends Thread{
    // static class MyThread implements Callable{ 
    // static class MyThread implements Runnable{
        
        DownloadImage dref; // reference variable
        MyThread (DownloadImage dref){
            this.dref = dref;
        }

        @Override
        public void run(){
            // for (int i = 0; i < 100; i++) {
            //     System.out.println("..downloading howhow" + i + ".jpg");
            // }
                dref.downloadImage("dog", 1000);
        }
    }

    public static void main(String[] args) {
        System.out.println("Application starting: ");
        // Runnable t = new MyThread();
        DownloadImage dref = new DownloadImage();
        MyThread t1 = new MyThread(dref);
        YourThread t2 = new YourThread(dref);
        t1.start();
        
        // try{
        //     t1.join();
        // }
        // catch(Exception e){
        //     e.printStackTrace();
        // }
        t2.start();

        // Thread T = new Thread(t);
        // T.start();

        // task 2
        // for (int i = 0; i < 100; i++) {
        //     System.out.println("..downloading mau" + i + ".jpg");
        // }

        // task 3
        System.out.println("Application closed.");
    }
}