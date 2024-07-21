package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Jogos.Jogos;
import com.example.catalogo.Model.Jogos.JogosRepository;
import com.example.catalogo.Model.Jogos.JogosRequestDTO;
import com.example.catalogo.Model.Jogos.JogosResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "busca todos os jogos armazenados", method = "GET")
    public List<JogosResponseDTO> getAll(){
        List<JogosResponseDTO> JogosList = JogosRep.findAll().stream().map(JogosResponseDTO::new).toList();
        return JogosList;
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
