package org.example.fake;

import org.example.FakeUserRepository;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {


    @Test
    void testWithFake(){
        // 페이크 레포지토리 생성
    UserRepository fakeRepo = new FakeUserRepository();
    UserService userService = new UserService(fakeRepo);

        // 테스트 1: 유저 저장 및 조회

        userService.saveUser("Alice");
        assertThat(userService.getUserId(1)).isEqualTo("Alice");
    }


}
