package ch.sebooom.lignesservice.infra;

import ch.sebooom.lignesservice.infra.graph.entity.Segment;
import ch.sebooom.lignesservice.infra.graph.entity.Station;
import ch.sebooom.lignesservice.infra.graph.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@Profile("init")
public class LignesDataInitialisation {

    @Autowired
    private StationRepository stationRepository;

    @PostConstruct
    public void generateDatas() {

        stationRepository.deleteAll();

        createStations();

        insertLigne1Data();
        insertLigne2Data();
        insertLigne3Data();
        insertLigne4Data();
        insertLigne5Data();
    }

    private final static Station[] stations = {
            Station.from("BAL","Bâle"),
            Station.from("BIE","Bienne"),
            Station.from("NEU","Neuchâtel"),
            Station.from("LAU","Lausanne"),
            Station.from("GEN","Genève"),
            Station.from("ZUR","Zürich"),
            Station.from("COI","Coire"),
            Station.from("BEL","Belinzone"),
            Station.from("LUG","Lugano"),
            Station.from("BER","Berne"),
            Station.from("LUC","Lucerne"),
            Station.from("SIO","Sion"),
            Station.from("VIE","Viege")
    };

    private void createStations(){
        Arrays.asList(stations).forEach(station -> {
            stationRepository.save(station);
        });
    }

    private Station getStation(String identifiant){
        return stationRepository.findByIdentifiant(identifiant).get();
    }

    public void insertLigne1Data () {

        Station bale = getStation("BAL");
        Station bienne = getStation("BIE");
        Station neuch = getStation("NEU");
        Station lausanne = getStation("LAU");
        Station geneve = getStation("GEN");
        String ligne1 = "Ligne 1";

        Segment se = Segment.of(bale, bienne, 50, ligne1);
        bale.setConnections(Arrays.asList(se));
        stationRepository.save(bale);

        se = Segment.of(bienne,bale,50,ligne1);
        bienne.setConnections(Arrays.asList(se));
        stationRepository.save(bienne);

        se = Segment.of(bienne,neuch,30,ligne1);
        bienne.setConnections(Arrays.asList(se));
        stationRepository.save(bienne);

        se = Segment.of(neuch,bienne,30,ligne1);
        neuch.setConnections(Arrays.asList(se));
        stationRepository.save(neuch);

        se = Segment.of(neuch,lausanne,63,ligne1);
        neuch.setConnections(Arrays.asList(se));
        stationRepository.save(neuch);

        se = Segment.of(lausanne,neuch,63,ligne1);
        lausanne.setConnections(Arrays.asList(se));
        stationRepository.save(lausanne);

        se = Segment.of(lausanne,geneve,59,ligne1);
        lausanne.setConnections(Arrays.asList(se));
        stationRepository.save(lausanne);

        se = Segment.of(geneve,lausanne,59,ligne1);
        geneve.setConnections(Arrays.asList(se));
        stationRepository.save(geneve);

    }

    public void insertLigne2Data () {

        Station bale = getStation("BAL");
        Station zurich = getStation("ZUR");
        Station coire = getStation("COI");
        String ligne2 = "Ligne 2";

        Segment se = Segment.of(bale,zurich,71,ligne2);
        bale.setConnections(Arrays.asList(se));
        stationRepository.save(bale);

        se = Segment.of(zurich,bale,71,ligne2);
        zurich.setConnections(Arrays.asList(se));
        stationRepository.save(zurich);

        se = Segment.of(zurich,coire,97,ligne2);
        zurich.setConnections(Arrays.asList(se));
        stationRepository.save(zurich);

        se = Segment.of(coire,zurich,71,ligne2);
        coire.setConnections(Arrays.asList(se));
        stationRepository.save(coire);

    }

    public void insertLigne3Data () {


        Station zurich = getStation("ZUR");
        Station lucerne = getStation("LUC");
        Station belinzone = getStation("BEL");
        Station lugano = getStation("LUG");
        String ligne3 = "Ligne 3";

        Segment se = Segment.of(zurich,lucerne,43,ligne3);
        zurich.setConnections(Arrays.asList(se));
        stationRepository.save(zurich);

        se = Segment.of(lucerne,zurich,43,ligne3);
        lucerne.setConnections(Arrays.asList(se));
        stationRepository.save(lucerne);

        se = Segment.of(lucerne,belinzone,115,ligne3);
        lucerne.setConnections(Arrays.asList(se));
        stationRepository.save(lucerne);

        se = Segment.of(belinzone,lucerne,115,ligne3);
        belinzone.setConnections(Arrays.asList(se));
        stationRepository.save(belinzone);

        se = Segment.of(belinzone,lugano,23,ligne3);
        belinzone.setConnections(Arrays.asList(se));
        stationRepository.save(belinzone);

        se = Segment.of(lugano,belinzone,23,ligne3);
        lugano.setConnections(Arrays.asList(se));
        stationRepository.save(lugano);

    }

    public void insertLigne4Data () {

        Station neuch = getStation("NEU");
        Station berne = getStation("BER");
        Station lucerne = getStation("LUC");
        String ligne4 = "Ligne 4";

        Segment se = Segment.of(neuch,berne,38,ligne4);
        neuch.setConnections(Arrays.asList(se));
        stationRepository.save(neuch);

        se = Segment.of(berne,neuch,38,ligne4);
        berne.setConnections(Arrays.asList(se));
        stationRepository.save(berne);

        se = Segment.of(berne,lucerne,67,ligne4);
        berne.setConnections(Arrays.asList(se));
        stationRepository.save(berne);

        se = Segment.of(lucerne,berne,67,ligne4);
        lucerne.setConnections(Arrays.asList(se));
        stationRepository.save(lucerne);

    }

    public void insertLigne5Data () {

        Station lausanne = getStation("LAU");
        Station sion = getStation("SIO");
        Station viege = getStation("VIE");
        Station lugano = getStation("LUG");
        String ligne5 = "Ligne 5";

        Segment se = Segment.of(lausanne,sion,67,ligne5);
        lausanne.setConnections(Arrays.asList(se));
        stationRepository.save(lausanne);

        se = Segment.of(sion,lausanne,67,ligne5);
        sion.setConnections(Arrays.asList(se));
        stationRepository.save(sion);

        se = Segment.of(sion,viege,40,ligne5);
        sion.setConnections(Arrays.asList(se));
        stationRepository.save(sion);

        se = Segment.of(viege,sion,40,ligne5);
        viege.setConnections(Arrays.asList(se));
        stationRepository.save(viege);

        se = Segment.of(viege,lugano,88,ligne5);
        viege.setConnections(Arrays.asList(se));
        stationRepository.save(viege);

        se = Segment.of(lugano,viege,88,ligne5);
        lugano.setConnections(Arrays.asList(se));
        stationRepository.save(lugano);

    }
}
