package com.cybage.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
