package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:54
 */
@Entity
@Table(name = "ruderer")
@XmlRootElement
public class Ruderer extends IdOnly {

    private String name;
    private Integer jahrgang;
    private Collection<Startberechtigung> startberechtigungCollection;
    private Verein verein;
    private Geschlecht geschlecht;

}
