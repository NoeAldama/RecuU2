package mx.edu.utez.FirstAppVbo.controllers.auth;

import mx.edu.utez.FirstAppVbo.config.ApiResponse;
import mx.edu.utez.FirstAppVbo.controllers.auth.dto.SignDto;
import mx.edu.utez.FirstAppVbo.services.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"*"})
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse> signIn(@RequestBody SignDto dto) {
        return service.signIn(dto.getUsername(), dto.getPassword());
    }
}
