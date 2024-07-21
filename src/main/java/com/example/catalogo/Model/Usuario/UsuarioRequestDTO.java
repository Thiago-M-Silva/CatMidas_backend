package com.example.catalogo.Model.Usuario;

public record UsuarioRequestDTO(String nome, UserRoles userRoles, String login, String senha) {
}
