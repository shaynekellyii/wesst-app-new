package com.skelly.mywesst.conversation;

/**
 * Created by skelly on 9/17/16.
 */

public class Message {
    private String content;
    private String sender;
    private String time;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
