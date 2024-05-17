package com.Blog_Project.Services;

import com.Blog_Project.Entities.Post;
import com.Blog_Project.payLoads.PostDto;
import com.Blog_Project.payLoads.PostResponse;

import java.util.List;

public interface PostService {
    // create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto,Integer postId);

    // delete
    void deletePost(Integer postId);

    //get all post
    PostResponse getAllPost(Integer pageNumber , Integer pageSize,String sortBy,String sortDir);

    //get single post
    PostDto getPostById(Integer postId);

    // get all posts by category
    List<PostDto> getPostByCategory(Integer categoryId);

    // get all posts by user
    List<PostDto> getPostByUser(Integer userId);

    // search post
    List<PostDto> searchPosts(String keyword);
}
