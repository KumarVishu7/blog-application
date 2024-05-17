package com.Blog_Project.Services;

import com.Blog_Project.payLoads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Integer commentId);
}
