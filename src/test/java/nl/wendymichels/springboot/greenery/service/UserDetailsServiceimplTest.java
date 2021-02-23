package nl.wendymichels.springboot.greenery.service;

import nl.wendymichels.springboot.greenery.Application;
import nl.wendymichels.springboot.greenery.domain.User;
import nl.wendymichels.springboot.greenery.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest()
@ContextConfiguration(classes={Application.class})
public class UserDetailsServiceimplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Mock
    User user;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testGetUserbyUserName() {
        user = new User("Piet", "","","");

        Mockito
                .when(userRepository.findByUsername(user.getUsername()))
                .thenReturn(Optional.ofNullable(user));

        String username = "Piet";
        String expected = "Piet";

        Optional<User> found = userDetailsServiceImpl.getUserByUsername(username);

        assertEquals(expected, found.get().getUsername());
    }

}
