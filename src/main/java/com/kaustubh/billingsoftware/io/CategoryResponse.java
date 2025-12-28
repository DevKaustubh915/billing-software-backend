package com.kaustubh.billingsoftware.io;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
public class CategoryResponse {

    private String categoryId;
    private String name;
    private String description;
    private String bgcolor;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imgUrl;

}
