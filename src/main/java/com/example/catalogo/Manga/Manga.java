package com.example.catalogo.Manga;

import com.example.catalogo.Personagens;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "manga")
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
    @OneToMany(mappedBy = "manga")
    private List<Personagens> personagens;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusLido() {
        return statusLido;
    }

    public void setStatusLido(String statusLido) {
        this.statusLido = statusLido;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getMesAno() {
        return mesAno;
    }

    public void setMesAno(Date mesAno) {
        this.mesAno = mesAno;
    }

    public List<Personagens> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagens> personagens) {
        this.personagens = personagens;
    }
    public int getQtdCaps() {
        return qtdCaps;
    }

    public void setQtdCaps(int qtdCaps) {
        this.qtdCaps = qtdCaps;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrição='" + descricao + '\'' +
                ", autor='" + autor + '\'' +
                ", status='" + status + '\'' +
                ", mesAno=" + mesAno + '\'' +
                ", personagens=" + personagens + '\'' +
                ", qtdCaps=" + qtdCaps + '\'' +
                ", status='" + status + '\'' +
                ", statusLido='" + statusLido + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}
