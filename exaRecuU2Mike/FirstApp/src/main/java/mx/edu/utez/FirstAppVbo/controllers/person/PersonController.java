package mx.edu.utez.FirstAppVbo.controllers.person;

import jakarta.validation.Valid;
import mx.edu.utez.FirstAppVbo.config.ApiResponse;
import mx.edu.utez.FirstAppVbo.controllers.person.dto.PersonDto;
import mx.edu.utez.FirstAppVbo.services.person.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody PersonDto dto){
        return service.save(dto.toEntity());
    }
}
