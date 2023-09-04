package controller;

/* 
   To extend a new thread of execution, we declare a class
   to be a subclass of {@code Thread}. This subclass should
   override the {@code run} method of class {@code Thread}.
   An instance of the subclass can then be allocated and 
   started.
*/
public class ThreadMethod extends Thread {

    private int id; // Thread id.

    public ThreadMethod() {
        this.id = (int) getId();
    }

    @Override
    public void run() {
        System.out.printf("#%d\n", id);
    }

}