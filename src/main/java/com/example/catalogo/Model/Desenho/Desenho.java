package com.example.catalogo.Model.Desenho;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Base64;

@Table(name = "desenho")
@Entity
@Getter
@Setter
@ToString
public class Desenho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desenho_id")
    private Long id;
    private String nome;
    private String descricao;
    private String autor;
    private String estudio; //estudio proprietário ou editora
    private String status;
    private String disponibilidade; //onde a midia pode ser econtrada
    @Column(name = "dt_lanc")
    private Date mesAno; //data lancamento
    private int temps;
    @Column(name = "maxeps")
    private int maxEps;
    private Boolean favorito; //indica se a midia esta marcada como favorita ou nao
    @Column(name = "statusvisto")
    private String statusVisto; //se o usuario esta assistindo ou ñ ou se pretende ver
    private String nacionalidade;
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
   
    public Desenho(){}

    public Desenho(DesenhoRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.maxEps = data.maxeps();
        this.estudio = data.estudio();
        this.disponibilidade = data.disponibilidade();
        this.status = data.status();
        this.statusVisto = data.StatusVisto();
        this.mesAno = data.mesAno();
        this.imagem = Base64.getDecoder().decode(data.imagem());
    }

}
