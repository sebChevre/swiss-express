package ch.sebooom.lignesservice.application.service;


import ch.sebooom.lignesservice.infra.entity.Segment;
import ch.sebooom.lignesservice.infra.entity.Station;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


public interface StationService {


    Collection findAll ();

    void insertLigne1Data ();

    void insertLigne4Data ();

    Optional<Station> findById(String stationId);

    Collection<Segment> trajet(String depart, String arrivee);
}
