package me.ning.threadd;

public class ThreadDemo {

    public static void main(String []args) throws InterruptedException {
        Object object = new Object();
        String str = new String("sfasdf");


        System.out.println(str);
        System.out.println(Thread.currentThread().getContextClassLoader().getClass().getName());
    }
}
