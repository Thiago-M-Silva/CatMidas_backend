package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Desenho.DesenhoRepository;
import com.example.catalogo.Model.Desenho.DesenhoRequestDTO;
import com.example.catalogo.Model.Desenho.DesenhoResponseDTO;

import com.example.catalogo.services.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.catalogo.Model.Desenho.Desenho;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("desenho") //refatorar a classe anime para desenho
@Tag(name = "desenho-endpoint")
public class DesenhoController {

    @Autowired
    private DesenhoRepository DesenhoRep;

    @Autowired
    private DocumentService documentService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os desenhos armazenados", method = "GET")
    @ApiResponse
    public List<DesenhoResponseDTO> setAll(){
        List<DesenhoResponseDTO> AnimeList = DesenhoRep.findAll().stream().map(DesenhoResponseDTO::new).toList();
        return AnimeList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca desenho marcados como favoritos", method = "GET")
    public List<DesenhoResponseDTO> getFav(){
        List<DesenhoResponseDTO> DesenhoList = DesenhoRep.findDesenhoFav().stream().map(DesenhoResponseDTO::new).toList();
        return DesenhoList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca desenhos com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<DesenhoResponseDTO> setByStatus(@RequestBody String status){
        List<DesenhoResponseDTO> AnimeList = DesenhoRep.findDesenhoByStatus(status).stream().map(DesenhoResponseDTO::new).toList();
        return AnimeList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/pdf", produces = "application/pdf")
    @Operation(summary = "Generate a list of media marked as favorite", method = "GET")
    public void getDoc(HttpServletResponse response) {
        List<DesenhoResponseDTO> desenhoList = DesenhoRep.findDesenhoFav().stream().map(DesenhoResponseDTO::new).toList();
        byte[] pdfContent = documentService.gerarPdfDesenho(desenhoList);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=favorites.pdf");
        try {
            response.getOutputStream().write(pdfContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "persiste um novo item no banco de dados", method = "POST")
    public void saveAnime(@RequestBody DesenhoRequestDTO data){
        Desenho desenhoData = new Desenho(data);
        DesenhoRep.save(desenhoData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteAnime(@PathVariable("id") Long id){
        DesenhoRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateAnime(@PathVariable("id") Long id, @RequestBody DesenhoRequestDTO data){
        Desenho desenhoData = new Desenho(data);

        DesenhoRep.deleteById(id);
        DesenhoRep.save(desenhoData);
    }
}


