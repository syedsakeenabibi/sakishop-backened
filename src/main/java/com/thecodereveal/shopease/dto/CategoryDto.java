package com.thecodereveal.shopease.dto;


import com.thecodereveal.shopease.entities.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

private UUID id;
private String name;
private String description;
private String code;
private List<CategoryTypeDto> categoryTypes;
}
