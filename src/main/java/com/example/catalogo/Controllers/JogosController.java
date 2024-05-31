package com.example.catalogo.Controllers;

import com.example.catalogo.Jogos.Jogos;
import com.example.catalogo.Jogos.JogosRepository;
import com.example.catalogo.Jogos.JogosRequestDTO;
import com.example.catalogo.Jogos.JogosResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jogo")
public class JogosController {

    @Autowired
    private JogosRepository JogosRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<JogosResponseDTO> getAll(){
        List<JogosResponseDTO> JogosList = JogosRep.findAll().stream().map(JogosResponseDTO::new).toList();
        return JogosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveJogos(@RequestBody JogosRequestDTO data){
        Jogos JogosData = new Jogos(data);
        JogosRep.save(JogosData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteJogos(@PathVariable("id") Long id){
        JogosRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateJogos(@PathVariable("id") Long id, @RequestBody JogosRequestDTO data){
        JogosRep.deleteById(id);
        Jogos JogosData = new Jogos(data);
        JogosRep.save(JogosData);
    }
}
