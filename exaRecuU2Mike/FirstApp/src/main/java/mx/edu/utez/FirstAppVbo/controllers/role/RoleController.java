package mx.edu.utez.FirstAppVbo.controllers.role;

import mx.edu.utez.FirstAppVbo.config.ApiResponse;
import mx.edu.utez.FirstAppVbo.services.role.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = {"*"})
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll(){
        return service.findAll();
    }

}
