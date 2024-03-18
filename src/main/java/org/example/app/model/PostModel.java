package org.example.app.model;

import org.example.app.entity.Post;
import org.example.app.entity.PostResponse;
import org.example.app.entity.AllPostsResponse;
import org.example.app.network.ApiClient;
import org.example.app.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Optional;
import java.util.List;

public class PostModel {

    // REST api/posts
    public Optional<Response<List<Post>>> fetchPosts() {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<List<Post>> call = service.getPosts();
        Optional<Response<List<Post>>> optional;

        try {
            optional = Optional.ofNullable(call.execute());
        } catch (Exception ex) {
            optional = Optional.empty();
        }

        return optional;
    }

    // REST api/posts/{id}
    public Optional<Response<Post>> fetchPostById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<Post> call = service.getPostById(id);
        Optional<Response<Post>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception ex) {
            optional = Optional.empty();
        }

        return optional;
    }
}
