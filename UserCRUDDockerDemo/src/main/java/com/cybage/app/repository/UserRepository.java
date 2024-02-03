package com.cybage.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.app.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByName(String name);

    //ctrl + shift + t --> to create test


}
