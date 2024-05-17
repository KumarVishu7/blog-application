package com.Blog_Project.Services.impl;

import com.Blog_Project.Entities.Comment;
import com.Blog_Project.Entities.Post;
import com.Blog_Project.Exception.ResourceNotFoundException;
import com.Blog_Project.Repositories.CommentRepo;
import com.Blog_Project.Repositories.PostRepo;
import com.Blog_Project.Services.CommentService;
import com.Blog_Project.payLoads.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","CommentId",commentId));
        this.commentRepo.delete(com);

    }
}
