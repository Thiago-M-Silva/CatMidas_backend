package com.example.catalogo.Model.Audio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AudioRepository extends JpaRepository <Audio, Long> {

    @Query("SELECT a FROM Audio a WHERE a.statusVisto =: status")
    List<Audio> findAudioByStatus(@Param("status") String status);

    @Query("SELECT a FROM Audio a WHERE a.favorito = true")
    List<Audio> findAudioFav();

}
