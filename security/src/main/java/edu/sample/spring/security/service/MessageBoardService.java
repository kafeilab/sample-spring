package edu.sample.spring.security.service;

import edu.sample.spring.security.domain.Message;

import java.util.List;

/**
 * Created by Kafeilab on 9/27/15.
 */
public interface MessageBoardService {

    List<Message> listMessages();
    void postMessage(Message message);
    void deleteMessage(Message message);
    Message findMessageById(Long messageId);

}
