package com.expitly.webservice.service;

import com.expitly.webservice.domain.posts.Posts;
import com.expitly.webservice.domain.posts.PostsRepository;
import com.expitly.webservice.dto.posts.PostsMainResponseDto;
import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import com.expitly.webservice.dto.posts.PostsUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(Pageable pageable){
        return postsRepository.findAll(pageable)
                .stream()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostsMainResponseDto findById(Long id){
        return postsRepository.findById(id).map(PostsMainResponseDto::new).get();
    }

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto){
        Posts posts = postsRepository.findById(id).get();
        posts = dto.toEntity(posts);

        return postsRepository.save(posts).getId();
    }

    @Transactional
    public void deleteByid(Long id){
        postsRepository.deleteById(id);
    }
}
