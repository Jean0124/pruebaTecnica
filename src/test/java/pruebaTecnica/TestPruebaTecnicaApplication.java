package pruebaTecnica;

import org.springframework.boot.SpringApplication;

public class TestPruebaTecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.from(PruebaTecnicaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
