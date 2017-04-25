//http://www.blogjava.net/xylz/archive/2011/01/10/342738.html

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//���������������Ĭ�������̵߳��̳߳أ�������������������
//��һ��������ÿ��1��ִ��һ�Σ��ڶ����������Թ̶�1��ļ��ִ�У�����������ÿ��ִ�е�ʱ�䶼��2��

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService execService =   Executors.newScheduledThreadPool(3);
		
		//scheduleAtFixedRate��ÿ�������ͬ��ʱ��ִ��������������ִ��ʱ������ڻ�������ô��һ����������ִ�С�
		//��������ÿ��ִ��ʱ��2�룬������ʱ��ֻ��1�룬��ôÿ������ʼִ�еļ��ʱ�����2�롣
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
		scheduleWithFixedDelay��������һ������Ŀ�ʼʱ������һ������Ľ���ʱ������ͬ��
		��������ÿ��ִ��ʱ��2�룬������ʱ����1�룬��ô��������ʼִ�еļ��ʱ�����2+1=3��
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
һ�ο��ܵ�������£�

pool-1-thread-1 -> 1294672392657
pool-1-thread-2 -> 1294672392659
pool-1-thread-1 -> 1294672394657
pool-1-thread-2 -> 1294672395659
pool-1-thread-1 -> 1294672396657
*/