package mx.edu.utez.FirstAppVbo.controllers.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.FirstAppVbo.models.role.Role;
import mx.edu.utez.FirstAppVbo.models.user.User;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private Set<Role> roles;


    public User toEntity(){
        return new User(username, password, avatar, roles);
    }
}
