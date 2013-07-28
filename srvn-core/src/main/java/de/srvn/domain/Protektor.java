package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 *
 * @author Markus
 */
@Entity
@Table(name = "protektor")
@XmlRootElement
public class Protektor extends IdOnly {
  private Collection<Meldung> meldungCollection;
  private Integer protektorId;
  private String name;
  private String strasse;
  private String hausnummer;
  private Integer plz;
  private String ort;
  private String email;
  private String telefon;
  private Verein verein;

}
