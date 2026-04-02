package az.edu.ada.wm2.lab6.model.mapper;

import az.edu.ada.wm2.lab6.model.dto.CategoryRequestDto;
import az.edu.ada.wm2.lab6.model.dto.CategoryResponseDto;
import az.edu.ada.wm2.lab6.model.Category;

public class CategoryMapper {

    // Convert incoming DTO → new Category entity (no ID yet — JPA assigns it)
    public static Category toEntity(CategoryRequestDto dto) {
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    // Convert saved entity → DTO to return to client
    public static CategoryResponseDto toResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}