package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Manga.MangaRepository;
import com.example.catalogo.Model.Manga.MangaRequestDTO;
import com.example.catalogo.Model.Manga.MangaResponseDTO;
import com.example.catalogo.Model.Manga.Manga;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manga")
@Tag(name = "manga-endpoint")
public class MangaController {

    @Autowired
    private MangaRepository MangaRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os mangas armazenados", method = "GET")
    public List<MangaResponseDTO> getAll(){
        List<MangaResponseDTO> MangaList = MangaRep.findAll().stream().map(MangaResponseDTO::new).toList();
        return MangaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um novo item no banco de dados", method = "POST")
    public void saveManga(@RequestBody MangaRequestDTO data){
        Manga MangaData = new Manga(data);
        MangaRep.save(MangaData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteManga(@PathVariable("id") Long id){
        MangaRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateManga(@PathVariable("id") Long id, @RequestBody MangaRequestDTO data){
        Manga mangaData = new Manga(data);
        MangaRep.deleteById(data.id());
        MangaRep.save(mangaData);
    }
}
