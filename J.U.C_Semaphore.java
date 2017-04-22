//Semaphore的函数列表

//构造函数

// 创建具有给定的许可数和非公平的公平设置的 Semaphore。
Semaphore(int permits)
// 创建具有给定的许可数和给定的公平设置的 Semaphore。
Semaphore(int permits, boolean fair)

//方法

// 从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
void acquire()
// 从此信号量获取给定数目的许可，在提供这些许可前一直将线程阻塞，或者线程已被中断。
void acquire(int permits)
// 从此信号量中获取许可，在有可用的许可前将其阻塞。
void acquireUninterruptibly()
// 从此信号量获取给定数目的许可，在提供这些许可前一直将线程阻塞。
void acquireUninterruptibly(int permits)
// 返回此信号量中当前可用的许可数。
int availablePermits()
// 获取并返回立即可用的所有许可。
int drainPermits()
// 返回一个 collection，包含可能等待获取的线程。
protected Collection<Thread> getQueuedThreads()
// 返回正在等待获取的线程的估计数目。
int getQueueLength()
// 查询是否有线程正在等待获取。
boolean hasQueuedThreads()
// 如果此信号量的公平设置为 true，则返回 true。
boolean isFair()
// 根据指定的缩减量减小可用许可的数目。
protected void reducePermits(int reduction)
// 释放一个许可，将其返回给信号量。
void release()
// 释放给定数目的许可，将其返回到信号量。
void release(int permits)
// 返回标识此信号量的字符串，以及信号量的状态。
String toString()
// 仅在调用时此信号量存在一个可用许可，才从信号量获取许可。
boolean tryAcquire()
// 仅在调用时此信号量中有给定数目的许可时，才从此信号量中获取这些许可。
boolean tryAcquire(int permits)
// 如果在给定的等待时间内此信号量有可用的所有许可，并且当前线程未被中断，则从此信号量获取给定数目的许可。
boolean tryAcquire(int permits, long timeout, TimeUnit unit)
// 如果在给定的等待时间内，此信号量有可用的许可并且当前线程未被中断，则从此信号量获取一个许可。
boolean tryAcquire(long timeout, TimeUnit unit)
