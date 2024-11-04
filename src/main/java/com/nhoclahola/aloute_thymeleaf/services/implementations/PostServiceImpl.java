package com.nhoclahola.aloute_thymeleaf.services.implementations;

import com.nhoclahola.aloute_thymeleaf.dto.post.response.PostResponse;
import com.nhoclahola.aloute_thymeleaf.entities.Post;
import com.nhoclahola.aloute_thymeleaf.entities.User;
import com.nhoclahola.aloute_thymeleaf.mapper.PostMapper;
import com.nhoclahola.aloute_thymeleaf.repositories.PostRepository;
import com.nhoclahola.aloute_thymeleaf.services.PostService;
import com.nhoclahola.aloute_thymeleaf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService
{
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserService userService;

    @Override
    @Transactional
    public PostResponse createNewPost(String caption, MultipartFile file) throws IOException
    {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.findUserByEmail(currentUserEmail);
        String uploadPostDir;
        String imageUrl = null;
        String videoUrl = null;
        // Quick check, it will be check binary type in Upload Service
//        if (file.getContentType() == null)
//            throw new AppException(ErrorCode.FILE_IS_EMPTY);
//        if (file.getContentType().startsWith("image"))
//        {
//            uploadPostDir = POST_DIR + currentUser.getUserId() + "/images/";
//            imageUrl = imageAwsS3UploadServiceImplementation.upload(uploadPostDir, file);
//        }
//        else if (file.getContentType().startsWith("video"))
//        {
//            uploadPostDir = POST_DIR + currentUser.getUserId() + "/videos/";
//            videoUrl = videoAwsS3UploadServiceImplementation.upload(uploadPostDir, file);
//        }
        Post newPost = Post.builder()
                .caption(caption)
                .imageUrl(imageUrl)
                .videoUrl(videoUrl)
                .user(currentUser)
                .createdAt(LocalDateTime.now())
                .build();
        postRepository.save(newPost);
        return postMapper.toPostResponse(newPost);
    }

    @Override
    public List<PostResponse> findAllPost()
    {
        List<Post> posts = postRepository.findAll();
        return postMapper.toListPostResponse(posts);
    }
}
