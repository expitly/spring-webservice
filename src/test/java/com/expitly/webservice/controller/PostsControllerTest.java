package com.expitly.webservice.controller;

import com.expitly.webservice.domain.posts.PostsRepository;
import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import com.expitly.webservice.service.PostsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostsService postsService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testExample() throws Exception {
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                                    .title("개나리")
                                    .author("작가")
                                    .content("내용")
                                    .build();

        given(this.postsService.save(dto)).willReturn(10L);

        this.mvc.perform(post("/posts").content(objectMapper.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
}
