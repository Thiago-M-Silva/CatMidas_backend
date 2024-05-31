package com.example.catalogo.Usuario;

public record UsuarioResponseDTO(Long id, String Nome, String tipo, String email, String senha) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),
                usuario.getNome(),
                usuario.getTipo(),
                usuario.getEmail(),
                usuario.getSenha());
    }
}
