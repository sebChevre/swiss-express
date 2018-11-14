package ch.sebooom.lignesservice.infra.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;


import java.util.List;

@JsonIgnoreProperties(value = "connections")
@ToString(exclude = "connections")
@Getter
@Setter
@NodeEntity
public class Station {

    public Station () {}
    @Id
    @GeneratedValue
    Long id;

    @Property(name = "identifiant")
    private String identifiant;

    @Property(name = "nom")
    private String nom;

    @Relationship(type = "CONNECTE_A", direction = "OUTGOING")
    private List<Segment> connections;

}
