package com.my.maven.project.services;

import com.my.maven.project.data.models.Comment;
import com.my.maven.project.data.models.Post;
import com.my.maven.project.data.repository.CommentRepository;
import com.my.maven.project.data.repository.PostRepository;
import com.my.maven.project.dto.requests.AddCommentRequests;
import com.my.maven.project.dto.requests.CreatePostRequests;
import com.my.maven.project.dto.responses.CreatePostResponses;
import com.my.maven.project.dto.responses.FindPostResponse;
import com.my.maven.project.exceptions.BlogException;
import com.my.maven.project.utilities.ModelMapper;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements  PostService{
    private final CommentRepository commentRepository = new CommentRepository();
    private final PostRepository postRepository = new PostRepository ();

    @Override
    public CreatePostResponses addPost(CreatePostRequests createPostRequests) {
        Post post = ModelMapper.map(createPostRequests);
        post = postRepository.save(post);
        return ModelMapper.map(post);
    }

    @Override
    public FindPostResponse findPostById(Integer id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty ()) throw new BlogException("post does not exist");
        return ModelMapper.mapFindPostResponse(post.get());
    }

    @Override
    public CreatePostResponses addComment(AddCommentRequests addCommentRequest){
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
    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
