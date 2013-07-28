package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:52
 */
@Entity
@Table(name = "verein")
@XmlRootElement
public class Verein extends IdOnly {

    private String adresse;
    private String plz;
    private String stadt;
    private String name;
    private Collection<Boot> bootCollection;
    private Collection<Benutzer> benutzerCollection;
    private Collection<Protektor> protektorCollection;
    private Collection<Ruderer> rudererCollection;

}
