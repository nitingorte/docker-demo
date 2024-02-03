package com.cybage.app.service;

import com.cybage.app.entity.User;
import com.cybage.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    void setUp() {

        underTest = new UserService(userRepository);
    }

    @Test
    void itShouldAddUser() {
        //given
        String testName = "ajay";

        //when
        underTest.addUser(testName);

        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser.getName()).isEqualTo(testName);
    }

    @Test
    void canFindAllusers() {
        //when
        underTest.findAllusers();

        //then
        verify(userRepository).findAll();
    }

    @Test
    void itShouldGetUserByName() {
        String userName = "nitin";
        User existingUser = new User();
        existingUser.setName(userName);

        when(userRepository.findUserByName(userName)).thenReturn(existingUser);

        User result = underTest.getByName(userName);
        assertNotNull(result);
        assertEquals(userName, result.getName());
        
        verify(userRepository).findUserByName(userName);
    }
}