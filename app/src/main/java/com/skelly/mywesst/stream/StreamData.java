package com.skelly.mywesst.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by skelly on 9/17/16.
 */

public class StreamData {

    final static private int DATASET_COUNT = 60;

    public static List<Post> getPostList() {
        List<Post> posts = new LinkedList<>();
        for (int i = 0; i < DATASET_COUNT; i++) {
            Post post = new Post();
            post.setAuthor(String.format(Locale.ENGLISH, "Author %d", i));
            post.setOrganization("Simon Fraser University");
            post.setContent(String.format(Locale.ENGLISH,
                    "This is post #%d. How cool is that! I always wanted to see post #%d.", i, i));
            post.setTime(String.format(Locale.ENGLISH, "%d minutes ago", i));
            posts.add(i, post);
        }

        return posts;
    }
}
