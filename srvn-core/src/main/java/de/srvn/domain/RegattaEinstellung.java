package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Markus Moormann
 * @version 20.11.2012
 */
@Entity
@Table(name = "regatta_einstellung")
@XmlRootElement
public class RegattaEinstellung extends IdOnly {
    private int rechnungsNr;
    private String fusszeileRechts;
    private String fusszeileMitte;
    private String fusszeileLinks;
    private BigDecimal preis1;
    private BigDecimal preis2;
    private BigDecimal preis4;
    private BigDecimal preis8;
    private BigDecimal startbahnen;
    private List<Regatta> regattaList;

    public int getRechnungsNr() {
        return rechnungsNr;
    }

    public void setRechnungsNr(int rechnungsNr) {
        this.rechnungsNr = rechnungsNr;
    }

    public String getFusszeileRechts() {
        return fusszeileRechts;
    }

    public void setFusszeileRechts(String fusszeileRechts) {
        this.fusszeileRechts = fusszeileRechts;
    }

    public String getFusszeileMitte() {
        return fusszeileMitte;
    }

    public void setFusszeileMitte(String fusszeileMitte) {
        this.fusszeileMitte = fusszeileMitte;
    }

    public String getFusszeileLinks() {
        return fusszeileLinks;
    }

    public void setFusszeileLinks(String fusszeileLinks) {
        this.fusszeileLinks = fusszeileLinks;
    }

    public BigDecimal getPreis1() {
        return preis1;
    }

    public void setPreis1(BigDecimal preis1) {
        this.preis1 = preis1;
    }

    public BigDecimal getPreis2() {
        return preis2;
    }

    public void setPreis2(BigDecimal preis2) {
        this.preis2 = preis2;
    }

    public BigDecimal getPreis4() {
        return preis4;
    }

    public void setPreis4(BigDecimal preis4) {
        this.preis4 = preis4;
    }

    public BigDecimal getPreis8() {
        return preis8;
    }

    public void setPreis8(BigDecimal preis8) {
        this.preis8 = preis8;
    }

    public BigDecimal getStartbahnen() {
        return startbahnen;
    }

    public void setStartbahnen(BigDecimal startbahnen) {
        this.startbahnen = startbahnen;
    }

    @OneToMany
    public List<Regatta> getRegattaList() {
        return regattaList;
    }

    public void setRegattaList(List<Regatta> regattaList) {
        this.regattaList = regattaList;
    }
}
