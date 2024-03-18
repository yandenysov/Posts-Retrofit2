package org.example.app.entity;

import java.util.List;

public class AllPostsResponse {

    private final List<Post> data;

    public AllPostsResponse(List<Post> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }

}