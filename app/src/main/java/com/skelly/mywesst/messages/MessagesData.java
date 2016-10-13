package com.skelly.mywesst.messages;

import com.skelly.mywesst.conversation.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by skelly on 9/17/16.
 */

public class MessagesData {

    private static final int NUM_MSG_THREADS = 6;
    private static final int NUM_MESSAGES = 20;

    public static List<MessageThread> getMessageThreadList() {

        List<MessageThread> msgThreadList = new LinkedList<>();

        for (int i = 0; i < NUM_MSG_THREADS; i++) {
            MessageThread messageThread = new MessageThread();
            messageThread.setName(String.format(Locale.ENGLISH, "User %d", i));
            messageThread.setLastMsg(String.format(Locale.ENGLISH, "Recent message %d", i));
            messageThread.setTime(String.format(Locale.ENGLISH, "%d minutes ago", i));
            msgThreadList.add(messageThread);
        }

        return msgThreadList;
    }

    public static List<Message> getConversation() {

        List<Message> messages = new LinkedList<>();

        for (int i = NUM_MESSAGES; i > 0; i--) {
            Message message = new Message();
            message.setTime(String.format(Locale.ENGLISH, "%d minutes ago", i));
            message.setContent(String.format(Locale.ENGLISH, "Wow this is such a great message." +
                    "It's so cool isn't it. My favourite number is %d", i));
            if (i % 2 == 0) {
                message.setSender("You");
            }
            else {
                message.setSender("Blaise Crisologo");
            }

            messages.add(message);
        }

        return messages;
    }
}
