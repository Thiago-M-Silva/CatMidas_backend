package com.example.catalogo.Model.Novela;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "novela")
@Getter
@Setter
@ToString
public class Novela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String autor;
    private String estudio; //estudio proprietário ou editora
    private String status;
    private String disponibilidade; //onde a midia pode ser econtrada
    @Column(name = "dt_lanc")
    private Date mesAno; //data lancamento
    private int maxEps;
    private String statusVisto; //se o usuario esta assistindo ou ñ ou se pretende ver

    public Novela(){}

    public Novela(NovelaRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.estudio = data.estudio();
        this.disponibilidade = data.disponibilidade();
        this.status = data.status();
        this.maxEps = data.maxEps();
        this.statusVisto = data.statusVisto();
    }

}
