package com.example.catalogo.Model.Quadrinho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuadrinhoRepository extends JpaRepository<Quadrinho, Long> {
    @Query("SELECT d FROM Quadrinho d WHERE d.statusLido =: status")
    List<Quadrinho> findMangaByStatus(@Param("status") String status);


    @Query("SELECT d FROM Quadrinho d WHERE d.favorito = true")
    List<Quadrinho> findQuadrinhoFav();
}
