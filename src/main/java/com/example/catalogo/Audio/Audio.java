package com.example.catalogo.Audio;

import jakarta.persistence.*;

import java.sql.Date;

@Table(name = "audio")
@Entity
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_id")
    private Long id;
    private String nome;
    private String autor;
    private String descricao;
    private String estudio;
    private String disponibilidade;
    private String statusVisto;
    private Long duracao;
    private String tipo; //musica, podcast, etc
    @Column(name = "dt_lanc")
    private Date mesAno; //data de lancamento

    public Audio(){}

    public Audio(AudioRequestDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.estudio = data.estudio();
        this.disponibilidade = data.disponibilidade();
        this.statusVisto = data.StatusVisto();
        this.duracao = data.duracao();
        this.tipo = data.tipo();
        //this.mesAno = data.mesAno();
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getStatusVisto() {
        return statusVisto;
    }

    public void setStatusVisto(String statusVisto) {
        this.statusVisto = statusVisto;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getMesAno() {
        return mesAno;
    }

    public void setMesAno(Date mesAno) {
        this.mesAno = mesAno;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estudio='" + estudio + '\'' +
                ", disponibilidade='" + disponibilidade + '\'' +
                ", statusVisto='" + statusVisto + '\'' +
                ", duracao=" + duracao +
                ", tipo='" + tipo + '\'' +
                ", mesAno='" + mesAno + '\'' +
                '}';
    }
}
