package com.example.catalogo.Controllers;

import com.example.catalogo.Model.Usuario.Usuario;
import com.example.catalogo.Model.Usuario.UsuarioRepository;
import com.example.catalogo.Model.Usuario.UsuarioRequestDTO;
import com.example.catalogo.Model.Usuario.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository UserRep;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<UsuarioResponseDTO> getAll(){
        List<UsuarioResponseDTO> UserList = UserRep.findAll().stream().map(UsuarioResponseDTO::new).toList();
        return UserList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveUser(@RequestBody UsuarioRequestDTO data){
        Usuario UserData = new Usuario(data);
        UserRep.save(UserData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        UserRep.deleteById(id);
    }

    //funcao de att, recebe um id via header e uma nova classe no body
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO data){
        Usuario usuario = UserRep.getReferenceById(id);
        usuario.setNome(data.nome());
        usuario.setTipo(data.tipo());
        usuario.setEmail(data.email());
        usuario.setSenha(data.senha());
        UserRep.save(usuario);
    }
}
