package inMemoryBrokerLib;


import inMemoryBrokerLib.service.MessageSubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue implements Runnable {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private final List<MessageSubscriber> allSubscribers = new ArrayList<>();

    public boolean pushMessage(String message) {
        return queue.offer(message);
    }

    public void subscribe(MessageSubscriber subscriber) {
        allSubscribers.add(subscriber);
    }

    @Override
    public void run() {
        while (true) {
            for (MessageSubscriber subscriber:allSubscribers) {
                if (!queue.isEmpty() && subscriber.pushMessage(queue.peek())) {
                    queue.poll();
                }
            }
        }
    }
}
