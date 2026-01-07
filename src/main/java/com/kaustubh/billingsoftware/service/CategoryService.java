package com.kaustubh.billingsoftware.service;

import com.kaustubh.billingsoftware.io.CategoryRequest;
import com.kaustubh.billingsoftware.io.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request, MultipartFile file );

    List<CategoryResponse> read();

    void delete(String categoryId);
}
