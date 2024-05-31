package com.example.catalogo.Filme;

import com.example.catalogo.Filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
