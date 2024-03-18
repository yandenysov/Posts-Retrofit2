package org.example.app.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.app.entity.Post;
import org.example.app.entity.AllPostsResponse;
import org.example.app.model.PostModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostsView;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PostsController {

    PostModel model;
    PostsView view;

    public PostsController(PostModel model, PostsView view) {
        this.model = model;
        this.view = view;
    }

    public void getPosts() {
        view.getOutput(readPosts());
        AppStarter.startApp();
    }

    private String readPosts() {
        Optional<Response<List<Post>>> optional = model.fetchPosts();
        if (optional.isEmpty()) {
            System.out.println("Error fetching posts");
            return Constants.NO_DATA_MSG;
        } else {
            Response<List<Post>> response = optional.get();
            if (!response.isSuccessful()) {
                System.out.println("Error: " + response.code() + " - " + response.message());
                return Constants.NO_DATA_MSG;
            }

            Gson gson = new Gson();
            List<Post> posts = gson.fromJson(String.valueOf(response.body()),
                    new TypeToken<List<Post>>() {}.getType());

            if (posts != null) {
                StringBuilder stringBuilder = new StringBuilder();
                AtomicInteger cnt = new AtomicInteger(0);
                String str;

                for (Post post : posts) {
                    str = cnt.incrementAndGet() + ") Post: id " + post.getUserId() + ", " +
                            post.getTitle() + " " + post.getId() + ", " +
                            post.getBody() + "\n";
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            } else {
                System.out.println("Error: Empty posts list");
                return Constants.NO_DATA_MSG;
            }
        }
    }
}
