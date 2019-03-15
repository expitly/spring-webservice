package com.expitly.webservice.web;

import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import com.expitly.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WebRestController {
    private final PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long  savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}
