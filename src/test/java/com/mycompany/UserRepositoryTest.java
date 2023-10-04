
// Class Allows for testing of implementation of our UserRepository and the attached MySQL server on the Local Host.
package com.mycompany;

import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Executes against real database
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew() {
    User user = new User();
    user.setEmail("MWMcCloud0@gmail.com");
    user.setPassword("TestPassword123");
    user.setFirstName("Malachi");
    user.setLastName("McCloud");

    User savedUser = repo.save(user);

    Assertions.assertThat(savedUser).isNotNull();
    Assertions.assertThat(savedUser.getId()).isGreaterThan(0);



    }
    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll(); // Defines Crud iterable interface
        Assertions.assertThat(users).hasSizeGreaterThan(0);

       for (User user : users) {
            System.out.println(user);
        }
    }
}
