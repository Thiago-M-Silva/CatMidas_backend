package com.example.catalogo.Controllers;

import com.example.catalogo.Desenho.DesenhoRepository;
import com.example.catalogo.Desenho.DesenhoRequestDTO;
import com.example.catalogo.Desenho.DesenhoResponseDTO;
import com.example.catalogo.Desenho.Desenho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("anime")
public class AnimeController {

    @Autowired
    private DesenhoRepository DesenhoRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<DesenhoResponseDTO> setAll(){
        List<DesenhoResponseDTO> AnimeList = DesenhoRep.findAll().stream().map(DesenhoResponseDTO::new).toList();
        return AnimeList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveAnime(@RequestBody DesenhoRequestDTO data){
        Desenho desenhoData = new Desenho(data);
        DesenhoRep.save(desenhoData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteAnime(@PathVariable("id") Long id){
        DesenhoRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateAnime(@PathVariable("id") Long id, @RequestBody DesenhoRequestDTO data){
        Desenho desenhoData = new Desenho(data);

        DesenhoRep.deleteById(id);
        DesenhoRep.save(desenhoData);
    }
}


