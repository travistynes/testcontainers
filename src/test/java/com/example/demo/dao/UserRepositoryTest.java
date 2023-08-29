package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.demo.dao.entity.User;

/**
 * Note from https://java.testcontainers.org/modules/databases/jdbc/
 * 
 * If you're using the JDBC URL support, there is no need to instantiate an instance of the container -
 * Testcontainers will do it automagically.
 */
@Testcontainers
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    static void beforeAll() {
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("Bob");
        User savedUser = userRepository.save(user);
        assertTrue(savedUser.getId() > 0);
    }
}
