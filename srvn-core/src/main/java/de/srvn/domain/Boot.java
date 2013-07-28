package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:47
 */
@Entity
@Table(name = "boot")
@XmlRootElement
public class Boot extends IdOnly {

    private Verein verein;
    private Collection<Meldung> meldungCollection;
    private Collection<Ruderer> ruderer = new LinkedList<>();

}
