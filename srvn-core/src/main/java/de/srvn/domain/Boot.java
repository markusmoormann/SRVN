package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:47
 */
@Entity
@Table(name = "boot")
@XmlRootElement
public class Boot extends IdOnly {

    private Verein verein;
    private List<Meldung> meldungList = new LinkedList<>();
    private List<Ruderer> ruderer = new LinkedList<>();

    @ManyToOne
    public Verein getVerein() {
        return verein;
    }

    public void setVerein(Verein verein) {
        this.verein = verein;
    }

    @OneToMany
    public List<Meldung> getMeldungList() {
        return meldungList;
    }

    public void setMeldungList(List<Meldung> meldungList) {
        this.meldungList = meldungList;
    }

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "ruderer_id")},
            inverseJoinColumns = {@JoinColumn(name = "boot_id")}
    )
    public List<Ruderer> getRuderer() {
        return ruderer;
    }

    public void setRuderer(List<Ruderer> ruderer) {
        this.ruderer = ruderer;
    }
}
