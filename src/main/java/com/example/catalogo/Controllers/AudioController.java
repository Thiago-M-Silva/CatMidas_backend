package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Audio.Audio;
import com.example.catalogo.Model.Audio.AudioRepository;
import com.example.catalogo.Model.Audio.AudioRequestDTO;
import com.example.catalogo.Model.Audio.AudioResponseDTO;
import com.example.catalogo.services.DocumentService;
import com.itextpdf.text.Document;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("audio")
@Tag(name = "audio-endpoint")
public class AudioController {

    @Autowired
    private AudioRepository AudioRep;

    @Autowired
    private DocumentService documentService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os audios armazenados", method = "GET")
    public List<AudioResponseDTO> getAll(){
        List<AudioResponseDTO> AudioList = AudioRep.findAll().stream().map(AudioResponseDTO::new).toList();
        return AudioList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "busca audios com um determinado status", method = "GET")
    // @ApiResponses verificar os responses
    public List<AudioResponseDTO> setByStatus(@RequestBody String status){
        List<AudioResponseDTO> AudioList = AudioRep.findAudioByStatus(status).stream().map(AudioResponseDTO::new).toList();
        return AudioList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/fav")
    @Operation(summary = "busca audios marcados como favoritos", method = "GET")
    public List<AudioResponseDTO> getFav(){
        List<AudioResponseDTO> AudioList = AudioRep.findAudioFav().stream().map(AudioResponseDTO::new).toList();
        return AudioList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/pdf", produces = "application/pdf")
    @Operation(summary = "Generate a list of media marked as favorite", method = "GET")

    public void getDoc(HttpServletResponse response) {
        List<AudioResponseDTO> audioList = AudioRep.findAudioFav().stream().map(AudioResponseDTO::new).toList();
        byte[] pdfContent = documentService.gerarPdfAudio(audioList);

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
    public void saveAudio(@RequestBody AudioRequestDTO data){
        Audio AudioData = new Audio(data);
        AudioRep.save(AudioData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteAudio(@PathVariable("id") Long id){
        AudioRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateAudio(@PathVariable("id") Long id, @RequestBody AudioRequestDTO data){
        Audio audioData = new Audio(data);
        AudioRep.deleteById(data.id());
        AudioRep.save(audioData);
    }
}
