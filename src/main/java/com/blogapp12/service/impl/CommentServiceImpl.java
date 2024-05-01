package com.blogapp12.service.impl;

import com.blogapp12.entity.Comment;
import com.blogapp12.entity.Post;
import com.blogapp12.payload.CommentDto;
import com.blogapp12.payload.PostDto;
import com.blogapp12.payload.PostWithCommentDto;
import com.blogapp12.repository.CommentRepository;
import com.blogapp12.repository.PostRepository;
import com.blogapp12.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private PostRepository postRepository;
    @Override
    public CommentDto createComment(CommentDto commentDto,long post_id) {
        Optional<Post> byId = postRepository.findById(post_id);
        Post post = byId.get();
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }
    @Override
    public PostWithCommentDto getAllCommentsByPostId(long id){
        Post post = postRepository.findById(id).get();
        PostDto dtos=new PostDto();
        dtos.setId(post.getId());
        dtos.setTitle(post.getTitle());
        dtos.setDescription(post.getDescription());
        dtos.setContent(post.getContent());

        List<Comment> comment = commentRepository.findByPostId(id);
        List<CommentDto> dto = comment.stream().map(c ->mapToDto(c)).collect(Collectors.toList());

        PostWithCommentDto postWithCommentDto=new PostWithCommentDto();
        postWithCommentDto.setCommentDto(dto);
        postWithCommentDto.setPost(dtos);
        return postWithCommentDto;
    }
    Comment mapToEntity(CommentDto dto){
        Comment comment = modelMapper.map(dto, Comment.class);
        return comment;

    }
    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto .class);
        return dto;
    }
}
