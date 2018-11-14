package ch.sebooom.lignesservice.infra.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

import java.time.LocalTime;
import java.util.List;

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
