package com.my.maven.project.services;

import com.my.maven.project.data.models.Post;
import com.my.maven.project.dto.requests.AddCommentRequests;
import com.my.maven.project.dto.requests.CreatePostRequests;
import com.my.maven.project.dto.responses.CreatePostResponses;
import com.my.maven.project.dto.responses.FindPostResponse;

import java.util.List;


public interface PostService {
    CreatePostResponses addPost(CreatePostRequests createPostRequests);
    FindPostResponse findPostById(Integer id);
    CreatePostResponses addComment(AddCommentRequests addCommentRequest);
    void deletePostById(Integer id);
    List<Post> findAll();
}
