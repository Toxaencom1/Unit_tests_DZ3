
import DZ3.tdd.User;

import DZ3.tdd.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TddTest {
    User user;
    User admin;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        user = new User("User", "123");
        admin = new User("Admin", "123", true);
        userRepository = new UserRepository();
        user.login("User", "123");
        admin.login("Admin", "123");
        userRepository.addUser(user);
        userRepository.addUser(admin);
    }

    @Test
    void userLogoutTest() {
        userRepository.forceUsersLogout();
        assertFalse(user.isAuthenticate());
    }

    @Test
    void listNotContainsNonAdminUsers() {
        userRepository.forceUsersLogout();
        boolean containUser = userRepository.getData().stream().anyMatch(user -> !user.isAdmin());
        assertFalse(containUser);
    }
}
