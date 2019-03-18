package com.expitly.webservice.service;

import com.expitly.webservice.domain.osivTest.Academy;
import com.expitly.webservice.domain.osivTest.AcademyRepository;
import com.expitly.webservice.domain.posts.PostsRepository;
import com.expitly.webservice.dto.posts.PostsMainResponseDto;
import com.expitly.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AcademyService {
    private AcademyRepository academyRepository;

    @Transactional
    public Academy get(Long id){
        Academy a =  academyRepository.findById(id).get();
        a.setName("닐리리아 니나노");

        return a;
    }
}
