package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Livro.LivroRepository;
import com.example.catalogo.Model.Livro.LivroRequestDTO;
import com.example.catalogo.Model.Livro.LivroResponseDTO;
import com.example.catalogo.Model.Livro.Livro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro")
@Tag(name = "livro-endpoint")
public class LivroController {

    @Autowired
    private LivroRepository LivroRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os livros armazenados", method = "GET")
    public List<LivroResponseDTO> getAll(){
        List<LivroResponseDTO> LivroList = LivroRep.findAll().stream().map(LivroResponseDTO::new).toList();
        return LivroList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca livros marcados como favoritos", method = "GET")
    public List<LivroResponseDTO> getFav(){
        List<LivroResponseDTO> LivroList = LivroRep.findLivroFav().stream().map(LivroResponseDTO::new).toList();
        return LivroList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca livros com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<LivroResponseDTO> setByStatus(@RequestBody String status){
        List<LivroResponseDTO> LivroList = LivroRep.findLivroByStatus(status).stream().map(LivroResponseDTO::new).toList();
        return LivroList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um novo item no banco de dados", method = "POST")
    public void saveLivro(@RequestBody LivroRequestDTO data){
        Livro LivroData = new Livro(data);
        LivroRep.save(LivroData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteLivro(@PathVariable("id") Long id){
        LivroRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateLivro(@PathVariable("id") Long id, @RequestBody LivroRequestDTO data){
        Livro livroData = new Livro(data);
        LivroRep.deleteById(data.id());
        LivroRep.save(livroData);
    }
}
