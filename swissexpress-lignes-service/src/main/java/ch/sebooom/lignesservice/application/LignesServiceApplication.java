package ch.sebooom.lignesservice.application;

import ch.sebooom.lignesservice.application.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import javax.annotation.PostConstruct;


@EnableNeo4jRepositories("ch.sebooom.lignesservice.infra.graph.repository")
@EntityScan("ch.sebooom.lignesservice.infra.graph.entity")
@SpringBootApplication(scanBasePackages = "ch.sebooom.lignesservice")
public class LignesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LignesServiceApplication.class);
    }



}
