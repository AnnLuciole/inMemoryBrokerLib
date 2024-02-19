package inMemoryBrokerLib.service;

public interface MessagePublisher {
    boolean publishMessage(String message);
}
