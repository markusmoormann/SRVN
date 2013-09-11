package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Markus
 */
@Entity
@Table(name = "obmann")
@XmlRootElement
public class Obmann extends IdOnly {
    private List<Meldung> meldungList;
    private Integer protektorId;
    private String name;
    private String strasse;
    private String hausnummer;
    private Integer plz;
    private String ort;
    private String email;
    private String telefon;
    private Verein verein;

    @OneToMany(mappedBy = "obmann")
    public List<Meldung> getMeldungList() {
        return meldungList;
    }

    public void setMeldungList(List<Meldung> meldungList) {
        this.meldungList = meldungList;
    }

    public Integer getProtektorId() {
        return protektorId;
    }

    public void setProtektorId(Integer protektorId) {
        this.protektorId = protektorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @ManyToOne
    public Verein getVerein() {
        return verein;
    }

    public void setVerein(Verein verein) {
        this.verein = verein;
    }
}
