package com.Blog_Project.Controller;

import com.Blog_Project.Services.CategoryService;
import com.Blog_Project.payLoads.ApiResponse;
import com.Blog_Project.payLoads.CategoryDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory( @Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }


    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory( @Valid @RequestBody CategoryDto categoryDto, @PathVariable("catId") Integer catId ){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);

    }

    //delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Integer catId ){
        this.categoryService.deleteCategory( catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted successfully !!", true),HttpStatus.OK);
    }

    //get
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("catId") Integer catId ){
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }

    //get all
    @GetMapping("/")
    public ResponseEntity <List<CategoryDto>> getCategories( ){
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
