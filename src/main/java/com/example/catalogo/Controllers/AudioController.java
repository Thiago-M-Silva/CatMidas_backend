package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Audio.Audio;
import com.example.catalogo.Model.Audio.AudioRepository;
import com.example.catalogo.Model.Audio.AudioRequestDTO;
import com.example.catalogo.Model.Audio.AudioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("audio")
public class AudioController {

    @Autowired
    private AudioRepository AudioRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<AudioResponseDTO> getAll(){
        List<AudioResponseDTO> AudioList = AudioRep.findAll().stream().map(AudioResponseDTO::new).toList();
        return AudioList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveAudio(@RequestBody AudioRequestDTO data){
        Audio AudioData = new Audio(data);
        AudioRep.save(AudioData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteAudio(@PathVariable("id") Long id){
        AudioRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateAudio(@PathVariable("id") Long id, @RequestBody AudioRequestDTO data){
        Audio audio = AudioRep.getReferenceById(id);
        audio.setAutor(data.autor());
        audio.setDescricao(data.descricao());
        audio.setDisponibilidade(data.disponibilidade());
        audio.setEstudio(data.estudio());
        audio.setNome(data.nome());
        audio.setDuracao(data.duracao());
        audio.setStatusVisto(data.StatusVisto());
        audio.setTipo(data.tipo());
        AudioRep.save(audio);
    }
}
