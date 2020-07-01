## 三人行-Java基础复习第九天



### 0. 今日目标



> **Java 锁**

- 公平锁 / 非公平锁
  - 公平锁： 多线程按照申请锁的顺序获取锁，类似排队。
  - 非公平锁：多个线程抢夺锁，容易导致优先级反转或饥饿现象

区别： 公平锁在获取锁时先查看此锁维护的**等待队列**，**为空**或者当前线程是等待队列的**队首**，则直接占有锁，否则插入到等待队列，FIFO原则。非公平锁比较粗鲁，上来直接**先尝试占有锁**，失败则采用公平锁方式。非公平锁的优点是**吞吐量**比公平锁更大。

`synchronized`和`juc.ReentrantLock`默认都是**非公平锁**。`ReentrantLock`在构造的时候传入`true`则是**公平锁**。





- 可重入锁 / 递归锁

  可重入锁又叫递归锁，指的同一个线程在**外层方法**获得锁时，进入**内层方法**会自动获取锁。也就是说，线程可以进入任何一个它已经拥有锁的代码块。比如`get`方法里面有`set`方法，两个方法都有同一把锁，得到了`get`的锁，就自动得到了`set`的锁。

  就像有了家门的锁，厕所、书房、厨房就为你敞开了一样。可重入锁可以**避免死锁**的问题。



示例： 

```java
package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone=new Phone();
        syncTest(phone);
        System.out.println();

        Thread t3=new Thread(phone);
        Thread t4=new Thread(phone);
        t3.start();
        t4.start();

    }

    private static void syncTest(Phone phone) {

        new Thread(()->{
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t2").start();
    }
}
class Phone implements Runnable{
    //Synchronized TEST

    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getId()+"\t"+"sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getId()+"\t"+"sendEmail()");
    }

    //Reentrant TEST

    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"\t"+"get()");
            set();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"\t"+"set()");
        }finally {
            lock.unlock();
        }
    }
}

```







- 自旋锁

  所谓自旋锁，就是尝试获取锁的线程不会**立即阻塞**，而是采用**循环的方式去尝试获取**。自己在那儿一直循环获取，就像“**自旋**”一样。这样的好处是减少**线程切换的上下文开销**，缺点是会**消耗CPU**。CAS底层的`getAndAddInt`就是**自旋锁**思想。

​            

示例：

```java
package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "BB").start();
    }

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t" + " come in ...");
        while (!atomicReference.compareAndSet(null, thread)) { }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t" + " unlock ...");
    }
}
```







- Synchronized和Lock的区别

  `synchronized`关键字和`java.util.concurrent.locks.Lock`都能加锁，两者有什么区别呢？

  1. **原始构成**：`sync`是JVM层面的，底层通过`monitorenter`和`monitorexit`来实现的。`Lock`是JDK API层面的。（`sync`一个enter会有两个exit，一个是正常退出，一个是异常退出）
  2. **使用方法**：`sync`不需要手动释放锁，而`Lock`需要手动释放。
  3. **是否可中断**：`sync`不可中断，除非抛出异常或者正常运行完成。`Lock`是可中断的，通过调用`interrupt()`方法。
  4. **是否为公平锁**：`sync`只能是非公平锁，而`Lock`既能是公平锁，又能是非公平锁。
  5. **绑定多个条件**：`sync`不能，只能随机唤醒。而`Lock`可以通过`Condition`来绑定多个条件，精确唤醒。



- Synchronizedu用法
  - 修饰的对象：
    1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
    2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
    3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
    4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。



> **线程间的通信**

- 方式一：使用 volatile关键字

  利用volatile的可见性：

  ```java
  package com.lmy.lock;
  /**
   * @Project java基础
   * @Package com.lmy.lock
   * @author Administrator
   * @date 2020/6/28 8:53
   * @version V1.0
   */
  
  import java.util.ArrayList;
  import java.util.List;
  import java.util.concurrent.TimeUnit;
  
  /**
   * @author Lmy
   * @ClassName SynchronizedTest01
   * @Description 测试
   * @date 2020/6/28 8:53
   **/
  
  public class SynchronizedTest01 {
      // 定义一个volatile变量作为通信的标志
      static volatile boolean flag = false;
  
      public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          // 定义 A 线程
          Thread threadA = new Thread(() -> {
              for (int i = 0; i <= 10; i++) {
                  list.add("AAA");
                  System.out.println("线程A向list集合中添加一个元素， 此时集合中元素个数为： " + list.size());
                  try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                  if (list.size() == 5) {
                      flag = true;
                  }
              }
          });
  
          // 定义 B 线程
          Thread threadB = new Thread(() -> {
              // 监听 flag
              while (true) {
                  if (flag) {
                      System.out.println("B线程接收到通知， 开始工作!");
                      break;
                  }
              }
          });
  
          // 先启动B 线程
          threadB.start();
          // 等待B线程启动结束
          try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
          // 启动A线程
          threadA.start();
      }
  
  
  }
  ```

  

- 方式二： 使用Object类的wait() 和 notify() 方法

  *Object*类提供了线程间通信的方法：*wait()*、*notify()*、*notifyaAl()*

   wait和 notify必须配合synchronized使用，wait方法释放锁，notify方法不释放锁

  ```java
  
  public class SynchronizedTest01 {
  
      public static void main(String[] args) {
          // 定义一个Object线程
          Object flag = new Object();
  
          List<String> list = new ArrayList<>();
          // 定义 A 线程
          Thread threadA = new Thread(() -> {
              synchronized (flag) {
                  for (int i = 1; i <= 10; i++) {
                      list.add("AAA");
                      System.out.println("线程A向list集合中添加一个元素， 此时集合中元素个数为： " + list.size());
                      try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                      if (list.size() == 5) {
                          flag.notify();
                      }
                  }
              }
          });
  
          // 定义 B 线程
          Thread threadB = new Thread(() -> {
              // 监听 flag
              while (true) {
                 synchronized (flag) {
                     if (list.size() != 5) {
                         try {
                             flag.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                     System.out.println("B线程接收到通知， 开始工作!");
                     break;
                 }
              }
          });
  
          // 先启动B 线程
          threadB.start();
          // 等待B线程启动结束
          try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
          // 启动A线程
          threadA.start();
      }
  
  
  }
  
  ```

  

程A发出notify()唤醒通知之后，依然是走完了自己线程的业务之后，线程B才开始执行，这也正好说明了，notify()方法不释放锁，而wait()方法释放锁。



- 方式三： 使用JUC工具类 CountDownLatch

  jdk1.5之后在*java.util.concurrent*包下提供了很多并发编程相关的工具类，简化了我们的并发编程代码的书写，***CountDownLatch***基于AQS框架，相当于也是维护了一个线程间共享变量state

  ```java
  public class SynchronizedTest01 {
  
      public static void main(String[] args) {
          CountDownLatch latch = new CountDownLatch(1);
  
          List<String> list = new ArrayList<>();
          // 定义 A 线程
          Thread threadA = new Thread(() -> {
  
              for (int i = 1; i <= 10; i++) {
                  list.add("AAA");
                  System.out.println("线程A向list集合中添加一个元素， 此时集合中元素个数为： " + list.size());
                  try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                  if (list.size() == 5) {
                      latch.countDown();
                  }
              }
  
          });
  
          // 定义 B 线程
          Thread threadB = new Thread(() -> {
              // 监听 flag
              while (true) {
                 if (list.size() != 5) {
                     try {
                         latch.await();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 System.out.println("B线程接收到通知， 开始工作!");
                 break;
             }
  
          });
  
          // 先启动B 线程
          threadB.start();
          // 等待B线程启动结束
          try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
          // 启动A线程
          threadA.start();
      }
  
  
  }
  
  ```

- 方式四：使用 ReentrantLock 结合 Condition

  ```java
  
  public class SynchronizedTest01 {
  
      public static void main(String[] args) {
          ReentrantLock lock = new ReentrantLock();
          Condition condition = lock.newCondition();
  
          List<String> list = new ArrayList<>();
          // 定义 A 线程
          Thread threadA = new Thread(() -> {
              lock.lock();
              try{
                  for (int i = 1; i <= 10; i++) {
                      list.add("AAA");
                      System.out.println("线程A向list集合中添加一个元素， 此时集合中元素个数为： " + list.size());
                      try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                      if (list.size() == 5) {
                          condition.signal();
                      }
                  }
  
              }catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  lock.unlock();
              }
  
          });
  
          // 定义 B 线程
          Thread threadB = new Thread(() -> {
              // 监听 flag
              lock.lock();
              try{
                  while (true) {
                      if (list.size() != 5) {
                          try {
                              condition.await();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                      System.out.println("B线程接收到通知， 开始工作!");
                      break;
                  }
              }catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  lock.unlock();
              }
  
          });
  
          // 先启动B 线程
          threadB.start();
          // 等待B线程启动结束
          try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
          // 启动A线程
          threadA.start();
      }
  
  
  }
  ```

  显然这种方式使用起来并不是很好，代码编写复杂，而且线程B在被A唤醒之后由于没有获取锁还是不能立即执行，也就是说，A在唤醒操作之后，并不释放锁。这种方法跟 ***Object*** 的 ***wait()*** 和 ***notify()*** 一样。



- 方式五：基本LockSupport实现线程间的阻塞和唤醒

  ***LockSupport*** 是一种非常灵活的实现线程间阻塞和唤醒的工具，使用它不用关注是等待线程先进行还是唤醒线程先运行，但是得知道线程的名字。

  ```java
  
  public class SynchronizedTest01 {
  
      public static void main(String[] args) {
  
          List<String> list = new ArrayList<>();
  
          // 定义 B 线程
          Thread threadB = new Thread(() -> {
              // 监听 flag
              while (true) {
                  if (list.size() != 5) {
                      LockSupport.park();
                      System.out.println("B线程接收到通知， 开始工作!");
                      break;
                  }
              }
          });
  
          // 定义 A 线程
          Thread threadA = new Thread(() -> {
  
              for (int i = 1; i <= 10; i++) {
                  list.add("AAA");
                  System.out.println("线程A向list集合中添加一个元素， 此时集合中元素个数为： " + list.size());
                  try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                  if (list.size() == 5) {
                      LockSupport.unpark(threadB);
                  }
              }
  
          });
  
  
          // 启动A线程
          threadA.start();
          // 启动B 线程
          threadB.start();
      }
  
  
  }
  ```

  

