package de.srvn.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Markus
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Table(name = "ergebnis")
@XmlRootElement
public class Ergebnis extends IdOnly {
    private int position;
    private Date zeit;
    private Lauf lauf;
    private Meldung meldung;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Temporal(TemporalType.TIME)
    public Date getZeit() {
        return zeit;
    }

    public void setZeit(Date zeit) {
        this.zeit = zeit;
    }

    @ManyToOne
    public Lauf getLauf() {
        return lauf;
    }

    public void setLauf(Lauf lauf) {
        this.lauf = lauf;
    }

    @ManyToOne
    public Meldung getMeldung() {
        return meldung;
    }

    public void setMeldung(Meldung meldung) {
        this.meldung = meldung;
    }
}
