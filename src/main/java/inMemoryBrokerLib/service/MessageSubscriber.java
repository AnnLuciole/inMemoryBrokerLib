package inMemoryBrokerLib.service;

public interface MessageSubscriber {
    void subscribe();
    boolean pushMessage(String message);
}
