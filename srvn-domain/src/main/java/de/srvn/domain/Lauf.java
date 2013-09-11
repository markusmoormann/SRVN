package de.srvn.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Markus
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Table(name = "lauf")
@XmlRootElement
public class Lauf extends IdOnly {
    private String lauf;
    private Date startzeit;
    private Rennen rennen;
    private List<Ergebnis> ergebnisList = new LinkedList<>();

    public String getLauf() {
        return lauf;
    }

    public void setLauf(String lauf) {
        this.lauf = lauf;
    }

    public Date getStartzeit() {
        return startzeit;
    }

    public void setStartzeit(Date startzeit) {
        this.startzeit = startzeit;
    }

    @ManyToOne
    public Rennen getRennen() {
        return rennen;
    }

    public void setRennen(Rennen rennen) {
        this.rennen = rennen;
    }

    @OneToMany(mappedBy = "lauf")
    public List<Ergebnis> getErgebnisList() {
        return ergebnisList;
    }

    public void setErgebnisList(List<Ergebnis> ergebnisList) {
        this.ergebnisList = ergebnisList;
    }
}
