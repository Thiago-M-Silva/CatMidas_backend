package com.example.catalogo.Controllers;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class AnimeControllerTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void setAll() {
    }

    @Test
    void saveAnime() {
    }

    @Test
    void deleteAnime() {
    }

    @Test
    void updateAnime() {
    }
}