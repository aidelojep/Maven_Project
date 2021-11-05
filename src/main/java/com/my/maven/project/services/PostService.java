package com.my.maven.project.services;

public interface PostService {
    CreatePostResponse addPost(CreatedPostRequest createdPostRequest);
    FindPostResponse findPostById(Integer id);
    CreatePostResponse addComment(AddCommentRequest addCommentRequest);
    void deletePostById(Integer id);
    List<Post> findAll();
}
