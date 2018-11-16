package ch.sebooom.lignesservice.application.service;


import ch.sebooom.lignesservice.infra.graph.entity.Segment;
import ch.sebooom.lignesservice.infra.graph.entity.Station;
import java.util.Collection;
import java.util.Optional;


public interface StationService {


    Collection findAll ();

    Optional<Station> findById(String stationId);

    Collection<Segment> trajet(String depart, String arrivee);
}
