package springbootapp.service.impl;

import org.springframework.transaction.annotation.Transactional;
import springbootapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootapp.repository.UserRepository;
import springbootapp.service.UserService;
import springbootapp.utils.PasswordUtil;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public void registerUser(String username, String rawPassword, String email) {
        String encryptedPassword = PasswordUtil.encryptPassword(rawPassword);
        User user = new User(username, encryptedPassword, email);
        user.setUsername(username);
        user.setPassword(encryptedPassword);
        user.setEmail(email);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
