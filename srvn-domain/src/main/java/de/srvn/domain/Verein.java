package de.srvn.domain;

import de.srvn.domain.api.IdOnly;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:52
 */
@Entity
@Table(name = "verein")
@Indexed
public class Verein extends IdOnly {

    private String adresse;
    private String plz;
    private String stadt;
    private String name;
    private List<Boot> bootList;
    private List<Benutzer> benutzerList;
    private List<Obmann> obmannList;
    private List<Ruderer> rudererList;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    @Field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "verein")
    public List<Boot> getBootList() {
        return bootList;
    }

    public void setBootList(List<Boot> bootList) {
        this.bootList = bootList;
    }

    @OneToMany(mappedBy = "verein")
    public List<Benutzer> getBenutzerList() {
        return benutzerList;
    }

    public void setBenutzerList(List<Benutzer> benutzerList) {
        this.benutzerList = benutzerList;
    }

    @OneToMany(mappedBy = "verein")
    public List<Obmann> getObmannList() {
        return obmannList;
    }

    public void setObmannList(List<Obmann> obmannList) {
        this.obmannList = obmannList;
    }

    @OneToMany(mappedBy = "verein")
    public List<Ruderer> getRudererList() {
        return rudererList;
    }

    public void setRudererList(List<Ruderer> rudererList) {
        this.rudererList = rudererList;
    }
}
