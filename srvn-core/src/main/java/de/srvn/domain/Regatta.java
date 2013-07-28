package de.srvn.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Date;

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
    private Collection<Startberechtigung> startberechtigungCollection;
    private Collection<Rennen> rennenCollection;

}
