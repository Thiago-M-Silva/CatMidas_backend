package com.example.catalogo.Model.Usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;
    private String nome;
    private UserRoles role;
    @Column(name = "email")
    private String login;
    private String senha;

    public Usuario(){}

    public Usuario(UsuarioRequestDTO data){
        this.nome = data.nome();
        this.login = data.login();
        this.senha = data.senha();
    }

    public Usuario(String nome, String login, String senha, UserRoles role){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    public void adicionarMidia(String tipo){

    }

    public void apagarMidia(String tipo){

    }

    public void compartilhar(String tipo){

    }

    public void listaFavoritos(String tipo){
        //teste github
    }

    public void listaNaoVistos(String tipo){
        //teste github
    }

    public void listaVistos(String tipo){
        //teste github
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRoles.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}