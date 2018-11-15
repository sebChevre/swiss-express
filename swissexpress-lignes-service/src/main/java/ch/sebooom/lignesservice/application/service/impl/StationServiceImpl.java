package ch.sebooom.lignesservice.application.service.impl;

import ch.sebooom.lignesservice.application.service.StationService;
import ch.sebooom.lignesservice.infra.entity.Segment;
import ch.sebooom.lignesservice.infra.entity.Station;
import ch.sebooom.lignesservice.infra.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
