package com.blogapp12.payload;


import lombok.Data;

import java.util.List;
@Data
public class PostWithCommentDto {
    private PostDto post;
    private List<CommentDto> commentDto;
}
