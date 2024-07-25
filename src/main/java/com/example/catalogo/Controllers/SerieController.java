package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Serie.Serie;
import com.example.catalogo.Model.Serie.SerieRepository;
import com.example.catalogo.Model.Serie.SerieRequestDTO;
import com.example.catalogo.Model.Serie.SerieResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("serie")
@Tag(name = "serie-endpoint")
public class SerieController {

    @Autowired
    private SerieRepository SerieRep;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos as series armazenados", method = "GET")
    public List<SerieResponseDTO> getAll(){
        List<SerieResponseDTO> SerieList = SerieRep.findAll().stream().map(SerieResponseDTO::new).toList();
        return SerieList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca series marcados como favoritos", method = "GET")
    public List<SerieResponseDTO> getFav(){
        List<SerieResponseDTO> SerieList = SerieRep.findSerieFav().stream().map(SerieResponseDTO::new).toList();
        return SerieList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca series com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<SerieResponseDTO> setByStatus(@RequestBody String status){
        List<SerieResponseDTO> SerieList = SerieRep.findSerieByStatus(status).stream().map(SerieResponseDTO::new).toList();
        return SerieList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um novo item no banco de dados", method = "POST")
    public void saveSerie(@RequestBody SerieRequestDTO data){
        Serie SerieData = new Serie(data);
        SerieRep.save(SerieData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteSerie(@PathVariable("id") Long id){
        SerieRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateSerie(@PathVariable("id") Long id, @RequestBody SerieRequestDTO data){
        Serie serieData = new Serie(data);
        SerieRep.deleteById(data.id());
        SerieRep.save(serieData);
    }
}
