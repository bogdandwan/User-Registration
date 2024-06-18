package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import springbootapp.controller.UserController;
import springbootapp.dto.ApiUser;
import springbootapp.entity.User;
import springbootapp.service.UserService;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testRegisterUser() {

        ApiUser apiUser = new ApiUser();
        apiUser.setUsername("testuser");
        apiUser.setPassword("testpassword");
        apiUser.setEmail("test@example.com");


        userController.registerUser(apiUser);

        verify(userService, times(1)).registerUser("testuser", "testpassword", "test@example.com");
    }

    @Test
    public void testFetchUserFound() {
        User mockUser = new User("testuser", "testpassword", "test@example.com");
        when(userService.findByUsername("testuser")).thenReturn(mockUser);


        ApiUser apiUser = userController.fetchUser("testuser");


        assertNotNull(apiUser);
        assertEquals("testuser", apiUser.getUsername());
        assertEquals("testpassword", apiUser.getPassword());
        assertEquals("test@example.com", apiUser.getEmail());
    }


}