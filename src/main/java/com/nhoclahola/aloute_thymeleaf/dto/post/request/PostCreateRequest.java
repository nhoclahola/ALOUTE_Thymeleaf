package com.nhoclahola.aloute_thymeleaf.dto.post.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostCreateRequest
{
    @NotBlank(message = "Caption can not be blank")
    private String caption;
    private String imageUrl;
    private String videoUrl;
}
