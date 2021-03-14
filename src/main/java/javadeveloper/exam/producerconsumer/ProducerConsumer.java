package javadeveloper.exam.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable{
    int workItem;
    BlockingQueue<Integer> workItemQueue;

    public Producer(BlockingQueue<Integer> workItemQueue){
        this.workItemQueue = workItemQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                //synchronized makes this code block atomic
                synchronized (this) {
                    Thread.sleep(1000);
                    int nextWorkItem = workItem++;
                    System.out.println("Added WorkItem: " + workItem);
                    workItemQueue.put(nextWorkItem);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    String consumerName;
    BlockingQueue<Integer> workItemQueue;

    public Consumer(BlockingQueue<Integer> workItemQueue,String consumerName){
        this.workItemQueue = workItemQueue;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep((long) (10000 * Math.random()));
                System.out.println("Consumer " + consumerName + " Processing Work Item: " + workItemQueue.take());
                System.out.println("Items Remaining in Queue is " + workItemQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
        Thread p1 = new Thread(new Producer(queue));
        Thread c1 = new Thread(new Consumer(queue,"Consumer 1"));
        Thread c2 = new Thread(new Consumer(queue,"Consumer 2"));
        Thread c3 = new Thread(new Consumer(queue,"Consumer 3"));

        p1.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
