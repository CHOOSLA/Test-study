package org.example.springboottdd.repository;

import org.example.springboottdd.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

// JPA 관련 컴포넌트만 로드하여 데이터베이스 관련 테스트를 진행합니다.
// 내장 H2 데이터베이스를 사용하여 실제 DB 연동을 테스트합니다.
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    // TestEntityManager는 테스트 환경에서 엔티티를 관리하는 데 도움을 줍니다.
    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("User 엔티티가 데이터베이스에 저장되는지 확인한다")
    void saveUserTest() {
        // given
        final String name = "테스트유저";
        final String password = "testpassword";
        final User user = new User(name, password);

        // when
        User savedUser = userRepository.save(user);
        // entityManager.flush(); // save()만으로도 충분하지만, 영속성 컨텍스트의 변경을 DB에 강제로 반영

        // then
        User foundUser = entityManager.find(User.class, savedUser.getId());
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo(name);
        assertThat(foundUser.getPassword()).isEqualTo(password);
    }
}
