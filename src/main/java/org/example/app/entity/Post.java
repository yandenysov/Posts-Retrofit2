package org.example.app.entity;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")
    private final int userId;
    @SerializedName("id")
    private final int id;
    @SerializedName("title")
    private final String title;
    @SerializedName("body")
    private final String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{\"userId\":" + userId + "," +
                "\"id\":" + id + "," +
                "\"title\":\"" + title + "\"," +
                "\"body\":\"" + body + "\"}";
    }

}