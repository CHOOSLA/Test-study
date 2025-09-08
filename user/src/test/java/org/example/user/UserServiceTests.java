package org.example.user;

import jakarta.transaction.Transactional;
import org.example.user.entity.User;
import org.example.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    void saveAndFindUser(){
        // given
        User user = new User();
        user.setName("유재석");
        user.setAge(20);
        userService.save(user);

        // when
        User savedUser = userService.save(user);

        // then
        Optional<User> found = userService.findById(savedUser.getId());
        assertEquals("유재석",found.get().getName());
        assertEquals(20, found.get().getAge());


    }

    @BeforeEach
    void setUp(){
        userService.deleteAll();
    }

    @Test
    void finalAllUsers(){
        // given
        User user1 = new User();
        user1.setName("이종찬");
        user1.setAge(30);

        User user2 = new User();
        user2.setName("박찬주");
        user2.setAge(28);

        userService.save(user1);
        userService.save(user2);

        // when
        List<User> users = userService.findAll();


        // then
        assertThat(users).hasSize(2);

    }

}
