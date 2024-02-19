package inMemoryBrokerLib.impl;

import inMemoryBrokerLib.MessageQueue;
import inMemoryBrokerLib.service.MessagePublisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessagePublisherImpl implements MessagePublisher {

    private final MessageQueue queue;

    @Override
    public boolean publishMessage(String message){
        return queue.pushMessage(message);
    }
}
