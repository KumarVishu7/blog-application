package com.Blog_Project.Repositories;

import com.Blog_Project.Entities.Category;
import com.Blog_Project.Entities.Post;
import com.Blog_Project.Entities.User;
import com.Blog_Project.payLoads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    @Query("select p from Post p where p.title like :key ")
    List<Post> searchByTitle(@Param("key")String title);

}
