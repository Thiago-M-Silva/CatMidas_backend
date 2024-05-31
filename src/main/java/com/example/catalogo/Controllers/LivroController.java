package com.example.catalogo.Controllers;

import com.example.catalogo.Filme.Filme;
import com.example.catalogo.Filme.FilmeRequestDTO;
import com.example.catalogo.Livro.LivroRepository;
import com.example.catalogo.Livro.LivroRequestDTO;
import com.example.catalogo.Livro.LivroResponseDTO;
import com.example.catalogo.Livro.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroRepository LivroRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<LivroResponseDTO> getAll(){
        List<LivroResponseDTO> LivroList = LivroRep.findAll().stream().map(LivroResponseDTO::new).toList();
        return LivroList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveLivro(@RequestBody LivroRequestDTO data){
        Livro LivroData = new Livro(data);
        LivroRep.save(LivroData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable("id") Long id){
        LivroRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateLivro(@PathVariable("id") Long id, @RequestBody LivroRequestDTO data){
        Livro livro = LivroRep.getReferenceById(id);
        livro.setNome(data.nome());
        livro.setDescrição(data.descricao());
        livro.setAutor(data.autor());
        livro.setStatusVisto(data.statusVisto());
        livro.setPaginas(data.paginas());
        LivroRep.save(livro);
    }
}
