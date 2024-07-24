package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Quadrinho.QuadrinhoRepository;
import com.example.catalogo.Model.Quadrinho.QuadrinhoRequestDTO;
import com.example.catalogo.Model.Quadrinho.QuadrinhoResponseDTO;
import com.example.catalogo.Model.Quadrinho.Quadrinho;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manga")
@Tag(name = "manga-endpoint")
public class QuadrinhoController {

    @Autowired
    private QuadrinhoRepository QuadrinhoRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os mangas armazenados", method = "GET")
    public List<QuadrinhoResponseDTO> getAll(){
        List<QuadrinhoResponseDTO> MangaList = QuadrinhoRep.findAll().stream().map(QuadrinhoResponseDTO::new).toList();
        return MangaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca quadrinhos marcados como favoritos", method = "GET")
    public List<QuadrinhoResponseDTO> getFav(){
        List<QuadrinhoResponseDTO> QuadrinhoList = QuadrinhoRep.findQuadrinhoFav().stream().map(QuadrinhoResponseDTO::new).toList();
        return QuadrinhoList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca quadrinhos com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<QuadrinhoResponseDTO> setByStatus(@RequestBody String status){
        List<QuadrinhoResponseDTO> MangaList = QuadrinhoRep.findMangaByStatus(status).stream().map(QuadrinhoResponseDTO::new).toList();
        return MangaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um novo item no banco de dados", method = "POST")
    public void saveManga(@RequestBody QuadrinhoRequestDTO data){
        Quadrinho quadrinhoData = new Quadrinho(data);
        QuadrinhoRep.save(quadrinhoData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteManga(@PathVariable("id") Long id){
        QuadrinhoRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateManga(@PathVariable("id") Long id, @RequestBody QuadrinhoRequestDTO data){
        Quadrinho quadrinhoData = new Quadrinho(data);
        QuadrinhoRep.deleteById(data.id());
        QuadrinhoRep.save(quadrinhoData);
    }
}
