package com.example.catalogo;

import com.example.catalogo.Desenho.Desenho;
import com.example.catalogo.Filme.Filme;
import com.example.catalogo.Livro.Livro;
import com.example.catalogo.Manga.Manga;
import com.example.catalogo.Novela.Novela;
import com.example.catalogo.Serie.Serie;
import jakarta.persistence.*;

@Entity
@Table(name = "personagens")
public class Personagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personagem_id")
    private long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Desenho desenho;
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;
    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;
    @ManyToOne
    @JoinColumn(name = "novela_id")
    private Novela novela;
    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;
    @Column(name = "atornome")
    private String atorNome;

    public Personagens(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Desenho getAnime() {
        return desenho;
    }

    public void setAnime(Desenho desenho) {
        this.desenho = desenho;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Novela getNovela() {
        return novela;
    }

    public void setNovela(Novela novela) {
        this.novela = novela;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAtorNome() {
        return atorNome;
    }

    public void setAtorNome(String atorNome) {
        this.atorNome = atorNome;
    }
}
