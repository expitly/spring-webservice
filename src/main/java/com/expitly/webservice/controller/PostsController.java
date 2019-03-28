package com.expitly.webservice.controller;

import com.expitly.webservice.dto.posts.PostsMainResponseDto;
import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import com.expitly.webservice.dto.posts.PostsUpdateRequestDto;
import com.expitly.webservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {
    Logger logger = LoggerFactory.getLogger(getClass());

    private final PostsService postsService;

    @GetMapping("/posts")
    public List<PostsMainResponseDto> posts(@PageableDefault(size=10, sort="title",direction = Sort.Direction.ASC) Pageable pageable){
        return postsService.findAllDesc(pageable);
    }

    @GetMapping("/posts/{id}")
    public PostsMainResponseDto select(@PathVariable Long id){
        return postsService.findById(id);
    }

    @PostMapping("/posts")
    public Long insert(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto dto){
        return postsService.update(id, dto);
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id){
        postsService.deleteByid(id);
    }
}
