package com.pedroviena.monolithapi.user;

import com.pedroviena.monolithapi.user.dto.UserCreateDTO;
import com.pedroviena.monolithapi.user.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // <-- ADICIONE ESTA LINHA

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        // ... (seu método createUser continua igual)
        UserResponseDTO createdUser = userService.createUser(userCreateDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        // ... (seu método findById continua igual)
        UserResponseDTO userDTO = userService.findById(id);
        return ResponseEntity.ok(userDTO);
    }

    // NOVO MÉTODO
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> userListDTO = userService.findAll();
        return ResponseEntity.ok(userListDTO);
    }
    // Dentro da classe UserController.java

// Este método responde a requisições PUT para /api/users/{id}
@PutMapping("/{id}")
public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserCreateDTO userData) {
    // Note que usamos @PathVariable para pegar o ID da URL e @RequestBody para pegar os novos dados do corpo da requisição.
    
    UserResponseDTO updatedUserDTO = userService.updateUser(id, userData);
    
    // Retorna o DTO do usuário atualizado com o status 200 OK.
    return ResponseEntity.ok(updatedUserDTO);
}
// Dentro da classe UserController.java

// Este método responde a requisições DELETE para /api/users/{id}
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    // Chama o serviço para deletar o usuário
    userService.delete(id);
    
    // A boa prática para uma resposta de DELETE com sucesso é retornar o status
    // 204 No Content, que significa "operação realizada com sucesso, não há conteúdo para retornar".
    return ResponseEntity.noContent().build();
}

}