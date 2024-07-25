package com.example.catalogo.Model.Jogos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JogosRepository extends JpaRepository<Jogos, Long> {
    @Query("SELECT d FROM Jogos d WHERE d.statusVisto =: status")
    List<Jogos> findJogosByStatus(@Param("status") String status);

    @Query("SELECT d FROM Jogos d WHERE d.favorito = true")
    List<Jogos> findJogosFav();
}
