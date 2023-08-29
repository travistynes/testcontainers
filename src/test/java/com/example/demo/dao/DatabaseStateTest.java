package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

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
public class DatabaseStateTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    static void beforeAll() {
    }

    @Test
    public void testUserState() {
        Optional<User> userOpt = userRepository.findByName("John");
        assertTrue(userOpt.isPresent());
        userOpt.ifPresent(user -> {
            assertEquals(1, user.getId());
        });
    }

    @Test
    public void testDeleteUser() {
        Optional<User> userOpt = userRepository.findByName("John");
        assertTrue(userOpt.isPresent());

        userOpt.ifPresent(user -> {
            userRepository.delete(user);
        });

        userOpt = userRepository.findByName("John");
        assertTrue(userOpt.isEmpty());

        userOpt = userRepository.findByName("Jane");
        assertTrue(userOpt.isPresent());
        userOpt.ifPresent(user -> {
            assertEquals(2, user.getId());
        });
    }
}
