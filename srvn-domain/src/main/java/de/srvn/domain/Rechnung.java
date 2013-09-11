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
 * @version 22.11.2012
 */
@Entity
@Table(name = "rechnung")
@XmlRootElement
public class Rechnung extends IdOnly {
    private String dateiname;
    private Integer rechnungsNr;
    private BigDecimal betrag;
    private List<Meldung> meldungList;

    public String getDateiname() {
        return dateiname;
    }

    public void setDateiname(String dateiname) {
        this.dateiname = dateiname;
    }

    public Integer getRechnungsNr() {
        return rechnungsNr;
    }

    public void setRechnungsNr(Integer rechnungsNr) {
        this.rechnungsNr = rechnungsNr;
    }

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    @OneToMany(mappedBy = "rechnung")
    public List<Meldung> getMeldungList() {
        return meldungList;
    }

    public void setMeldungList(List<Meldung> meldungList) {
        this.meldungList = meldungList;
    }
}
