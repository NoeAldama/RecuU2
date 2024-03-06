package mx.edu.utez.FirstAppVbo.services.user;

import mx.edu.utez.FirstAppVbo.config.ApiResponse;
import mx.edu.utez.FirstAppVbo.models.user.User;
import mx.edu.utez.FirstAppVbo.models.user.UserRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = SQLException.class)
    public ResponseEntity<ApiResponse> update(User user, Long id){
        try{
            Optional<User> foundUser = repository.findById(id);
            if (foundUser.isEmpty())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "User Not Found"), HttpStatus.BAD_REQUEST);
            user = repository.saveAndFlush(user);

        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "Algo curioso pasó aquí y sepa qué fue"), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = SQLException.class)
    public ResponseEntity<ApiResponse> changeStatus(Long id){
        Optional<User> foundUser = repository.findById(id);
        if (foundUser.isEmpty())
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "User Not Found"), HttpStatus.BAD_REQUEST);
        User user = foundUser.get();
        user.setStatus(!user.getStatus());
        return new ResponseEntity<>(new ApiResponse(repository.save(user) ,HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<User> foundUser = repository.findById(id);
        if (foundUser.isEmpty())
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "User not found"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new ApiResponse(foundUser.get(), HttpStatus.OK), HttpStatus.OK);
    }
}
