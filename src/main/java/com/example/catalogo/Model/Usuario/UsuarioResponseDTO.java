package com.example.catalogo.Model.Usuario;

public record UsuarioResponseDTO(Long id, String Nome, UserRoles userRoles, String email, String senha) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),
                usuario.getNome(),
                usuario.getRole(),
                usuario.getEmail(),
                usuario.getSenha());
    }
}
