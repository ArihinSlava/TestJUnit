import org.example.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {

    private static User user1;
    private static User user2;

    @BeforeAll
    public static void createUsers() {
        user1 = new User();
        user2 = new User("login", "login@login.ru");
    }


    @Test
    public void testCreateWithParameters() {
        Assertions.assertTrue(user2.getEmail() != null && user2.getLogin() != null);
    }

    @Test
    public void testCreateWithoutParameters() {
        Assertions.assertTrue(user1.getEmail()== null && user1.getLogin() == null);
    }

    @Test
    public void testNotValidUserParametersThrow() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("login", "login@loginru"));
    }

    @Test
    public void testEqualsLoginAndEmail() {
        Assertions.assertNotEquals(user2.getLogin(), user2.getEmail());
    }
}

