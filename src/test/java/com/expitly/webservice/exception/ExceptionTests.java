package com.expitly.webservice.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExceptionTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void API_EXCEPTION_DEFAULT_응답() throws Exception {
//        ResponseEntity<String> entity = restTemplate.getForEntity("/posts/zzzz", String.class);

        String body = this.restTemplate.getForObject("/posts", String.class);
        System.out.println(body);


//        mvc.perform(get("/posts/zzz")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//        .andDo(print());
////                .andExpect(jsonPath("$[0].test").exists());


    }
}
