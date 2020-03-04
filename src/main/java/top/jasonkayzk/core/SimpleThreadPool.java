package top.jasonkayzk.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 自己写的一个线程池
 * <p>
 * 使用java并发库下的阻塞队列来做,这样我们就不需要做额外的同步跟阻塞操作
 *
 * @author zk
 */
public class SimpleThreadPool implements Pool {

    /**
     * 存储工作的阻塞队列
     */
    private final BlockingQueue<Runnable> jobs = new LinkedBlockingQueue<>();

    /**
     * 存储工作线程的阻塞队列
     */
    private final BlockingQueue<Worker> workers = new LinkedBlockingQueue<>();

    /**
     * 指定池中线程大小进行初始化
     *
     * @param num 初始化线程池中线程数量
     */
    public SimpleThreadPool(int num) {
        initPool(num);
    }

    /**
     * 初始化线程池, 创建num个worker
     *
     * @param num 工人数
     */
    private void initPool(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            worker.start();
        }
    }

    @Override
    public int poolSize() {
        return workers.size();
    }

    @Override
    public void execute(Runnable runnable) {
        if (runnable != null) {
            jobs.add(runnable);
        }
    }

    /**
     * 关闭线程池:
     * <p>
     * 通过不断的循环来判断,任务队列是否已经清空,
     * 如果队列任务清空了,将工作者队列的线程停止
     * 打破循环,清空工作者队列
     */
    @Override
    public void shutDown() {
        while (true) {
            if (jobs.size() == 0) {
                for (Worker worker : workers) {
                    worker.stopRunning();
                }
                break;
            }
        }
        workers.clear();
    }

    /**
     * 添加新的工作者到工作者队列尾部
     */
    @Override
    public void addWorker(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.offer(worker);
            worker.start();
        }
    }

    /**
     * 移除工作者阻塞队列头部的线程
     */
    @Override
    public void removeWorker(int num) {
        for (int i = 0; i < num; i++) {
            try {
                workers.take().stopRunning();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 强行清空任务队列, 然后调用停止线程池的方法
     */
    @Override
    public void shutDownNow() {
        jobs.clear();
        shutDown();
    }

    private class Worker extends Thread {
        /**
         * 通过volatile修饰的变量,保证变量的可见性,从而能让线程马上得知状态
         */
        private volatile boolean isRunning = true;

        @Override
        public void run() {
            // 通过自旋不停的从任务队列中获取任务
            while (isRunning) {
                Runnable runnable = null;
                try {
                    // 如果工作队列为空,则阻塞
                    runnable = jobs.poll(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 获取的工作不为空, 执行
                if (runnable != null) {
                    System.out.println(getName() + " --> ");
                    runnable.run();
                }

                // 睡眠100毫秒, 验证shutdown是否是在任务执行完毕后才会关闭线程池
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getName() + "销毁...");
        }

        public void stopRunning() {
            this.isRunning = false;
        }
    }

}
