package org.example.springboottdd.service;

import org.example.springboottdd.entity.User;
import org.example.springboottdd.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("유저 생성 테스트")
    void createUser() {
        // given
        final String name = "추창우";
        final String password = "1234";
        final User user = new User(name, password);

        when(userRepository.save(any(User.class))).thenReturn(user);

        // when
        User savedUser = userService.createUser(name, password);

        // then
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getName()).isEqualTo(name);
        assertThat(savedUser.getPassword()).isEqualTo(password);
    }
}
