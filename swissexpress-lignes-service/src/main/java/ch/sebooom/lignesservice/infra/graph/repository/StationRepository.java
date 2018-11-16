package ch.sebooom.lignesservice.infra.graph.repository;

import ch.sebooom.lignesservice.infra.graph.entity.Segment;
import ch.sebooom.lignesservice.infra.graph.entity.Station;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface StationRepository extends Neo4jRepository<Station, Long> {

    //@Query("MATCH (s:Station)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
    @Query("MATCH (s:Station { nom: {startStation} }),(e:Station { nom: {endStation} }), p = shortestPath((s)-[*]-(e)) RETURN p")
    Collection<Station> trajetStations(@Param("startStation") String startStation, @Param("endStation") String endStation);

    Optional<Station> findByIdentifiant(@Param("identifial") String identifiant);


    @Query("MATCH (s:Station { identifiant: {startStation} }),(e:Station { identifiant: {endStation} }), p = shortestPath((s)-[*]->(e)) RETURN relationships(p),nodes(p)")
    Collection<Segment> segmentStations(@Param("startStation") String startStation, @Param("endStation") String endStation);
}
