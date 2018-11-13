package ch.sebooom.lignesservice.infra.entity;


import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


import java.util.List;

@ToString(exclude = "connections")
@NodeEntity
public class Station {

    public Station () {}
    @Id
    @GeneratedValue
    Long id;

    private String nom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Relationship(type = "CONNECTE_A", direction = "OUTGOING")
    private List<Segment> connections;


    public List<Segment> getConnections() {
        return connections;
    }

    public void setConnections(List<Segment> connections) {
        this.connections = connections;
    }
}
