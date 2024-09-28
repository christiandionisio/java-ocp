import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreateThread {

    private static int counter = 0;
    
    public static void main(String ...args) throws Exception {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++)
                System.out.println("Printing record: " + i);
        };

        // {
        //     System.out.println("begin");
        //     new Thread(printInventory).start();
        //     new Thread(printRecords).start();
        //     new Thread(printInventory).start();
        //     System.out.println("end");

        //     // // run() methods executes sequencially, it doesn't create a threaad
        //     // System.out.println("begin");
        //     // new Thread(printInventory).run();
        //     // new Thread(printRecords).run();
        //     // new Thread(printInventory).run();
        //     // System.out.println("end");
        // }

        // {
        //     // Creates only one thread, therefore service.exeuctor
        //     // doesn't create anohter thread, only executes
        //     ExecutorService service = Executors.newSingleThreadExecutor();
        //     try {
        //         System.out.println("begin");
        //         service.execute(printInventory);
        //         service.execute(printRecords);
        //         service.execute(printInventory);
        //         System.out.println("end");
        //     } finally {
        //         service.shutdown();
        //     }
        // }

        
        // {
        //     ExecutorService service = Executors.newSingleThreadExecutor();;
        //     try {
        //         Future<?> result = service.submit(() -> {
        //             try {Thread.sleep(5000);} catch(InterruptedException e) {}
        //             for(int i = 0; i < 1_000_000; i++) counter++;
        //         });
        //         System.out.println(result.get(10, TimeUnit.SECONDS)); // Returns null for Runnable
        //         System.out.println("Reached!");
        //     } catch (TimeoutException e) {
        //         System.out.println("Not reached in time");
        //     } finally {
        //         service.shutdown();
        //     }
        // }


        // // Using callable
        // {
        //     var service = Executors.newSingleThreadExecutor();
        //     try {
        //         Future<Integer> result = service.submit(() -> 30 + 11);
        //         System.out.println(result.get());   // 41
        //     } finally {
        //         service.shutdown();
        //     }
        // }


        // // ScheduleExecutors
        // {
        //     ScheduledExecutorService service
        //         = Executors.newSingleThreadScheduledExecutor();
        //     Runnable task1 = () -> {
        //         try {Thread.sleep(6000);} catch(InterruptedException e) {}
        //         System.out.println("Hello Zoo");
        //     };
        //     Callable<String> task2 = () -> "Monkey";
        //     try {
        //         ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        //         ScheduledFuture<?> r2 = service.schedule(task2, 15, TimeUnit.SECONDS);
        //         System.out.println(r2.get());

        //     } finally {
        //         service.shutdown();
        //     }
        //         // service.scheduleAtFixedRate(task1, 5, 4, TimeUnit.SECONDS); // no waits to finish task1
        //         // service.scheduleWithFixedDelay(task1, 2, 5, TimeUnit.SECONDS);  // waits to finish task1
        // }


        //Locks methods
        {
            Lock lock = new ReentrantLock();
            new Thread(() -> printHello(lock)).start();
            // Thread.sleep(1000);
            if(lock.tryLock()) {
                try {
                    System.out.println("Lock obtained, entering protected code");
                } finally {
                    System.out.println("protected code unlocking");
                    lock.unlock();
                }
            } else {
                System.out.println("Unable to acquire lock, doing something else");
            }
        }
        {
            Lock lock = new ReentrantLock();
            new Thread(() -> printHello(lock)).start();
            // Thread.sleep(1000);
            if(lock.tryLock(10,TimeUnit.SECONDS)) {
                try {
                    // lock.lock();
                    System.out.println("Lock obtained, entering protected code");
                } finally {
                    System.out.println("protected code unlocking");
                    lock.unlock();
                    // lock.unlock();
                }
            } else {
                System.out.println("Unable to acquire lock, doing something else");
            }
        }
    }


    public static void printHello(Lock lock) {
        try {
            lock.lock();
            System.out.println("Hello");
            // Thread.sleep(12000);
            
        } finally {
            System.out.println("Unlocking printHello");
            lock.unlock();
        } 
    }

}