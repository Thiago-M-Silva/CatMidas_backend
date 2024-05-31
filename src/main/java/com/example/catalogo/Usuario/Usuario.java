package com.example.catalogo.Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;
    private String nome;
    private String tipo; //"A" para adm ou "C" para cliente
    private String email;
    private String senha;

    public Usuario(){}

    public Usuario(UsuarioRequestDTO data){
        this.nome = data.nome();
        this.tipo = data.tipo();
        this.email = data.email();
        this.senha = data.senha();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

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



}