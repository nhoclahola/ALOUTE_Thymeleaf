package com.nhoclahola.aloute_thymeleaf.mapper;

import com.nhoclahola.aloute_thymeleaf.dto.post.response.PostResponse;
import com.nhoclahola.aloute_thymeleaf.entities.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class) // To change avatarUrl with method in UserMapper
public interface PostMapper
{
    PostResponse toPostResponse(Post post);

    List<PostResponse> toListPostResponse(List<Post> posts);
}
