package com.example.catalogo.Model.Desenho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesenhoRepository extends JpaRepository<Desenho, Long> {
    //Escrever testes para isso
    @Query("SELECT d FROM Desenho d WHERE d.statusVisto =: status")
    List<Desenho> findDesenhoByStatus(@Param("status") String status);

    @Query("SELECT d FROM Desenho d WHERE d.favorito = true")
    List<Desenho> findDesenhoFav();
}
