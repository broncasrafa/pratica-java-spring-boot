package com.rsfrancisco.course.resources;


import com.rsfrancisco.course.entities.Category;
import com.rsfrancisco.course.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
    @Autowired
    private CategoryService _categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok().body(_categoryService.findAll());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(_categoryService.findById(id));
    }
}
