package com.expitly.webservice.dto.posts;

import com.expitly.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String content;
    private String author;

    @Builder
    public PostsUpdateRequestDto(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(Posts posts){
        //content만 업데이트시켜야지
        posts.setContent(this.getContent());

        return posts;
    }
}
