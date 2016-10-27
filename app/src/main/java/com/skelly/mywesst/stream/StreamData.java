package com.skelly.mywesst.stream;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by skelly on 9/17/16.
 */

public class StreamData {
    private static final String TAG = "STREAM_DATA";

    public static void getPostList() {
        final List<Post> postList = new ArrayList<>();

        // TODO: Need to change queries to be dynamic for different groups
        ParseQuery<ParseObject> query = new ParseQuery<>("WESST_Posts");
        query.orderByDescending("createdAt");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                for (ParseObject object : objects) {
                    //post.setUsername(getParseUsername(post));
                    postList.add(buildPostFromParseObject(object));
                }
                if (postList.size() > 0) {
                    StreamFragment.onPostLoad(postList);
                }
            }
        });
    }

    private static String getParseUsername(Post post) {
        ParseUser user = post.getParseUser("user");
        try {
            user.fetch();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return user.getUsername();
    }

    private static Post buildPostFromParseObject(ParseObject object) {
        return new Post((Boolean)object.get("hasImage"),
                (ArrayList<Date>)object.get("commentsDate"),
                (ParseUser)object.get("toUser"),
                (int)object.get("replies"),
                object.getParseUser("user"),
                (String)object.get("info"),
                (ArrayList<String>)object.get("comments"),
                (ParseFile)object.get("image"),
                (ArrayList<ParseUser>)object.get("commentsUser"),
                getParseUsername((Post)object),
                (ParseObject)object.get("toObject"),
                (ArrayList<String>)object.get("likes")
        );
    }

//    final static private int DATASET_COUNT = 60;

//    public static List<Post> getPostList() {
//        List<Post> posts = new LinkedList<>();
//        for (int i = 0; i < DATASET_COUNT; i++) {
//            Post post = new Post();
//            post.setAuthor(String.format(Locale.ENGLISH, "Author %d", i));
//            post.setOrganization("Simon Fraser University");
//            post.setContent(String.format(Locale.ENGLISH,
//                    "This is post #%d. How cool is that! I always wanted to see post #%d.", i, i));
//            post.setTime(String.format(Locale.ENGLISH, "%d minutes ago", i));
//            posts.add(i, post);
//        }
//
//        return posts;
//    }
}
