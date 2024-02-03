package com.cybage.app.repository;

import com.cybage.app.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindIfUserExistsName() {
        //given
        String testName = "sachin";
        User user = new User(1,testName);

        underTest.save(user);

        //when
        User getUser = underTest.findUserByName(testName);

        //then
        assertEquals(testName, getUser.getName());
    }

    @Test
    void itShouldFindIfUserListIsEmpty(){

        boolean expected =  underTest.findAll().isEmpty();

        assertThat(expected).isTrue();
    }

}