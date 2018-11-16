package ch.sebooom.lignesservice.infra.graph.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

@ToString
@Setter
@Getter
@RelationshipEntity(type = "CONNECTE_A")
public class Segment {

    @Id
    @GeneratedValue
    private Long id;

    private int distance;

    private String ligne;

    @Property(name = "test")
    private String [] departs;

    @StartNode
    private Station depart;

    @EndNode
    private Station arrivee;
}
