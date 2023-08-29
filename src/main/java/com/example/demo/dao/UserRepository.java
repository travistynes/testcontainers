package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByName(String name);
}
