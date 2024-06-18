package springbootapp.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springbootapp.dto.ApiUser;
import springbootapp.entity.User;
import springbootapp.exception.NotFoundException;
import springbootapp.service.UserService;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;


    @PostMapping("/register")
    public void registerUser(@RequestBody @Valid ApiUser apiUser) {
        userService.registerUser(apiUser.getUsername(), apiUser.getPassword(), apiUser.getEmail());
    }

    @GetMapping("/fetch")
    public ApiUser fetchUser(@RequestParam String username) {
        final User user = userService.findByUsername(username);

        if(user == null) {
            throw new NotFoundException("User with username " + username + " not found");
        }
        return new ApiUser(user);
    }

}
