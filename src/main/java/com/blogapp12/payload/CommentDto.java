package com.blogapp12.payload;

import com.blogapp12.entity.Post;
import lombok.Data;

@Data
public class CommentDto {
    private long commentId;
    private String name;
    private String message;
}
