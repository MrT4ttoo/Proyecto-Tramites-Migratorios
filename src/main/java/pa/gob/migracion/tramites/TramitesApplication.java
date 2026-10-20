package pa.gob.migracion.tramites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pa.gob.migracion.tramites")
public class TramitesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TramitesApplication.class, args);
    }
}
