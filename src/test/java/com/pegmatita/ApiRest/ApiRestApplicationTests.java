package com.pegmatita.ApiRest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("teste")
class ApiRestApplicationTests {

	@Test
	void contextLoads() {
	}

}
