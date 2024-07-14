package com.example.catalogo.Model.Usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString
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