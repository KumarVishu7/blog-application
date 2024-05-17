package com.Blog_Project.payLoads;

import com.Blog_Project.Entities.Category;
import com.Blog_Project.Entities.Comment;
import com.Blog_Project.Entities.User;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    private Integer postId;
    private String title;
    private  String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> comments=new HashSet<>();
}
