package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Collection;

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
    private Collection<Meldung> meldungCollection;

}
