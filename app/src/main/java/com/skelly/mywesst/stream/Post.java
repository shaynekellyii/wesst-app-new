package com.skelly.mywesst.stream;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Date;

@ParseClassName("WESST_Posts")
public class Post extends ParseObject {
    private boolean hasImage;
    private ArrayList<Date> commentsDate;
    private ParseUser toUser;
    private int replies;
    private ParseUser user;
    private String info;
    private ArrayList<String> comments;
    private ParseFile image;
    private ArrayList<ParseUser> commentsUser;
    private String username;
    private ParseObject toObject;
    private ArrayList<String> likes;

    public Post() { }

    public Post(boolean hasImage, ArrayList<Date> commentsDate, ParseUser toUser, int replies, ParseUser user,
                String info, ArrayList<String> comments, ParseFile image, ArrayList<ParseUser> commentsUser,
                String username, ParseObject toObject, ArrayList<String> likes) {
        this.hasImage = hasImage;
        this.commentsDate = commentsDate;
        this.toUser = toUser;
        this.replies = replies;
        this.user = user;
        this.info = info;
        this.comments = comments;
        this.image = image;
        this.commentsUser = commentsUser;
        this.username = username;
        this.toObject = toObject;
        this.likes = likes;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public ParseUser getToUser() {
        return toUser;
    }

    public void setToUser(ParseUser toUser) {
        this.toUser = toUser;
    }

    public ParseObject getToObject() {
        return toObject;
    }

    public void setToObject(ParseObject toObject) {
        this.toObject = toObject;
    }

    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean hasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public ArrayList<Date> getCommentsDate() {
        return commentsDate;
    }

    public void setCommentsDate(ArrayList<Date> commentsDate) {
        this.commentsDate = commentsDate;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public ParseUser getUser() {
        return user;
    }

    public void setUser(ParseUser user) {
        this.user = user;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ParseFile getImage() {
        return image;
    }

    public void setImage(ParseFile image) {
        this.image = image;
    }

    public ArrayList<ParseUser> getCommentsUser() {
        return commentsUser;
    }

    public void setCommentsUser(ArrayList<ParseUser> commentsUser) {
        this.commentsUser = commentsUser;
    }
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(String organization) {
//        this.organization = organization;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    private String author;
//    private String organization;
//    private String content;
//    private String time;
}
