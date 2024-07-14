package com.example.catalogo.Model.Livro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "livro")
@Getter
@Setter
@ToString
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livro_id")
    private Long id;
    private String nome;
    private String descricao;
    private String autor;
    @Column(name = "dt_lanc")
    private Date mesAno; //data lancamento
    @Column(name = "statusvisto")
    private String statusVisto; //se o usuario esta assistindo ou ñ ou se pretende ver
    private int paginas; //numero de paginas

    public Livro(){}

    public Livro(LivroRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.statusVisto = data.statusVisto();
        this.paginas = data.paginas();
    }
}
