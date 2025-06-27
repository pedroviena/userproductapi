package com.pedroviena.monolithapi.user;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotação do Lombok: cria getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: cria um construtor sem argumentos
@AllArgsConstructor // Lombok: cria um construtor com todos os argumentos

@Entity // Avisa ao JPA que esta classe é uma entidade
@Table(name = "users") // Mapeia esta classe para a tabela "users" no banco
public class User {

    @Id // Marca o campo como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco de dados vai gerar o ID automaticamente
    private Long id;

    @Column(nullable = false) // A coluna no banco não pode ser nula
    private String name;

    @Column(nullable = false, unique = true) // Não pode ser nulo e deve ser único
    private String email;

    @Column(nullable = false)
    private String password;
}