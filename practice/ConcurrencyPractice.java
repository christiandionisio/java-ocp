import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.util.Map.Entry;

public class ConcurrencyPractice {
    public static void main(String ...args) throws Exception {


        // // ConcurrentHashMap
        // {
        //     class Cache {
        //         static ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<>();
        //     }

        //     Cache.chm.put("a", "aaa");
        //     Cache.chm.put("b", "bbb");
        //     Cache.chm.put("c", "ccc");
        //     System.out.println(Cache.chm);

        //     new Thread() {
        //         public void run() {
        //             System.out.println("Destroyer thread");
        //             Iterator<Entry<String, Object>> it = Cache.chm.entrySet().iterator();
        //             while(it.hasNext()) {
        //                 Entry<String, Object> en = it.next();
        //                 if (en.getKey().equals("a") || en.getKey().equals("b")) {
        //                     it.remove();
        //                     System.out.println("Removed " + en);
        //                 }
        //             }
        //         }
        //     }.start();

        //     new Thread() {
        //         public void run() {
        //             Iterator<Entry<String, Object>> it = Cache.chm.entrySet().iterator();       // this will take a copy of chm at this point and shows in the while, 
        //                                                                                         // this will not update while the original chm is removing elements
        //             while(it.hasNext()) {
        //                 Entry<String, Object> en = it.next();
        //                 System.out.println(en.getKey() + ", ");
        //             }
        //         }
        //     }.start();

        // }

        // // syncronized deadlock
        // {
        //     class Test extends Thread {
        //         boolean flag = false;
        //         public Test(boolean f) {flag = f;}
        //         static Object obj1 = new Object();
        //         static Object obj2 = new Object();

        //         public void m1() {
        //             synchronized(obj1) {
        //                 System.out.print("1 ");
        //                 synchronized(obj2) {
        //                     System.out.println("2");
        //                 }
        //             }
        //         }

        //         public void m2() {
        //             synchronized(obj2) {
        //                 System.out.print("2 ");
        //                 synchronized(obj1) {
        //                     System.out.println("1");
        //                 }
        //             }
        //         }

        //         public void run() {
        //             if(flag) {m1(); m2();}
        //             else {m2(); m1();}
        //         }
        //     }

        //     new Test(true).start();
        //     new Test(false).start();
        // }


        // // Locks trylock
        // {
        //     class T extends Thread {
        //         public static Lock lock = new ReentrantLock();
        //         public T(String name){super(name);}
        //         static StringBuilder data = new StringBuilder();

        //         public void run() {
        //             if(lock.tryLock()) {
        //                 System.out.println("Trylock ok");
        //                 try {
        //                     lock.lock();
        //                     data.append("hello");
        //                 } finally {
        //                     lock.unlock();
        //                     // lock.unlock();       // must unlock twice becuase tyLock
        //                 }
        //             }
        //         }
        //     }

        //     T t1 = new T("T1");
        //     t1.start();
        //     try {
        //         t1.lock.lock();
        //         System.out.println(t1.data);
        //     } catch(Exception e){

        //     } finally {
        //         t1.lock.unlock();
        //     }
        // }


        // // Executors Callable Future
        // {
        //     class MyCallable implements Callable<String> {
        //         public String call() throws Exception {
        //             Thread.sleep(10000);
        //             return "DONE";
        //         }
        //     }

        //     var es = Executors.newSingleThreadExecutor();
        //     var future = es.submit(new MyCallable());
        //     System.out.println(future.get());
        //     es.shutdownNow();

        // }


        // synchornized deadlock
        {
            class TestClass {
                static StringBuffer sb1 = new StringBuffer();
                static StringBuffer sb2 = new StringBuffer();
            }

            new Thread(
                new Runnable() {
                    public void run() {
                        synchronized(TestClass.sb1) {
                            TestClass.sb1.append("X");
                            synchronized(TestClass.sb2) {
                                TestClass.sb2.append("Y");
                            }
                        }
                        System.out.println(TestClass.sb1);
                    }
                }
            ).start();

            new Thread(
                new Runnable() {
                    public void run() {
                        synchronized(TestClass.sb2) {
                            TestClass.sb2.append("Y");
                            synchronized(TestClass.sb1) {
                                TestClass.sb1.append("X");
                            }
                        }
                        System.out.println(TestClass.sb2);
                    }
                }
            ).start();
        }

    }
}