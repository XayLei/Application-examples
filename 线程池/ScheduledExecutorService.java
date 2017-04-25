//http://www.blogjava.net/xylz/archive/2011/01/10/342738.html

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//这个例子中启动了默认三个线程的线程池，调度两个周期性任务。
//第一个任务是每隔1秒执行一次，第二个任务是以固定1秒的间隔执行，这两个任务每次执行的时间都是2秒

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService execService =   Executors.newScheduledThreadPool(3);
		
		//scheduleAtFixedRate是每次相隔相同的时间执行任务，如果任务的执行时间比周期还长，那么下一个任务将立即执行。
		//例如这里每次执行时间2秒，而周期时间只有1秒，那么每次任务开始执行的间隔时间就是2秒。
        execService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+" -> "+System.currentTimeMillis());
                try {
                    Thread.sleep(2000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
		
        /*
		scheduleWithFixedDelay描述是下一个任务的开始时间与上一个任务的结束时间间隔相同。
		流入这里每次执行时间2秒，而周期时间是1秒，那么两个任务开始执行的间隔时间就是2+1=3秒
		*/
        execService.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+" -> "+System.currentTimeMillis());
                try {
                    Thread.sleep(2000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
        Thread.sleep(5000L);
        execService.shutdown();
    }
}

/*
一次可能的输出如下：

pool-1-thread-1 -> 1294672392657
pool-1-thread-2 -> 1294672392659
pool-1-thread-1 -> 1294672394657
pool-1-thread-2 -> 1294672395659
pool-1-thread-1 -> 1294672396657
*/