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

    @Property(name="distance")
    private int distance;

    @Property(name="ligne")
    private String ligne;

    @Property(name = "identifiant")
    private String identifiant;

    @StartNode
    private Station depart;

    @EndNode
    private Station arrivee;

    private static final String IDENTIFIANT_PATTERN = "%s-%s";

    public Segment () {}

    private Segment(Station depart, Station arrivee, int distance, String ligne){
        this.arrivee = arrivee;
        this.depart = depart;
        this.distance = distance;
        this.ligne = ligne;
        this.identifiant = String.format(IDENTIFIANT_PATTERN,depart.getIdentifiant(),arrivee.getIdentifiant());
    }

    public static Segment of(Station depart, Station arrivee, int distance, String ligne) {
        return new Segment(depart,arrivee,distance,ligne);
    }
}
