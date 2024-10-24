package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.PostRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.PostResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시글 생성
    public ResponseDto<PostResponseDto> createPost(PostRequestDto dto) {
        try {
            Post post = Post.builder()
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .author(dto.getAuthor())
                    .comments(new ArrayList<>())
                    .build();
            postRepository.save(post);
            return ResponseDto.setSuccess("게시글이 정상적으로 등록되었습니다.", convertToPostResponseDto(post));
        } catch (Exception e) {
            return ResponseDto.setFailed("게시글 등록 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 전체 게시글 조회
    public ResponseDto<List<PostResponseDto>> getAllPosts() {
        try {
            List<PostResponseDto> postResponseDtos = postRepository.findAll()
                    .stream()
                    .map(this::convertToPostResponseDto)
                    .collect(Collectors.toList());
            return ResponseDto.setSuccess("모든 게시글 조회 성공", postResponseDtos);
        } catch (Exception e) {
            return ResponseDto.setFailed("게시글 조회 실패");
        }
    }

    // 게시글 ID로 조회
    public ResponseDto<PostResponseDto> getPostById(Long postId) {
        try {
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다." + postId));
            return ResponseDto.setSuccess("게시글 조회 성공", convertToPostResponseDto(post));
        } catch (Exception e) {
            return ResponseDto.setFailed("게시글 조회 실패");
        }
    }

    // 게시글 작성자로 조회
    public ResponseDto<List<PostResponseDto>> getPostByAuthor(String author) {
        try {
            List<Post> posts = postRepository.findByAuthor(author);

            if (posts.isEmpty()) {
                throw new IllegalArgumentException("작성자를 찾을 수 없습니다.");
            }

            List<PostResponseDto> postResponseDtos = posts.stream()
                    .map(this::convertToPostResponseDto)
                    .collect(Collectors.toList());

            return ResponseDto.setSuccess("작성자 게시글 조회 성공", postResponseDtos);
        } catch (Exception e) {
            return ResponseDto.setFailed("게시글 조회 실패");
        }
    }

    // 게시글 수정
    public ResponseDto<PostResponseDto> updatePost(Long postId, PostRequestDto dto) {
        try {
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다." + postId));

            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());

            Post updatePost = postRepository.save(post);
            return ResponseDto.setSuccess("게시글 수정 성공", convertToPostResponseDto(updatePost));

        } catch (Exception e) {
            return ResponseDto.setFailed("게시글 수정 실패");
        }
    }

    // 게시글 삭제
    public ResponseDto<Void> deletePost(Long postId) {
        try {
            postRepository.deleteById(postId);
            return ResponseDto.setSuccess("게시글 삭제 성공", null);
        } catch (Exception e) {
            return ResponseDto.setFailed("게시글 삭제 실패");
        }
    }

    // Entity -> Response Dto 변환
    private PostResponseDto convertToPostResponseDto(Post post) {
        List<CommentResponseDto> commentDtos = post.getComments().stream()
                .map(comment -> new CommentResponseDto(comment.getId(), post.getId(), comment.getContent(), comment.getCommenter()))
                .collect(Collectors.toList());

        return new PostResponseDto(
                post.getId(), post.getTitle(), post.getContent(), post.getAuthor(), commentDtos
        );
    }
}
