package de.srvn.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * @author Markus
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Table(name = "meldung")
@XmlRootElement
public class Meldung extends IdOnly {
    private Rechnung rechnung;
    private boolean faelltAus = false;
    private BigDecimal preis;
    private Obmann obmann;
    private Integer meldungId;
    private Integer startnummer;
    private Integer abteilung;
    private Integer bootsnummer;
    private boolean nachgemeldet = false;
    private boolean abgemeldet = false;
    private Boot boot;
    private Rennen rennen;
    private boolean online = false;

    @ManyToOne
    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public boolean isFaelltAus() {
        return faelltAus;
    }

    public void setFaelltAus(boolean faelltAus) {
        this.faelltAus = faelltAus;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    @ManyToOne
    public Obmann getObmann() {
        return obmann;
    }

    public void setObmann(Obmann obmann) {
        this.obmann = obmann;
    }

    public Integer getMeldungId() {
        return meldungId;
    }

    public void setMeldungId(Integer meldungId) {
        this.meldungId = meldungId;
    }

    public Integer getStartnummer() {
        return startnummer;
    }

    public void setStartnummer(Integer startnummer) {
        this.startnummer = startnummer;
    }

    public Integer getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Integer abteilung) {
        this.abteilung = abteilung;
    }

    public Integer getBootsnummer() {
        return bootsnummer;
    }

    public void setBootsnummer(Integer bootsnummer) {
        this.bootsnummer = bootsnummer;
    }

    public boolean isNachgemeldet() {
        return nachgemeldet;
    }

    public void setNachgemeldet(boolean nachgemeldet) {
        this.nachgemeldet = nachgemeldet;
    }

    public boolean isAbgemeldet() {
        return abgemeldet;
    }

    public void setAbgemeldet(boolean abgemeldet) {
        this.abgemeldet = abgemeldet;
    }

    @ManyToOne
    public Boot getBoot() {
        return boot;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    @ManyToOne
    public Rennen getRennen() {
        return rennen;
    }

    public void setRennen(Rennen rennen) {
        this.rennen = rennen;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
