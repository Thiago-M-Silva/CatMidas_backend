package com.example.catalogo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DataJPATest
@ActiveProfiles("test")
class CatalogoApplicationTests {

    @Autowired
    EntityManager entityManager;

	@Test
    @DisplayName("Deve retornar sucesso do bd")
	void desenhoTest1() {
        DesenhoRequestDTO data = new DesenhoRequestDTO() //verifique o construtor
        this.Desenho(data);

        //continuar no IntelliJ

	}

    private Desenho(DesenhoRequestDTO data){
        Desenho desenho = new Desenho(data); //verifique o construtor
        this.entityManager.perist(desenho);
        return desenho;
    }

}
