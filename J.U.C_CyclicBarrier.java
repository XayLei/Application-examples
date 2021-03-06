//参考：http://www.cnblogs.com/skywang12345/p/3533995.html
//新建5个线程，这5个线程达到一定的条件时，它们才继续往后运行

import java.util.concurrent.CyclicBarrier;  
import java.util.concurrent.BrokenBarrierException;
 
public class CyclicBarrierTest1 {
 
     private static int SIZE = 5;
     private static CyclicBarrier cb;
     public static void main(String[] args) {
 
         //使用了第一种构造方法
         cb = new CyclicBarrier(SIZE);
 
         // 新建5个任务
         for(int i=0; i<SIZE; i++)
             new InnerThread().start();
     }
 
     static class InnerThread extends Thread{
         public void run() {
             try {
                 System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
 
                 // 将cb的参与者数量加1
                 cb.await();
 
                 // cb的参与者数量等于5时，才继续往后执行
                 System.out.println(Thread.currentThread().getName() + " continued.");
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
 }
/*
运行结果：
 Thread-1 wait for CyclicBarrier.
 Thread-2 wait for CyclicBarrier. 
 Thread-3 wait for CyclicBarrier.
 Thread-4 wait for CyclicBarrier.
 Thread-0 wait for CyclicBarrier.
 Thread-0 continued.
 Thread-4 continued.
 Thread-2 continued.
 Thread-3 continued.
 Thread-1 continued.
*/
