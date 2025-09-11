package org.example.springboottdd.controller;

import org.example.springboottdd.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Spring 컨테이너 로드 없이, 순수 Mockito를 사용한 단위 테스트
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    // 테스트할 대상 컨트롤러에 @Mock으로 만든 객체를 주입합니다.
    @InjectMocks
    private UserController userController;

    // UserController가 의존하는 UserService를 가짜(Mock) 객체로 만듭니다.
    @Mock
    private UserService userService;

    // HTTP 요청을 흉내 내는 MockMvc 객체
    private MockMvc mockMvc;

    // 각 테스트가 실행되기 전에 MockMvc를 수동으로 설정합니다.
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void createUserTest() throws Exception {
        // given
        String requestBody = "{\"name\": \"추창우\", \"password\" : \"1234\"}";

        // when & then
        mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        )
        .andExpect(status().isOk());
    }
}
