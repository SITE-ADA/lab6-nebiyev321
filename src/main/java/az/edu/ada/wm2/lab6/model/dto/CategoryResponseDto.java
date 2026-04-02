// model/dto/CategoryResponseDto.java
package az.edu.ada.wm2.lab6.model.dto;

import lombok.*;
import java.util.UUID;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryResponseDto {
    private UUID id;
    private String name;
}