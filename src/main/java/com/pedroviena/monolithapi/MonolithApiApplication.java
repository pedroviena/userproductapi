package com.pedroviena.monolithapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonolithApiApplication {

	/**
	 * Este é o método main, o ponto de entrada padrão para qualquer aplicação Java.
	 * A linha SpringApplication.run() inicia a aplicação, criando o contexto da aplicação
	 * e iniciando o servidor web embutido (Tomcat).
	 * @param args Argumentos de linha de comando que podem ser passados para a aplicação.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MonolithApiApplication.class, args);
	}

}