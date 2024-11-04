package com.nhoclahola.aloute_thymeleaf.services;

import com.nhoclahola.aloute_thymeleaf.dto.post.response.PostResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService
{

    @Transactional
    PostResponse createNewPost(String caption, MultipartFile file) throws IOException;

    List<PostResponse> findAllPost();
}
