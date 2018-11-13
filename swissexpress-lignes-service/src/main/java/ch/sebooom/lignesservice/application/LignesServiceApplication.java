package ch.sebooom.lignesservice.application;

import ch.sebooom.lignesservice.infra.entity.Segment;
import ch.sebooom.lignesservice.infra.entity.Station;
import ch.sebooom.lignesservice.infra.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;


@EnableNeo4jRepositories("ch.sebooom.lignesservice.infra.repository")
@EntityScan("ch.sebooom.lignesservice.infra.entity")
@SpringBootApplication(scanBasePackages = "ch.sebooom.lignesservice")
public class LignesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LignesServiceApplication.class);
    }

    @Autowired
    StationRepository stationService;

    @PostConstruct
    public void initData () {
        stationService.deleteAll();

        Station bale = new Station();
        bale.setNom("Bale");
        stationService.save(bale);

        Station bienne = new Station();
        bienne.setNom("Bienne");
        stationService.save(bienne);

        Segment se = new Segment();
        se.setDepart(bale);
        se.setArrivee(bienne);
        se.setDistance(50);
        bale.setConnections(Arrays.asList(se));
        stationService.save(bale);

        Station neuchatel = new Station();
        neuchatel.setNom("Neuchâtel");
        stationService.save(neuchatel);

        se = new Segment();
        se.setDepart(bienne);
        se.setArrivee(neuchatel);
        se.setDistance(30);
        bienne.setConnections(Arrays.asList(se));
        stationService.save(bienne);

        Station lausanne = new Station();
        lausanne.setNom("Lausanne");
        stationService.save(lausanne);

        se = new Segment();
        se.setDepart(neuchatel);
        se.setArrivee(lausanne);
        se.setDistance(63);
        neuchatel.setConnections(Arrays.asList(se));
        stationService.save(neuchatel);

        Station geneve = new Station();
        geneve.setNom("Genève");
        stationService.save(geneve);

        se = new Segment();
        se.setDepart(lausanne);
        se.setArrivee(geneve);
        se.setDistance(59);
        lausanne.setConnections(Arrays.asList(se));
        stationService.save(lausanne);



    }

}
