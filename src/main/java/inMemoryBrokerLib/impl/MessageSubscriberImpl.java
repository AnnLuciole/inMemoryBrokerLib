package inMemoryBrokerLib.impl;

import inMemoryBrokerLib.MessageQueue;
import inMemoryBrokerLib.annotation.Subscriber;
import inMemoryBrokerLib.repo.CustomRepository;
import inMemoryBrokerLib.service.MessageSubscriber;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MessageSubscriberImpl implements MessageSubscriber {


    private final MessageQueue queue;

    private final CustomRepository repository;

    @Override
    @Subscriber
    public void subscribe() {
        queue.subscribe(this);
    }

    @Override
    public boolean pushMessage(String message) {
        repository.save(message);
        return true;
    }
}
