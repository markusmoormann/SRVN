package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:54
 */
@Entity
@Table(name = "ruderer")
@XmlRootElement
public class Ruderer extends IdOnly {

    private String name;
    private Integer jahrgang;
    private List<Startberechtigung> startberechtigungList;
    private Verein verein;
    private Geschlecht geschlecht;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(Integer jahrgang) {
        this.jahrgang = jahrgang;
    }

    @OneToMany
    public List<Startberechtigung> getStartberechtigungList() {
        return startberechtigungList;
    }

    public void setStartberechtigungList(List<Startberechtigung> startberechtigungList) {
        this.startberechtigungList = startberechtigungList;
    }

    @ManyToOne
    public Verein getVerein() {
        return verein;
    }

    public void setVerein(Verein verein) {
        this.verein = verein;
    }

    @Enumerated
    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }
}
