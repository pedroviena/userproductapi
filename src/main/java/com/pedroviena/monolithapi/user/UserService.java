package com.pedroviena.monolithapi.user;

import com.pedroviena.monolithapi.user.dto.UserCreateDTO;
import com.pedroviena.monolithapi.user.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

import com.pedroviena.monolithapi.user.User; 
import com.pedroviena.monolithapi.user.UserRepository; 

@Service // Marca a classe como um Serviço do Spring
public class UserService {

    private final UserRepository userRepository;

    // Injeção de dependência: O Spring vai nos dar uma instância do UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        // Regra de negócio: Verificar se o email já existe
        if (userRepository.findByEmail(userCreateDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado"); // (Mais tarde, criaremos exceções melhores)
        }

        // Converte o DTO para a Entidade User
        User newUser = new User();
        newUser.setName(userCreateDTO.getName());
        newUser.setEmail(userCreateDTO.getEmail());

        // IMPORTANTE: Nunca salve a senha como texto puro!
        // Por enquanto faremos isso, mas o próximo passo será usar um "Encoder".
        newUser.setPassword(userCreateDTO.getPassword());

        // Salva o novo usuário no banco de dados
        User savedUser = userRepository.save(newUser);

        // Converte a entidade salva para um DTO de resposta e retorna
        return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}