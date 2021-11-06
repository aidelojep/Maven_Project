package com.my.maven.project.utilities;

import com.my.maven.project.data.models.Comment;
import com.my.maven.project.data.models.Post;
import com.my.maven.project.dto.requests.AddCommentRequests;
import com.my.maven.project.dto.requests.CreatePostRequests;
import com.my.maven.project.dto.responses.CreatePostResponses;
import com.my.maven.project.dto.responses.FindPostResponse;

import java.time.LocalDateTime;

public class ModelMapper {
    public static Post map(CreatePostRequests createPostRequests){
        Post post = new Post();
        post.setBody(createPostRequests.getBody());
        post.setTitle(createPostRequests.getTitle());
        post.setTime(LocalDateTime.now());
        return post;
    }
    public static CreatePostResponses map(Post post){
        CreatePostResponses createPostResponses = new CreatePostResponses();
        createPostResponses.setId(post.getId());
        createPostResponses.setTitle(post.getTitle());
        return createPostResponses;
    }
    public static FindPostResponse mapFindPostResponse(Post post){

        FindPostResponse findPostResponse = new FindPostResponse();
        findPostResponse.setBody(post.getBody());
        findPostResponse.setTitle(post.getTitle());
        findPostResponse.setDatePublished(post.getTime());
        findPostResponse.setComments (post.getComments());
        return findPostResponse;
    }
    public static Comment map(AddCommentRequests addCommentRequests){
        Comment comment = new Comment();
        comment.setComment(addCommentRequests.getComment ());
        comment.setPostId (addCommentRequests.getId());
        comment.setId(addCommentRequests.getId());
        comment.setTime(LocalDateTime.now());
        comment.setCommenter(addCommentRequests.getCommenter());
        return comment;
    }
}
