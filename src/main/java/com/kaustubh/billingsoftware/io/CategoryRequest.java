package com.kaustubh.billingsoftware.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CategoryRequest {

    private String name;

    private String description;

    private String bgcolor;

}
