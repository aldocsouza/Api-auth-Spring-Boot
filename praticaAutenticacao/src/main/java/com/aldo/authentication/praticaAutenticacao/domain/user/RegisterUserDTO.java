package com.aldo.authentication.praticaAutenticacao.domain.user;

public record RegisterUserDTO(String login, String password, UserRole role) {
}
