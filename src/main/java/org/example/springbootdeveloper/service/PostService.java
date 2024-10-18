package org.example.springbootdeveloper.service;

import org.example.springbootdeveloper.dto.request.PostRequestDto;
import org.example.springbootdeveloper.dto.response.PostResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    public ResponseDto<PostResponseDto> createPost(PostRequestDto dto) {
        return null;
    }

    public ResponseDto<PostResponseDto> getPostById(Long postId) {
        return null;
    }

    public ResponseDto<List<PostResponseDto>> getAllPosts() {
        return null;
    }

    public ResponseDto<PostResponseDto> updatePost(Long postId, PostRequestDto dto) {
        return null;
    }

    public ResponseDto<Void> deletePost(Long postId) {
        return null;
    }
}
