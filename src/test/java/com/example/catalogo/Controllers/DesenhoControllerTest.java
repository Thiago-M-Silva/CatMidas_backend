package com.example.catalogo.Controllers;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.catalogo.Model.Desenho.Desenho;
import com.example.catalogo.Model.Desenho.DesenhoRepository;
import com.example.catalogo.Model.Desenho.DesenhoRequestDTO;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;

@DataJpaTest
@ActiveProfiles("test")
class DesenhoControllerTest {
    /*A ideia e simular o contexto de uso da funcao em questao, no caso do setAll() e necessario criar um registro no banco de dados e 
    chamar a funcao de busca por id (que no caso, o alvo dos testes). Criamos a funcao createDesenho para criar esse registro e usaar 
    a funcao de busca.
    Caso houvesse dependencias, seria necessario utilizar mockito (@mock, beforeeach) para simular os retornos
    */

    @Autowired
    EntityManager entityManager;

    @Autowired
    DesenhoRepository desenhoRepository;

    @Test
    @DisplayName("Should return anime from bd")
    void setAll() {
        DesenhoRequestDTO data = new DesenhoRequestDTO(null, "teste", "teste", "teste","teste", 
                                                        "teste", 0, null, "teste", "a",
                                                        "teste", 0, null, null);
        this.createDesenho(data);
        Optional<Desenho> resultado = this.desenhoRepository.findById(1L);
        assertThat(resultado.isPresent()).isTrue();
    }
    @Test
    @DisplayName("Should return a list with a least one item")
    void getFav(){
        DesenhoRequestDTO data = new DesenhoRequestDTO(null, "teste", "teste", "teste","teste",
                                                        "teste", 0, null, "teste", "a",
                                                        "teste", 0, true, "null");
        this.createDesenho(data);
        List<Desenho> resultado = this.desenhoRepository.findDesenhoFav();
        assertThat(resultado.size() > 0).isTrue();
    }

    @Test
    void deleteAnime() {
        DesenhoRequestDTO data = new DesenhoRequestDTO(null, "teste", "teste", "teste","teste",
                "teste", 0, null, "teste", "a",
                "teste", 0, null, null);
        this.createDesenho(data);
        this.desenhoRepository.deleteById(1L);
        Optional<Desenho> resultado = this.desenhoRepository.findById(1L);
        assertThat(resultado.isPresent()).isFalse();
    }

    private Desenho createDesenho(DesenhoRequestDTO data){
        Desenho newDesenho = new Desenho(data);
        this.entityManager.persist(newDesenho);
        return newDesenho;
    }
}