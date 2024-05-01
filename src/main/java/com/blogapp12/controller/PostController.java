package com.blogapp12.controller;

import com.blogapp12.entity.Post;
import com.blogapp12.payload.ListPostDto;
import com.blogapp12.payload.PostDto;
import com.blogapp12.repository.PostRepository;
import com.blogapp12.service.PostService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
 private PostService postService;
 private PostRepository postRepository;

    public PostController(PostService postService,PostRepository postRepository) {
        this.postService = postService;
        this.postRepository=postRepository;
    }
    // http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<?>  createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
        PostDto post = postService.createPost(postDto);
       return new ResponseEntity<>(post, HttpStatus. CREATED);
    }
    //http://localhost:8080/api/posts/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        Optional<Post> byId = postRepository.findById(id);
        if(byId.isPresent()) {
            postService.deletePost(id);
            return new ResponseEntity<>("Post is deleted!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Record for this id is not present",HttpStatus.INTERNAL_SERVER_ERROR);

    }
    // http://localhost:8080/api/posts?pageNo=1&pageSize=5&sortBy=description&sortDir=desc
    @GetMapping
    public ResponseEntity<ListPostDto> fetchAllPosts(
       @RequestParam(name = "pageNo",defaultValue = "0",required = false) int pageNo,
       @RequestParam(name = "pageSize",defaultValue = "5",required = false) int pageSize,
       @RequestParam(name = "sortBy",defaultValue = "id",required = false) String sortBy,
       @RequestParam(name = "sortDir",defaultValue = "asc",required = false) String sortDir
    ){
        ListPostDto listPostDto = postService.fetchAllPosts(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(listPostDto,HttpStatus.OK);
    }
    // http://localhost:8080/api/posts/1
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        PostDto postById = postService.getPostById(id);
        return new ResponseEntity<>(postById,HttpStatus.OK);
    }
}
