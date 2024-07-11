package com.example.catalogo.Desenho;

import jakarta.persistence.*;

import java.sql.Date;

@Table(name = "desenho")
@Entity
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
    @Column(name = "statusvisto")
    private String statusVisto; //se o usuario esta assistindo ou ñ ou se pretende ver
    private String nacionalidade;
    //private List categorias;
   
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Date getMesAno() {
        return mesAno;
    }

    public void setMesAno(Date mesAno) {
        this.mesAno = mesAno;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getMaxEps() {
        return maxEps;
    }

    public void setMaxEps(int maxEps) {
        this.maxEps = maxEps;
    }

    public String getStatusVisto() {
        return statusVisto;
    }

    public void setStatusVisto(String statusVisto) {
        this.statusVisto = statusVisto;
    }


    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

  
    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrição='" + descricao + '\'' +
                ", autor='" + autor + '\'' +
                ", estudio='" + estudio + '\'' +
                ", status='" + status + '\'' +
                ", disponibilidade='" + disponibilidade + '\'' +
                ", mesAno=" + mesAno + '\'' +
                ", temps=" + temps + '\'' +
                ", maxEps=" + maxEps + '\'' +
                ", statusVisto='" + statusVisto + '\'' +
                '}';
    }
}
