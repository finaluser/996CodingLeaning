package threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVS {

    @Test
    public void newHandle() throws InterruptedException {
        // 开启一个线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int request = 1; request <= 100; request++) {
            threadPool.execute(() -> {
                System.out.println("文档处理开始");
            });
            try {
                // 模拟将Word文档转换为PDF格式:处理时常很长
                Thread.sleep(1000L * 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("文档处理结束");
        }
        Thread.sleep(1000L * 30);
    }


    @Test
    public void oldHandle() throws InterruptedException {
        //循环模拟100个用户进行请求的场景
        for (int request = 1; request <= 100; request++) {
            new Thread(() -> {
                System.out.println("文档处理开始");
                try {
                    // 模拟将Word文档转换为PDF格式:处理时常很长
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束");
            }).start();
        }
        Thread.sleep(1000L * 30);
    }
}
