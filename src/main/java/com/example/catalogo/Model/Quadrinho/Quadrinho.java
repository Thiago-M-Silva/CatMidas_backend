package com.example.catalogo.Model.Quadrinho;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Base64;

@Entity
@Table(name = "manga")
@Getter
@Setter
@ToString
public class Quadrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_id")
    private Long id;
    private String nome;
    private String descricao;
    private String autor;
    private String status;
    @Column(name = "dt_lanc")
    private Date mesAno; //data lancamento
    @Column(name = "caps")
    private int qtdCaps;
    private Boolean favorito; //indica se a midia esta marcada como favorita ou nao
    @Column(name = "statusvisto")
    private String statusLido; //se o usuario esta lendo ou ñ ou se pretende ler
    private String nacionalidade;

    @Lob
    @Column(name = "imagem")
    private String imagem;

    public Quadrinho(){}

    public Quadrinho(QuadrinhoRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.qtdCaps = data.qtdCaps();
        this.nacionalidade = data.nacionalidade();
        this.status = data.status();
        this.statusLido = data.statusLido();
        this.mesAno = data.mesAno();
        this.imagem = data.imagem();
    }

}
