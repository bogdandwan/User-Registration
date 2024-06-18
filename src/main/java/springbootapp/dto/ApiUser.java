package springbootapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import springbootapp.entity.User;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiUser implements Serializable {

    private Long id;
    private String username;
    @Email
    private String email;
    private String password;


    public ApiUser(User user) {
        username = user.getUsername();
        email = user.getEmail();
        password = user.getPassword();
    }

}
