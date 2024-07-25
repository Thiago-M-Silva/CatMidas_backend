package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Filme.FilmeRepository;
import com.example.catalogo.Model.Filme.FilmeRequestDTO;
import com.example.catalogo.Model.Filme.FilmeResponseDTO;
import com.example.catalogo.Model.Filme.Filme;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filme")
public class FilmeController {

    @Autowired
    private FilmeRepository FilmeRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os filmes armazenados", method = "GET")
    public List<FilmeResponseDTO> getAll(){
        List<FilmeResponseDTO> FilmeList = FilmeRep.findAll().stream().map(FilmeResponseDTO::new).toList();
        return FilmeList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca filmes marcados como favoritos", method = "GET")
    public List<FilmeResponseDTO> getFav(){
        List<FilmeResponseDTO> FilmeList = FilmeRep.findFilmeFav().stream().map(FilmeResponseDTO::new).toList();
        return FilmeList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca filmes com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<FilmeResponseDTO> setByStatus(@RequestBody String status){
        List<FilmeResponseDTO> FilmeList = FilmeRep.findFilmeByStatus(status).stream().map(FilmeResponseDTO::new).toList();
        return FilmeList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um filme no banco de dados", method = "POST")
    public void saveFilme(@RequestBody FilmeRequestDTO data){
        Filme FilmeData = new Filme(data);
        FilmeRep.save(FilmeData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteFilme(@PathVariable("id") Long id){
        FilmeRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateFilme(@PathVariable("id") Long id, @RequestBody FilmeRequestDTO data){
        Filme filmeData = new Filme(data);
        FilmeRep.deleteById(data.id());
        FilmeRep.save(filmeData);
    }
}
