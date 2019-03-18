package com.expitly.webservice.web;

import com.expitly.webservice.domain.osivTest.Academy;
import com.expitly.webservice.domain.osivTest.AcademyRepository;
import com.expitly.webservice.domain.osivTest.Subject;
import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import com.expitly.webservice.service.AcademyService;
import com.expitly.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WebRestController {
    private final PostsService postsService;
    private final AcademyService academyService;
    private final AcademyRepository academyRepository;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long  savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @GetMapping("/test")
    public String test(){
        Academy academy = academyService.get(1L);

        return "test";
    }
}
