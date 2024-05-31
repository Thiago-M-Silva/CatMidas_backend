package com.example.catalogo.Controllers;

import com.example.catalogo.Filme.Filme;
import com.example.catalogo.Filme.FilmeRequestDTO;
import com.example.catalogo.Manga.MangaRepository;
import com.example.catalogo.Manga.MangaRequestDTO;
import com.example.catalogo.Manga.MangaResponseDTO;
import com.example.catalogo.Manga.Manga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manga")
public class MangaController {

    @Autowired
    private MangaRepository MangaRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MangaResponseDTO> getAll(){
        List<MangaResponseDTO> MangaList = MangaRep.findAll().stream().map(MangaResponseDTO::new).toList();
        return MangaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveManga(@RequestBody MangaRequestDTO data){
        Manga MangaData = new Manga(data);
        MangaRep.save(MangaData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteManga(@PathVariable("id") Long id){
        MangaRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateManga(@PathVariable("id") Long id, @RequestBody MangaRequestDTO data){
        Manga manga = MangaRep.getReferenceById(id);
        manga.setNome(data.nome());
        manga.setDescricao(data.descricao());
        manga.setAutor(data.autor());
        manga.setStatus(data.status());
        manga.setQtdCaps(data.qtdCaps());
        manga.setStatusLido(data.statusLido());
        manga.setNacionalidade(data.nacionalidade());
        MangaRep.save(manga);
    }
}
