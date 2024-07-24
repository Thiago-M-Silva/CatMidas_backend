package com.example.catalogo.Model.Novela;

import com.example.catalogo.Model.Desenho.Desenho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NovelaRepository extends JpaRepository<Novela, Long> {
    @Query("SELECT d FROM Novela d WHERE d.statusVisto =: status")
    List<Novela> findNovelaByStatus(@Param("status") String status);


    @Query("SELECT d FROM Novela d WHERE d.favorito = true")
    List<Novela> findNovelaFav();
}
