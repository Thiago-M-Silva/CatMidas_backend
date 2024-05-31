package com.example.catalogo.Controllers;

import com.example.catalogo.Serie.Serie;
import com.example.catalogo.Serie.SerieRepository;
import com.example.catalogo.Serie.SerieRequestDTO;
import com.example.catalogo.Serie.SerieResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("serie")
public class SerieController {

    @Autowired
    private SerieRepository SerieRep;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<SerieResponseDTO> getAll(){
        List<SerieResponseDTO> SerieList = SerieRep.findAll().stream().map(SerieResponseDTO::new).toList();
        return SerieList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveSerie(@RequestBody SerieRequestDTO data){
        Serie SerieData = new Serie(data);
        SerieRep.save(SerieData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteSerie(@PathVariable("id") Long id){
        SerieRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateSerie(@PathVariable("id") Long id, @RequestBody SerieRequestDTO data){
        Serie serie = SerieRep.getReferenceById(id);
        serie.setAutor(data.autor());
        serie.setDescricao(data.descricao());
        serie.setDisponibilidade(data.disponibilidade());
        serie.setEstudio(data.estudio());
        serie.setNome(data.nome());
        serie.setTemps(data.temps());
        serie.setStatus(data.status());
        serie.setStatusVisto(data.statusVisto());
        serie.setMaxEps(data.maxEps());
        SerieRep.save(serie);
    }
}
