package com.my.maven.project.contoller;

import com.my.maven.project.data.models.Post;
import com.my.maven.project.dto.requests.AddCommentRequests;
import com.my.maven.project.dto.requests.CreatePostRequests;
import com.my.maven.project.dto.responses.CreatePostResponses;
import com.my.maven.project.dto.responses.FindPostResponse;
import com.my.maven.project.services.PostService;
import com.my.maven.project.services.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService = new PostServiceImpl();

    @PostMapping("/api/post")
    public CreatePostResponses addPost(@RequestBody CreatePostRequests createPostRequest){
       return postService.addPost(createPostRequest);
}
    @GetMapping("/api/post/{id}")
    public FindPostResponse findPostById(@PathVariable("id") Integer id){
      return postService.findPostById(id);
}

    @PostMapping("/api/comment")
    public CreatePostResponses addComment(@RequestBody AddCommentRequests addCommentRequest){
      return postService.addComment(addCommentRequest);
}

    @DeleteMapping("/api/post/{id}")
    public void deletePostById(@PathVariable Integer id){
        postService.deletePostById(id);
    }

    @GetMapping("/api/post")
    public List<Post> findAll(){
        return postService.findAll();
    }
}
