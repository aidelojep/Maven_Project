package com.my.maven.project.contoller;

@RestController
public class PostController {
    private final PostService postService = new PostServiceImpl

    @PostMapping("/api/post")
    public CreatePostResponse addPost(@RequestBody CreatePostRequest createPostRequest){
       return postService.addPost(createPostRequest);
}
    @GetMapping("/api/post/{id}")
    public FindPostResponse findPostById(@PathVariable("id") Integer id){
      return postService.findPostById(id);
}

    @PostMapping("/api/comment")
    public CreatePostResponse addComment(@RequestBody AddCommentRequest addCommentRequest){
      return postService.addComment(addCommentRequest);
}

    @DeleteMapping("/api/post/{id}")
    public void deletePostById(@PathVarible Integer id){
        postService.deletePostById(id);
    }

    @GetMapping("/api/post")
    public List<Post> findAll(){
        return postService.findAll();
    }
}
