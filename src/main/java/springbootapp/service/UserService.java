package springbootapp.service;

import springbootapp.entity.User;

public interface UserService {

    void registerUser(String username, String rawPassword, String email);


    User findByUsername(String username);
}
