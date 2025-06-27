package com.pedroviena.monolithapi.user;
import com.pedroviena.monolithapi.user.dto.UserCreateDTO;
import com.pedroviena.monolithapi.user.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping // Este método responde a requisições POST para /api/users
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        UserResponseDTO createdUser = userService.createUser(userCreateDTO);
        // Retorna o status 201 Created, que é o padrão para criação de recursos
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}