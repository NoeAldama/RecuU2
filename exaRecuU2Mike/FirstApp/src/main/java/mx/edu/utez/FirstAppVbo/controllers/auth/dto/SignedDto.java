package mx.edu.utez.FirstAppVbo.controllers.auth.dto;

import lombok.Value;
import mx.edu.utez.FirstAppVbo.models.role.Role;
import mx.edu.utez.FirstAppVbo.models.user.User;

import java.util.List;

@Value
public class SignedDto {
    String token;
    String tokenType;
    User user;
    List<Role> roles;

}
