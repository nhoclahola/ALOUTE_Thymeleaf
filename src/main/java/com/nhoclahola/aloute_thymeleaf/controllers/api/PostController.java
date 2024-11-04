package com.nhoclahola.aloute_thymeleaf.controllers.api;

import com.nhoclahola.aloute_thymeleaf.dto.post.response.PostResponse;
import com.nhoclahola.aloute_thymeleaf.services.PostService;
import com.nhoclahola.aloute_thymeleaf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController
{
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getAllPosts()
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.findAllPost());
    }

    @PostMapping("/posts")
    public ResponseEntity<PostResponse> createPost(@RequestPart String caption,
                                                   @RequestPart("file") MultipartFile file) throws IOException
    {
        PostResponse result = postService.createNewPost(caption, file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }
}
