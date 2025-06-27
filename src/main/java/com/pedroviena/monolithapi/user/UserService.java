package com.pedroviena.monolithapi.user;

import com.pedroviena.monolithapi.user.dto.UserCreateDTO;
import com.pedroviena.monolithapi.user.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

// IMPORTS NECESSÁRIOS:
import java.util.List; // Para usar a interface List
import java.util.stream.Collectors; // Para usar o .collect(Collectors.toList())

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        // ... (seu método createUser continua igual)
        if (userRepository.findByEmail(userCreateDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        User newUser = new User();
        newUser.setName(userCreateDTO.getName());
        newUser.setEmail(userCreateDTO.getEmail());
        newUser.setPassword(userCreateDTO.getPassword());
        User savedUser = userRepository.save(newUser);
        return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public UserResponseDTO findById(Long id) {
        // ... (seu método findById continua igual)
        User userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        return new UserResponseDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
    }

    // NOVO MÉTODO
    public List<UserResponseDTO> findAll() {
        List<User> userList = userRepository.findAll();
        // Converte cada User na lista para um UserResponseDTO
        return userList.stream()
                       .map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail()))
                       .collect(Collectors.toList());
    }

    public UserResponseDTO updateUser(Long id, UserCreateDTO userData) {
    // 1. Busca o usuário no banco de dados. Se não existir, o .orElseThrow vai lançar a exceção.
    User userToUpdate = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado para atualização!"));

    // 2. Atualiza os dados da entidade com as informações recebidas no DTO.
    userToUpdate.setName(userData.getName());
    userToUpdate.setEmail(userData.getEmail());
    // Nota: Em um sistema real, a atualização de senha teria um fluxo separado e mais seguro.
    // Por enquanto, vamos atualizar assim para fins de aprendizado.
    userToUpdate.setPassword(userData.getPassword());

    // 3. Salva a entidade ATUALIZADA no banco. O JPA é inteligente e, como a entidade
    // já tem um ID, ele vai executar um UPDATE em vez de um INSERT.
    User updatedUser = userRepository.save(userToUpdate);

    // 4. Converte a entidade atualizada para um DTO de resposta e retorna.
    return new UserResponseDTO(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail());
}

public void delete(Long id) {
    // 1. Primeiro, verificamos se o usuário que queremos deletar realmente existe.
    // Usar existsById é mais eficiente do que findById, pois não precisa trazer todos os dados do objeto.
    if (!userRepository.existsById(id)) {
        // 2. Se não existir, lançamos uma exceção para avisar que a operação não pode ser concluída.
        throw new RuntimeException("Usuário não encontrado para deleção!");
    }
    
    // 3. Se o usuário existir, chamamos o método de deleção do repositório.
    userRepository.deleteById(id);
}

}