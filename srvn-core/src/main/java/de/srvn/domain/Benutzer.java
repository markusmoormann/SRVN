package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Benutzer
 *
 * @author Markus Moormann
 * @author Philipp Kürschner
 * @version 13.04.2012
 */
@Entity
@Table(name = "benutzer")
@XmlRootElement
public class Benutzer extends IdOnly {

    private Verein verein;
    private String benutzername;
    private String email;
    private String passwort;
    private Collection<Rolle> rollen = new LinkedList<Rolle>();
    private String aktivierung;

}
