package com.nhoclahola.aloute_thymeleaf.dto.post.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhoclahola.aloute_thymeleaf.dto.user.response.UserResponse;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostResponse
{
    private String postId;
    private String caption;
    private String imageUrl;
    private String videoUrl;
    private LocalDateTime createdAt;
    private UserResponse user;
}
