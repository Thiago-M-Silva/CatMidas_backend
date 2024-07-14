package com.example.catalogo.Model.Manga;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "manga")
@Getter
@Setter
@ToString
public class Manga {
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
    @Column(name = "statusvisto")
    private String statusLido; //se o usuario esta lendo ou ñ ou se pretende ler
    private String nacionalidade; //manga funcionara para qualquer quadrinho

    public Manga(){}

    public Manga(MangaRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.qtdCaps = data.qtdCaps();
        this.nacionalidade = data.nacionalidade();
        this.status = data.status();
        this.statusLido = data.statusLido();
    }

}
