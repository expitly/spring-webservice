package com.expitly.webservice.controller;

import com.expitly.webservice.domain.posts.Posts;
import com.expitly.webservice.domain.posts.PostsRepository;
import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import com.expitly.webservice.service.PostsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsControllerRestTest {
    @Autowired
    private TestRestTemplate restTemplate;

//    @MockBean
//    private PostsService postsService;

//    @Autowired
//    ObjectMapper objectMapper;

    @Autowired
    private PostsRepository postsRepository;

    @LocalServerPort
    private int randomServerPort;

    @Before
    public void setUp(){
        Posts posts = Posts.builder()
                        .title("타이틀")
                        .content("내용")
                        .author("작가")
                        .build();

        postsRepository.save(posts);
    }

    @Test
    public void testExample() throws Exception {
        String body = this.restTemplate.getForObject("http://localhost:"+randomServerPort+"/posts", String.class);
        System.out.println(body);
    }
}
