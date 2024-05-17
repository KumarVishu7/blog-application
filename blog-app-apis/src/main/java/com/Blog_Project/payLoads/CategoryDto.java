package com.Blog_Project.payLoads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {

    private Integer categoryId;
    @NotEmpty
    @Size(min=10,max=100,message = "Title is invalid the length must between 10 to 100")
    private String categoryTitle;
    @NotEmpty
    @Size(min=10)
    private String categoryDescription;
}
