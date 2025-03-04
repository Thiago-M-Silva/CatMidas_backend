package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Novela.Novela;
import com.example.catalogo.Model.Novela.NovelaRepository;
import com.example.catalogo.Model.Novela.NovelaRequestDTO;
import com.example.catalogo.Model.Novela.NovelaResponseDTO;
import com.example.catalogo.services.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("novela")
@Tag(name = "novela-endpoint")
public class NovelaController {

    @Autowired
    private NovelaRepository NovelaRep;

    @Autowired
    private DocumentService documentService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos as novelas armazenados", method = "GET")
    public List<NovelaResponseDTO> getAll(){
        List<NovelaResponseDTO> NovelaList = NovelaRep.findAll().stream().map(NovelaResponseDTO::new).toList();
        return NovelaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca novelas marcados como favoritos", method = "GET")
    public List<NovelaResponseDTO> getFav(){
        List<NovelaResponseDTO> NovelaList = NovelaRep.findNovelaFav().stream().map(NovelaResponseDTO::new).toList();
        return NovelaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca novelas com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<NovelaResponseDTO> setByStatus(@RequestBody String status){
        List<NovelaResponseDTO> NovelaList = NovelaRep.findNovelaByStatus(status).stream().map(NovelaResponseDTO::new).toList();
        return NovelaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/pdf", produces = "application/pdf")
    @Operation(summary = "Generate a list of media marked as favorite", method = "GET")
    public void getDoc(HttpServletResponse response) {
        List<NovelaResponseDTO> novelaList = NovelaRep.findNovelaFav().stream().map(NovelaResponseDTO::new).toList();
        byte[] pdfContent = documentService.gerarPdfNovela(novelaList);

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
