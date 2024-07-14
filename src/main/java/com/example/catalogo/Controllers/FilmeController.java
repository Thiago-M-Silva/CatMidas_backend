package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Filme.FilmeRepository;
import com.example.catalogo.Model.Filme.FilmeRequestDTO;
import com.example.catalogo.Model.Filme.FilmeResponseDTO;
import com.example.catalogo.Model.Filme.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filme")
public class FilmeController {

    @Autowired
    private FilmeRepository FilmeRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FilmeResponseDTO> getAll(){
        List<FilmeResponseDTO> FilmeList = FilmeRep.findAll().stream().map(FilmeResponseDTO::new).toList();
        return FilmeList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFilme(@RequestBody FilmeRequestDTO data){
        Filme FilmeData = new Filme(data);
        FilmeRep.save(FilmeData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable("id") Long id){
        FilmeRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateFilme(@PathVariable("id") Long id, @RequestBody FilmeRequestDTO data){
        Filme filme = FilmeRep.getReferenceById(id);
        filme.setNome(data.nome());
        filme.setAutor(data.autor());
        filme.setDescricao(data.descricao());
        filme.setEstudio(data.estudio());
        filme.setDisponibilidade(data.disponibilidade());
        filme.setStatusVisto(data.statusVisto());
        filme.setDuracao(data.duracao());
        FilmeRep.save(filme);
    }
}
