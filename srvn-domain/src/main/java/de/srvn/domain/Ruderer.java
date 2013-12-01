package de.srvn.domain;

import de.srvn.domain.api.IdOnly;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:54
 */
@Entity
@Table(name = "ruderer")
@Indexed
public class Ruderer extends IdOnly {

    private String name;
    private Integer jahrgang;
    private List<Startberechtigung> startberechtigungList = new ArrayList<>();
    private Verein verein;
    private Geschlecht geschlecht;

    @Field(store = Store.YES)
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

    @Transient
    public List<Startberechtigung> getStartberechtigungList() {
        return startberechtigungList;
    }

    public void setStartberechtigungList(List<Startberechtigung> startberechtigungList) {
        this.startberechtigungList = startberechtigungList;
    }

    @ManyToOne
//    @Field(store = Store.YES, bridge = Verei)
    public Verein getVerein() {
        return verein;
    }

    public void setVerein(Verein verein) {
        this.verein = verein;
    }

    @Enumerated(EnumType.STRING)
    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }
}
