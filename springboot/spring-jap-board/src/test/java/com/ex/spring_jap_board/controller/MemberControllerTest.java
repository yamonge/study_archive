package com.ex.spring_jap_board.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j

public class MemberControllerTest {
    @Nested
    @SpringBootTest
    @AutoConfigureMockMvc
    class memberControllerTest {

        @Autowired
        MockMvc mockMvc;

        @Test
        void successSignUp() throws Exception {

            String json = """
        {
          "memberEmail":"test@test.com",
          "memberPwd":"1234",
          "memberName":"홍길동"
        }
        """;

            mockMvc.perform(post("/member/signup")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andExpect(status().isOk());
        }
    }
}
