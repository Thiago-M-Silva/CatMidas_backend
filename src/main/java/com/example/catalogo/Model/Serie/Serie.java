package com.example.catalogo.Model.Serie;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "serie")
@Getter
@Setter
@ToString
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id")
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
    @Column(name = "statusvisto")
    private String statusVisto; //se o usuario esta assistindo ou ñ ou se pretende ver

    public Serie(){}

    public Serie(SerieRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.estudio = data.estudio();
        this.disponibilidade = data.disponibilidade();
        this.status = data.status();
        this.statusVisto = data.statusVisto();
        this.maxEps = data.maxEps();
        this.temps = data.temps();
    }

}
