package ch.sebooom.lignesservice.application.service;


import ch.sebooom.lignesservice.infra.graph.entity.Segment;
import ch.sebooom.lignesservice.infra.graph.entity.Station;
import java.util.Collection;
import java.util.Optional;


public interface StationService {


    Collection findAll ();

    void insertLigne1Data ();

    void insertLigne2Data ();

    void insertLigne3Data ();

    void insertLigne4Data ();

    void insertLigne5Data();

    Optional<Station> findById(String stationId);

    Collection<Segment> trajet(String depart, String arrivee);
}
