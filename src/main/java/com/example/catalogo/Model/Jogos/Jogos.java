package com.example.catalogo.Model.Jogos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Base64;

@Table(name = "jogos")
@Entity
@Getter
@Setter
@ToString
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jogos_id")
    private Long id;
    private Long duracaoMedia;
    private String nome;
    private String descricao;
    private String autor;
    private String estudio; //estudio proprietário ou editora
    private String disponibilidade; //onde a midia pode ser econtrada
    @Column(name = "dt_lanc")
    private Date mesAno; //data lancamento
    @Column(name = "statusvisto")
    private String statusVisto; //se o usuario esta assistindo ou ñ ou se pretende ver
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    public Jogos(){}

    public Jogos(JogosRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.estudio = data.estudio();
        this.disponibilidade = data.disponibilidade();
        this.statusVisto = data.StatusVisto();
        this.mesAno = data.mesAno();
        this.imagem = Base64.getDecoder().decode(data.imagem());
    }

}
