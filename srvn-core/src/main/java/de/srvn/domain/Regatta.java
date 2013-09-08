package de.srvn.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * @author Markus Moormann
 * @author Philipp Kürschner
 * @version 05.07.2012
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Table(name = "regatta")
@XmlRootElement
public class Regatta extends IdOnly {
    private RegattaEinstellung einstellung;
    private String name;
    private String ort;
    private String regattaleiter;
    private Date letzteAenderung;
    private Date meldeschluss;
    private Date veranstaltungVon;
    private Date veranstaltungBis;
    private String nameKurz;
    private String veranstalter;
    private Benutzer veranstalter_Benutzer;
    private List<Startberechtigung> startberechtigungList;
    private List<Rennen> rennenList;

    @OneToOne
    public RegattaEinstellung getEinstellung() {
        return einstellung;
    }

    public void setEinstellung(RegattaEinstellung einstellung) {
        this.einstellung = einstellung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getRegattaleiter() {
        return regattaleiter;
    }

    public void setRegattaleiter(String regattaleiter) {
        this.regattaleiter = regattaleiter;
    }

    public Date getLetzteAenderung() {
        return letzteAenderung;
    }

    public void setLetzteAenderung(Date letzteAenderung) {
        this.letzteAenderung = letzteAenderung;
    }

    public Date getMeldeschluss() {
        return meldeschluss;
    }

    public void setMeldeschluss(Date meldeschluss) {
        this.meldeschluss = meldeschluss;
    }

    public Date getVeranstaltungVon() {
        return veranstaltungVon;
    }

    public void setVeranstaltungVon(Date veranstaltungVon) {
        this.veranstaltungVon = veranstaltungVon;
    }

    public Date getVeranstaltungBis() {
        return veranstaltungBis;
    }

    public void setVeranstaltungBis(Date veranstaltungBis) {
        this.veranstaltungBis = veranstaltungBis;
    }

    public String getNameKurz() {
        return nameKurz;
    }

    public void setNameKurz(String nameKurz) {
        this.nameKurz = nameKurz;
    }

    public String getVeranstalter() {
        return veranstalter;
    }

    public void setVeranstalter(String veranstalter) {
        this.veranstalter = veranstalter;
    }

    @ManyToOne
    public Benutzer getVeranstalter_Benutzer() {
        return veranstalter_Benutzer;
    }

    public void setVeranstalter_Benutzer(Benutzer veranstalter_Benutzer) {
        this.veranstalter_Benutzer = veranstalter_Benutzer;
    }

    @OneToMany
    public List<Startberechtigung> getStartberechtigungList() {
        return startberechtigungList;
    }

    public void setStartberechtigungList(List<Startberechtigung> startberechtigungList) {
        this.startberechtigungList = startberechtigungList;
    }

    @OneToMany(mappedBy = "regatta")
    public List<Rennen> getRennenList() {
        return rennenList;
    }

    public void setRennenList(List<Rennen> rennenList) {
        this.rennenList = rennenList;
    }
}
