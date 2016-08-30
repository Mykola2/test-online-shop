package ua.nickoh.user;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.util.function.Predicate.isEqual;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserService();

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldInitializeWithTwoDemoUsers() {
        // act
        userService.initialize();
        // assert
        verify(userRepositoryMock, times(2)).save(any(User.class));
    }

    @Test
    public void shouldThrowExceptionWhenUserNotFound() {
        // arrange
        thrown.expect(UsernameNotFoundException.class);
        thrown.expectMessage("user not found");

        when(userRepositoryMock.findOneByEmail("user@example.com")).thenReturn(null);
        // act
        userService.loadUserByUsername("user@example.com");
    }

    @Test
    public void shouldReturnUserDetails() {
        // arrange
        User demoUser = new User("user", "lastname", "user@example.com", "888005553535", "demo", "ROLE_USER");
        when(userRepositoryMock.findOneByEmail("user@example.com")).thenReturn(demoUser);

        // act
        UserDetails userDetails = userService.loadUserByUsername("user@example.com");

        // assert
        assertThat(demoUser.getEmail()).isEqualTo(userDetails.getUsername());
        assertThat(demoUser.getPassword()).isEqualTo(userDetails.getPassword());
        assertThat(hasAuthority(userDetails, demoUser.getRole())).isTrue();
    }

    private boolean hasAuthority(UserDetails userDetails, String role) {
        return userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(isEqual(role));
    }
}
