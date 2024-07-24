package com.example.catalogo.Model.Filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    @Query("SELECT d FROM Filme d WHERE d.statusVisto =: status")
    List<Filme> findFilmeByStatus(@Param("status") String status);


    @Query("SELECT d FROM Filme d WHERE d.favorito = true")
    List<Filme> findFilmeFav();
}
