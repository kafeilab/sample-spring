package edu.sample.spring.security.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kafeilab on 9/27/15.
 */
public class Message {

    private long id;
    private String author;
    private String title;
    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static List<Message> values() {
        List<Message> values = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setId(i);
            message.setAuthor("Author " + i);
            message.setTitle("Title " + i);
            message.setBody("Body " + i);
            values.add(message);
        }
        return values;
    }
}
