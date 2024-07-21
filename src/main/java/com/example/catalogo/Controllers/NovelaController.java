package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Novela.Novela;
import com.example.catalogo.Model.Novela.NovelaRepository;
import com.example.catalogo.Model.Novela.NovelaRequestDTO;
import com.example.catalogo.Model.Novela.NovelaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("novela")
@Tag(name = "novela-endpoint")
public class NovelaController {

    @Autowired
    private NovelaRepository NovelaRep;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos as novelas armazenados", method = "GET")
    public List<NovelaResponseDTO> getAll(){
        List<NovelaResponseDTO> NovelaList = NovelaRep.findAll().stream().map(NovelaResponseDTO::new).toList();
        return NovelaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um novo item no banco de dados", method = "POST")
    public void saveNovela(@RequestBody NovelaRequestDTO data){
        Novela NovelaData = new Novela(data);
        NovelaRep.save(NovelaData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteNovela(@PathVariable("id") Long id){
        NovelaRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateNovela(@PathVariable("id") Long id, @RequestBody NovelaRequestDTO data){
        Novela novelaData = new Novela(data);
        NovelaRep.deleteById(data.id());
        NovelaRep.save(novelaData);
    }
}
