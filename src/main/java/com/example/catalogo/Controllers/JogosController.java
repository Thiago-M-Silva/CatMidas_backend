package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Jogos.Jogos;
import com.example.catalogo.Model.Jogos.JogosRepository;
import com.example.catalogo.Model.Jogos.JogosRequestDTO;
import com.example.catalogo.Model.Jogos.JogosResponseDTO;
import com.example.catalogo.services.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("jogo")
public class JogosController {

    @Autowired
    private JogosRepository JogosRep;

    @Autowired
    private DocumentService documentService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os jogos armazenados", method = "GET")
    public List<JogosResponseDTO> getAll(){
        List<JogosResponseDTO> JogosList = JogosRep.findAll().stream().map(JogosResponseDTO::new).toList();
        return JogosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca jogos marcados como favoritos", method = "GET")
    public List<JogosResponseDTO> getFav(){
        List<JogosResponseDTO> JogosList = JogosRep.findJogosFav().stream().map(JogosResponseDTO::new).toList();
        return JogosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca jogos com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<JogosResponseDTO> setByStatus(@RequestBody String status){
        List<JogosResponseDTO> JogosList = JogosRep.findJogosByStatus(status).stream().map(JogosResponseDTO::new).toList();
        return JogosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/pdf", produces = "application/pdf")
    @Operation(summary = "Generate a list of media marked as favorite", method = "GET")
    public void getDoc(HttpServletResponse response) {
        List<JogosResponseDTO> jogosList = JogosRep.findJogosFav().stream().map(JogosResponseDTO::new).toList();
        byte[] pdfContent = documentService.gerarPdfJogos(jogosList);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=favorites.pdf");
        try {
            response.getOutputStream().write(pdfContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um jogo no banco de dados", method = "POST")
    public void saveJogos(@RequestBody JogosRequestDTO data){
        Jogos JogosData = new Jogos(data);
        JogosRep.save(JogosData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteJogos(@PathVariable("id") Long id){
        JogosRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateJogos(@PathVariable("id") Long id, @RequestBody JogosRequestDTO data){
        Jogos JogosData = new Jogos(data);
        JogosRep.deleteById(id);
        JogosRep.save(JogosData);
    }
}
