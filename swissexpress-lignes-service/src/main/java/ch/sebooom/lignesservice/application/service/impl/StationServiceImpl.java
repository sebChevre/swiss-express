package ch.sebooom.lignesservice.application.service.impl;

import ch.sebooom.lignesservice.application.service.StationService;
import ch.sebooom.lignesservice.infra.entity.Segment;
import ch.sebooom.lignesservice.infra.entity.Station;
import ch.sebooom.lignesservice.infra.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    public Collection findAll () {
        return (Collection) stationRepository.findAll();
    }

    public void insertLigne1Data () {
        stationRepository.deleteAll();

        Station bale = new Station();
        bale.setNom("Bale");
        bale.setIdentifiant("BAL");
        stationRepository.save(bale);

        Station bienne = new Station();
        bienne.setNom("Bienne");
        bienne.setIdentifiant("BIE");
        stationRepository.save(bienne);

        Segment se = new Segment();
        se.setDepart(bale);
        se.setArrivee(bienne);
        se.setDistance(50);
        se.setLigne("Ligne 1");

        se.setDeparts(new String[]{"05:30"});

        bale.setConnections(Arrays.asList(se));



        stationRepository.save(bale);

        se = new Segment();
        se.setDepart(bienne);
        se.setArrivee(bale);
        se.setDistance(50);
        se.setLigne("Ligne 1");
        se.setDeparts(new String[]{"05:30","07:00","08:30"});


        bienne.setConnections(Arrays.asList(se));
        stationRepository.save(bienne);

        Station neuchatel = new Station();
        neuchatel.setNom("Neuchâtel");
        neuchatel.setIdentifiant("NEU");
        stationRepository.save(neuchatel);

        se = new Segment();
        se.setDepart(bienne);
        se.setArrivee(neuchatel);
        se.setDistance(30);
        se.setLigne("Ligne 1");
        se.setDeparts(new String[]{"05:30"});

        bienne.setConnections(Arrays.asList(se));
        stationRepository.save(bienne);

        se = new Segment();
        se.setDepart(neuchatel);
        se.setArrivee(bienne);
        se.setDistance(30);
        se.setLigne("Ligne 1");
        se.setDeparts(new String[]{"05:30"});

        neuchatel.setConnections(Arrays.asList(se));
        stationRepository.save(neuchatel);

        Station lausanne = new Station();
        lausanne.setNom("Lausanne");
        lausanne.setIdentifiant("LAU");
        stationRepository.save(lausanne);

        se = new Segment();
        se.setDepart(neuchatel);
        se.setArrivee(lausanne);
        se.setDistance(63);
        se.setLigne("Ligne 1");
        se.setDeparts(new String[]{"05:30"});

        neuchatel.setConnections(Arrays.asList(se));
        stationRepository.save(neuchatel);

        se = new Segment();
        se.setDepart(lausanne);
        se.setArrivee(neuchatel);
        se.setDistance(63);
        se.setLigne("Ligne 1");
        se.setDeparts(new String[]{"05:30"});

        lausanne.setConnections(Arrays.asList(se));
        stationRepository.save(lausanne);

        Station geneve = new Station();
        geneve.setNom("Genève");
        geneve.setIdentifiant("GEN");
        stationRepository.save(geneve);

        se = new Segment();
        se.setDepart(lausanne);
        se.setArrivee(geneve);
        se.setDistance(59);
        se.setLigne("Ligne 1");
        se.setDeparts(new String[]{"05:30"});

        lausanne.setConnections(Arrays.asList(se));
        stationRepository.save(lausanne);

        se = new Segment();
        se.setDepart(geneve);
        se.setArrivee(lausanne);
        se.setDistance(59);
        se.setLigne("Ligne 1");
        se.setDeparts(new String[]{"05:30"});

        geneve.setConnections(Arrays.asList(se));
        stationRepository.save(geneve);
    }

    public void insertLigne2Data () {


        Station bale = stationRepository.findByIdentifiant("BAL").get();

        Station zurich = new Station();
        zurich.setNom("Zurich");
        zurich.setIdentifiant("ZUR");
        stationRepository.save(zurich);

        Segment se = new Segment();
        se.setDepart(bale);
        se.setArrivee(zurich);
        se.setDistance(71);
        se.setLigne("Ligne 2");

        se.setDeparts(new String[]{"05:30"});

        bale.setConnections(Arrays.asList(se));

        stationRepository.save(bale);

        se = new Segment();
        se.setDepart(zurich);
        se.setArrivee(bale);
        se.setDistance(71);
        se.setLigne("Ligne 2");
        se.setDeparts(new String[]{"05:30","07:00","08:30"});


        zurich.setConnections(Arrays.asList(se));
        stationRepository.save(zurich);


        Station coire = new Station();
        coire.setNom("Coire");
        coire.setIdentifiant("COI");
        stationRepository.save(coire);

        se = new Segment();
        se.setDepart(zurich);
        se.setArrivee(coire);
        se.setDistance(97);
        se.setLigne("Ligne 2");
        se.setDeparts(new String[]{"05:30"});

        zurich.setConnections(Arrays.asList(se));
        stationRepository.save(zurich);

        se = new Segment();
        se.setDepart(coire);
        se.setArrivee(zurich);
        se.setDistance(97);
        se.setLigne("Ligne 2");
        se.setDeparts(new String[]{"05:30"});

        coire.setConnections(Arrays.asList(se));
        stationRepository.save(coire);


    }

    public void insertLigne3Data () {


        Station zurich = stationRepository.findByIdentifiant("ZUR").get();
        Station lucerne = stationRepository.findByIdentifiant("LUC").get();

        Segment se = new Segment();
        se.setDepart(zurich);
        se.setArrivee(lucerne);
        se.setDistance(43);
        se.setLigne("Ligne 3");

        se.setDeparts(new String[]{"05:30"});

        zurich.setConnections(Arrays.asList(se));

        stationRepository.save(zurich);

        se = new Segment();
        se.setDepart(lucerne);
        se.setArrivee(zurich);
        se.setDistance(43);
        se.setLigne("Ligne 3");
        se.setDeparts(new String[]{"05:30","07:00","08:30"});


        lucerne.setConnections(Arrays.asList(se));
        stationRepository.save(lucerne);


        Station belizone = new Station();
        belizone.setNom("Belinzone");
        belizone.setIdentifiant("BEL");
        stationRepository.save(belizone);

        se = new Segment();
        se.setDepart(lucerne);
        se.setArrivee(belizone);
        se.setDistance(115);
        se.setLigne("Ligne 3");
        se.setDeparts(new String[]{"05:30"});

        lucerne.setConnections(Arrays.asList(se));
        stationRepository.save(lucerne);

        se = new Segment();
        se.setDepart(belizone);
        se.setArrivee(lucerne);
        se.setDistance(115);
        se.setLigne("Ligne 3");
        se.setDeparts(new String[]{"05:30"});

        belizone.setConnections(Arrays.asList(se));
        stationRepository.save(belizone);

        Station lugano = new Station();
        lugano.setNom("Lugano");
        lugano.setIdentifiant("LUG");
        stationRepository.save(lugano);

        se = new Segment();
        se.setDepart(lugano);
        se.setArrivee(belizone);
        se.setDistance(23);
        se.setLigne("Ligne 3");
        se.setDeparts(new String[]{"05:30"});
        lugano.setConnections(Arrays.asList(se));
        stationRepository.save(lugano);

        se = new Segment();
        se.setDepart(belizone);
        se.setArrivee(lugano);
        se.setDistance(23);
        se.setLigne("Ligne 3");
        se.setDeparts(new String[]{"05:30"});
        belizone.setConnections(Arrays.asList(se));
        stationRepository.save(belizone);


    }


    public void insertLigne4Data () {


        Station neuchatel = stationRepository.findByIdentifiant("NEU").get();

        Station berne = new Station();
        berne.setNom("Berne");
        berne.setIdentifiant("BER");
        stationRepository.save(berne);

        Segment se = new Segment();
        se.setDepart(neuchatel);
        se.setArrivee(berne);
        se.setDistance(38);
        se.setLigne("Ligne 4");

        se.setDeparts(new String[]{"05:30"});

        neuchatel.setConnections(Arrays.asList(se));

        stationRepository.save(neuchatel);

        se = new Segment();
        se.setDepart(berne);
        se.setArrivee(neuchatel);
        se.setDistance(38);
        se.setLigne("Ligne 4");
        se.setDeparts(new String[]{"05:30","07:00","08:30"});


        berne.setConnections(Arrays.asList(se));
        stationRepository.save(berne);

        Station lucerne = new Station();
        lucerne.setNom("Lucerne");
        lucerne.setIdentifiant("LUC");
        stationRepository.save(lucerne);

        se = new Segment();
        se.setDepart(berne);
        se.setArrivee(lucerne);
        se.setDistance(67);
        se.setLigne("Ligne 4");
        se.setDeparts(new String[]{"05:30"});

        berne.setConnections(Arrays.asList(se));
        stationRepository.save(berne);

        se = new Segment();
        se.setDepart(lucerne);
        se.setArrivee(berne);
        se.setDistance(67);
        se.setLigne("Ligne 4");
        se.setDeparts(new String[]{"05:30"});

        lucerne.setConnections(Arrays.asList(se));
        stationRepository.save(lucerne);


    }

    public void insertLigne5Data () {


        Station lausanne = stationRepository.findByIdentifiant("LAU").get();

        Station sion = new Station();
        sion.setNom("Sion");
        sion.setIdentifiant("SIO");
        stationRepository.save(sion);

        Segment se = new Segment();
        se.setDepart(lausanne);
        se.setArrivee(sion);
        se.setDistance(67);
        se.setLigne("Ligne 5");
        se.setDeparts(new String[]{"05:30"});

        lausanne.setConnections(Arrays.asList(se));
        stationRepository.save(lausanne);

        se = new Segment();
        se.setDepart(sion);
        se.setArrivee(lausanne);
        se.setDistance(67);
        se.setLigne("Ligne 5");
        se.setDeparts(new String[]{"05:30","07:00","08:30"});
        sion.setConnections(Arrays.asList(se));
        stationRepository.save(sion);

        Station viege = new Station();
        viege.setNom("Viege");
        viege.setIdentifiant("VIE");
        stationRepository.save(viege);

        se = new Segment();
        se.setDepart(sion);
        se.setArrivee(viege);
        se.setDistance(40);
        se.setLigne("Ligne 5");
        se.setDeparts(new String[]{"05:30"});

        sion.setConnections(Arrays.asList(se));
        stationRepository.save(sion);

        se = new Segment();
        se.setDepart(viege);
        se.setArrivee(sion);
        se.setDistance(40);
        se.setLigne("Ligne 5");
        se.setDeparts(new String[]{"05:30"});

        viege.setConnections(Arrays.asList(se));
        stationRepository.save(viege);

        Station lugano = stationRepository.findByIdentifiant("LUG").get();

        se = new Segment();
        se.setDepart(viege);
        se.setArrivee(lugano);
        se.setDistance(88);
        se.setLigne("Ligne 5");
        se.setDeparts(new String[]{"05:30"});

        viege.setConnections(Arrays.asList(se));
        stationRepository.save(viege);

        se = new Segment();
        se.setDepart(lugano);
        se.setArrivee(viege);
        se.setDistance(88);
        se.setLigne("Ligne 5");
        se.setDeparts(new String[]{"05:30"});

        lugano.setConnections(Arrays.asList(se));
        stationRepository.save(lugano);





    }

    @Override
    public Optional<Station> findById(String stationId) {
        Optional<Station> station = stationRepository.findByIdentifiant(stationId);

       return station;
    }

    @Override
    public Collection<Segment> trajet(String depart, String arrivee) {
        Collection<Station> stations =  stationRepository.trajetStations(depart,arrivee);
        Collection<Segment> segments =  stationRepository.segmentStations(depart,arrivee);
        return segments;

    }

}
