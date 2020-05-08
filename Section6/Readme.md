# 线程池和多线程案例

threadpool.ThreadVS

#  线程池简介
# 什么是线程池
线程池就是事先创建若干个可执行的线程放入一个池(容器)中,需要的时候从池中获取线程不用自行创建,使用完毕不需要销毁而是放回池中,从而减少创建和销毁线程对象的开销

# 线程池的好处
- 降低资源消耗
- 提高响应速度
- 提高线程的可管理性

# 如何独立设计一个线程池

线程池的设计.png

# 线程池的核心参数

- corePoolSize: 核心线程数量
- maximumPoolSize:最大线程数量
- KeepAliveTime:线程空闲后的存活时间
- unit:时间单位
- workQueue:用于存放任务的阻塞队列
- threadFactory:线程工具类
- handler:当队列和最大线程都满了之后的饱和策略

# 线程池的处理流程
线程池的处理流程.png

# 线程池可选择的阻塞队列

- 什么是阻塞队列
支持两个附加操作(阻塞的插入和移除的方法)的队列
    
    - 阻塞的插入:当队列满时,队列会阻塞插入元素的线程,直到队列不满

    - 阻塞的移除:如果队列为空时,获取元素的线程会等待队列变为非空.
 
线程池为我们提供的几种阻塞队列
- 无界阻塞队列(队列无限长,可以一直往里面追加元素)
- 有界阻塞队列
- 同步移交阻塞队列(这个队列是不存储元素的阻塞队列,每个插入的操作必须等到另一个线程去调用移除操作才能成功)

案例

threadpool.QueueTest

# 线程池可选择的饱和策略

- AbortPolicy终止策略(默认)
- DiscardPolicy抛弃策略
- DiscardOldestPolicy抛弃旧任务策略
- CallerRunsPolicy调用者运行策略
 
# 线程池的执行示意图
 
 线程池的执行示意图.png
 
# 常用线程池
## 常用线程池之newCachedThreadPool
常用线程池之newCachedThreadPool.png

## 常用线程池之newFixedThreadPool
newFixedThreadPool.png

## 常用线程池之newSingleThreadExecutor

常用线程池之newSingleThreadExecutor.png

##  利用线程池向线程提交任务

案例:threadpool.RunTest

# 线程池的状态
线程池的状态.png

