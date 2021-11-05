package com.my.maven.project.services;

public class PostServiceImpl implements  PostService{
    private final CommentRepository commentRepository = new CommentRepository ();
    private final PostRepository postRepository = new PostRepository ();

    @Override
    public CreatePostResponse addPost(CreatedPostRequest createdPostRequest) {
        Post post = ModelMapper.map(createdPostRequest);
        post = postRepository.save(post);
        return ModelMapper.map(post);
    }
    @Override
    public FindPostResponse findPostResponseById(Integer id){
    Optional<Post> post = postRepository.findBy(id);
    if(post.isEmpty ()) throw new BlogException ("post does not exist");
   return ModelMapper.mapFindPostResponse(post.get());
    }

    @Override
    public CreatePostResponse addComment(AddCommentRequest addCommentRequest){
    Optional<Post> post = postRepository.findById(addCommentRequest.getId());
    if (post.isEmpty()) throw new BlogException ("Post does not exist");
    Comment comment = ModelMapper.map (addCommentRequest );
    comment = commentRepository.save(comment);
    Post updatedPost = post.get ();
    updatedPost.getComments ().add (comment);
    postRepository.save(updatedPost);
    return ModelMapper.map(updatedPost);
    }

    @Override
    public void deletePostById(Integer id){
        postRepository.delete(id);
    }
    @Override
    public List<Post> findAll{
        return postRepository.findAll ();
    }
}
