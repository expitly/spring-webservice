package com.expitly.webservice.service;

import com.expitly.webservice.domain.posts.Posts;
import com.expitly.webservice.domain.posts.PostsRepository;
import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @Before
    public void setUp(){
        postsRepository.deleteAll();
    }

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void Dtd데이터가_posts테이블에_저장된다(){
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("jojoldu@gmail.com")
                .content("테스트")
                .title("테스트 타이틀").build();

        postsService.save(dto);

        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}
