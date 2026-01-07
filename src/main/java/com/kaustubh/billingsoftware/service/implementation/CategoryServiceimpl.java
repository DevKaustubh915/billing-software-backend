package com.kaustubh.billingsoftware.service.implementation;

import com.kaustubh.billingsoftware.entity.CategoryEntity;
import com.kaustubh.billingsoftware.io.CategoryRequest;
import com.kaustubh.billingsoftware.io.CategoryResponse;
import com.kaustubh.billingsoftware.repository.CategoryRepository;
import com.kaustubh.billingsoftware.service.CategoryService;
import com.kaustubh.billingsoftware.service.FileUploadService;
import com.kaustubh.billingsoftware.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceimpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;

    @Override
    public CategoryResponse add(CategoryRequest request , MultipartFile file){

       String imgUrl = fileUploadService.uploadFile(file);

        CategoryEntity newCategory = convertToEntity(request);

        newCategory.setImgurl(imgUrl);

        newCategory = categoryRepository.save(newCategory);
        return ConvertToResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> read() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> ConvertToResponse(categoryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
       CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
                .orElseThrow(()-> new RuntimeException("Category not found: "+ categoryId));

       fileUploadService.deleteFile(existingCategory.getImgurl());

       categoryRepository.delete(existingCategory);
    }


    private CategoryResponse ConvertToResponse(CategoryEntity newCategory) {
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgcolor(newCategory.getBgcolor())
                .imgUrl(newCategory.getImgurl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgcolor(request.getBgcolor())
                .build();
    }
}
