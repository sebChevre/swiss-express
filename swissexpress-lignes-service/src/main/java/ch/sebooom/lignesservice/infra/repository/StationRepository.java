package ch.sebooom.lignesservice.infra.repository;

import ch.sebooom.lignesservice.infra.entity.Station;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends Neo4jRepository<Station, Long> {
}
