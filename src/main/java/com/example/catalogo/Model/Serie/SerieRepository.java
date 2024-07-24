package com.example.catalogo.Model.Serie;

import com.example.catalogo.Model.Desenho.Desenho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    @Query("SELECT d FROM Serie d WHERE d.statusVisto =: status")
    List<Serie> findSerieByStatus(@Param("status") String status);


    @Query("SELECT d FROM Serie d WHERE d.favorito = true")
    List<Serie> findSerieFav();
}
