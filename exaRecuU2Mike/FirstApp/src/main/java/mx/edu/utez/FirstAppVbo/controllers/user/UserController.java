package mx.edu.utez.FirstAppVbo.controllers.user;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.FirstAppVbo.config.ApiResponse;
import mx.edu.utez.FirstAppVbo.services.user.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll(){
        return service.findAll();
    }

    //Update

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> changeStatus(@PathVariable("id") Long id){
        return service.changeStatus(id);
    }
}
