package com.example.catalogo.Controllers;

import com.example.catalogo.Infra.Security.TokenService;
import com.example.catalogo.Model.Usuario.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
@Tag(name = "usuario-endpoint")
public class UsuarioController {
    @Autowired
    private UsuarioRepository UserRep;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "busca todos os usuarios armazenados", method = "GET")
    public List<UsuarioResponseDTO> getAll() {
        List<UsuarioResponseDTO> UserList = UserRep.findAll().stream().map(UsuarioResponseDTO::new).toList();
        return UserList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "persiste um novo item no banco de dados", method = "POST")
    public void saveUser(@RequestBody UsuarioRequestDTO data){
        Usuario UserData = new Usuario(data);
        UserRep.save(UserData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Operation(summary = "deleta o item selecionado", method = "DELETE")
    public void deleteUser(@PathVariable("id") Long id){
        UserRep.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Operation(summary = "atualiza o item selecionado", method = "PUT")
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO data){
        Usuario usuario = new Usuario(data);

        UserRep.deleteById(id);
        UserRep.save(usuario);
    }

    @PostMapping("/login")
    @Operation(summary = "endpointe de login de usuario", method = "POST")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    @Operation(summary = "endpoint de registro de usuario", method = "POST")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(UserRep.findByLogin(data.login()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario usuario = new Usuario(data.nome(), data.login(), encryptedPassword, data.role());

        UserRep.save(usuario);

        return ResponseEntity.ok().build();
    }
}
