package threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {

    /**
     * 有界阻塞队列
     *
     * @throws InterruptedException
     */
    @Test
    public void arrayBlockingQueueTest() throws InterruptedException {
        // 基于数组的有界阻塞队列
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(10);
        for (int i = 0; i <= 20; i++) {
            integers.put(i);
            System.out.println("向队列中添加值:" + i);
        }
    }

    /**
     * 有界阻塞队列
     *
     * @throws InterruptedException
     */
    @Test
    public void linkedBlockingQueueTest() throws InterruptedException {
        // 基于链表的有界阻塞队列(如果不传入Capacity参数的话是无界阻塞队列)
        LinkedBlockingQueue<Integer> integers = new LinkedBlockingQueue<>(10);
        for (int i = 0; i <= 20; i++) {
            integers.put(i);
            System.out.println("向队列中添加值:" + i);
        }
    }

    /**
     * 同步移交阻塞队列
     */
    @Test
    public void synchronousQueueTest() throws InterruptedException {

        SynchronousQueue queue = new SynchronousQueue<Integer>();

        /**
         * 插入线程
         */
        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("插入成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        /**
         * 删除线程
         */
        new Thread(() -> {
            try {
                queue.take();
                System.out.println("从线程中删除成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        Thread.sleep(1000 * 60);
    }
}
