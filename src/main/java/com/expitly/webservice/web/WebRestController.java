package com.expitly.webservice.web;

import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import com.expitly.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long  savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}
