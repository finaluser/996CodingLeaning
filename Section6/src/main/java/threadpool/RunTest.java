package threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 向线程池提交任务案例
 */
public class RunTest {
    @Test
    public void submitTest() throws InterruptedException, ExecutionException {
        // 创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 利用submit方法提交任务,接收任务的返回结果
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(1000 * 3);
            return 1 * 10;
        });
        /**
         * 阻塞方法,直到任务有返回值后,才向下执行
         */
        Integer integer = future.get();
        System.out.println("执行结果:" + integer);
    }

    @Test
    public void executeTest() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 利用submit方法提交任务,无返回结果
        threadPool.execute(() -> {
            try {
                Thread.sleep(1000L * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer num = 2 * 10;
            System.out.println("执行结果:" + num);
        });
        /**
         * 阻塞方法,直到任务有返回值后,才向下执行
         */
        Thread.sleep(1000L * 5);
    }
}
