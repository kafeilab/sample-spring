package edu.sample.spring.security.service.impl;

import edu.sample.spring.security.domain.Message;
import edu.sample.spring.security.service.MessageBoardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kafeilab on 9/27/15.
 */
public class MessageBoardServiceImpl implements MessageBoardService {

    private Map<Long, Message> messages = new HashMap<>();

    @Override
    public List<Message> listMessages() {
        return new ArrayList<>(Message.values());
    }

    /*
        Use synchronized to make it thread safe
     */
    @Override
    public synchronized void postMessage(Message message) {
        message.setId(System.currentTimeMillis());
        messages.put(message.getId(), message);
    }

    /*
        Use synchronized to make it thread safe
     */
    @Override
    public synchronized void deleteMessage(Message message) {
        messages.remove(message.getId());
    }

    @Override
    public Message findMessageById(Long messageId) {
        return messages.get(messageId);
    }
}
