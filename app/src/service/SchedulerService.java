package service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class SchedulerService {
    BlockingQueue<Task> queue   = new PriorityBlockingQueue<Task>();

    void addTask(Task task){
        queue.add(task);
    }

    //todo
    Task getTask() throws InterruptedException {
        return queue.take();
    }

}
