package nl.wendymichels.springboot.greenery.repository;

import nl.wendymichels.springboot.greenery.domain.User;
import nl.wendymichels.springboot.greenery.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@DataJpaTest

public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceimpl;

    @Mock
    private UserRepository userRepository;

    @Test
    public void whenFindByUsername_thenReturnUser() {
        Optional<User> mockOptional = mock(Optional.class);
        User user = new User ("Piet","","","");

        entityManager.persist(user);
        entityManager.flush();

        Mockito.when(userRepository.existsByUsername(anyString())).thenReturn(true);
        Mockito.when(userRepository.findByUsername(anyString())).thenReturn(mockOptional);

        assertThat("Piet");

    }
}
