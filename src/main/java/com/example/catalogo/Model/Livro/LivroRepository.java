package com.example.catalogo.Model.Livro;

import com.example.catalogo.Model.Desenho.Desenho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT d FROM Livro d WHERE d.statusVisto =: status")
    List<Livro> findLivroByStatus(@Param("status") String status);


    @Query("SELECT d FROM Livro d WHERE d.favorito = true")
    List<Livro> findLivroFav();
}
