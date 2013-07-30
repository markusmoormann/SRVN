package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Markus Moormann
 * @author Philipp Kürschner
 * @version 25.07.2012
 */
@Entity
@Table(name = "rennen")
@XmlRootElement
public class Rennen extends IdOnly {

    private String rennname;
    private String rennnr;
    private Bootsgattung bootsgattung;
    private int distanz;
    private Geschlecht geschlecht;
    private String bemerkung;
    private String leistungsgruppe;
    private int position;
    private int preis;
    private String wettkampfklasse;
    private int alterVon;
    private int alterBis;
    private boolean faelltAus = false;
    private String kurzname;
    private boolean hatVorlaeufe = false;
    private Regatta regatta;
    private List<Lauf> laufList;
    private List<Meldung> meldungList;

    public String getRennname() {
        return rennname;
    }

    public void setRennname(String rennname) {
        this.rennname = rennname;
    }

    public String getRennnr() {
        return rennnr;
    }

    public void setRennnr(String rennnr) {
        this.rennnr = rennnr;
    }

    @ManyToOne
    public Bootsgattung getBootsgattung() {
        return bootsgattung;
    }

    public void setBootsgattung(Bootsgattung bootsgattung) {
        this.bootsgattung = bootsgattung;
    }

    public int getDistanz() {
        return distanz;
    }

    public void setDistanz(int distanz) {
        this.distanz = distanz;
    }

    @Enumerated(EnumType.STRING)
    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getLeistungsgruppe() {
        return leistungsgruppe;
    }

    public void setLeistungsgruppe(String leistungsgruppe) {
        this.leistungsgruppe = leistungsgruppe;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getWettkampfklasse() {
        return wettkampfklasse;
    }

    public void setWettkampfklasse(String wettkampfklasse) {
        this.wettkampfklasse = wettkampfklasse;
    }

    public int getAlterVon() {
        return alterVon;
    }

    public void setAlterVon(int alterVon) {
        this.alterVon = alterVon;
    }

    public int getAlterBis() {
        return alterBis;
    }

    public void setAlterBis(int alterBis) {
        this.alterBis = alterBis;
    }

    public boolean isFaelltAus() {
        return faelltAus;
    }

    public void setFaelltAus(boolean faelltAus) {
        this.faelltAus = faelltAus;
    }

    public String getKurzname() {
        return kurzname;
    }

    public void setKurzname(String kurzname) {
        this.kurzname = kurzname;
    }

    public boolean isHatVorlaeufe() {
        return hatVorlaeufe;
    }

    public void setHatVorlaeufe(boolean hatVorlaeufe) {
        this.hatVorlaeufe = hatVorlaeufe;
    }

    @ManyToOne
    public Regatta getRegatta() {
        return regatta;
    }

    public void setRegatta(Regatta regatta) {
        this.regatta = regatta;
    }

    @OneToMany
    public List<Lauf> getLaufList() {
        return laufList;
    }

    public void setLaufList(List<Lauf> laufList) {
        this.laufList = laufList;
    }

    @OneToMany
    public List<Meldung> getMeldungList() {
        return meldungList;
    }

    public void setMeldungList(List<Meldung> meldungList) {
        this.meldungList = meldungList;
    }
}
