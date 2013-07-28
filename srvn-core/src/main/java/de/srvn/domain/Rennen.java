package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

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
    private String geschlecht;
    private String bemerkung;
    private String leistungsgruppe;
    private int position;
    private int preis;
    private String wettkampfklasse;
    private int alterVon;
    private int alterBis;
    private boolean faelltAus;
    private String kurzname;
    private boolean hatVorlaeufe = false;
    private Regatta regatta;
    private Collection<Lauf> laufCollection;
    private Collection<Meldung> meldungCollection;


}
