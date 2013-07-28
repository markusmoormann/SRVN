package de.srvn.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name = "meldung")
@XmlRootElement
public class Meldung extends IdOnly {
  private Rechnung rechnung;
  private boolean ausgefallen;
  private float preis;
  private Protektor obmann;
  private Integer meldungId;
  private Integer startnummer;
  private Integer abteilung;
  private Integer bootsnummer;
  private boolean nachgemeldet;
  private boolean abgemeldet;
  private Boot boot;
  private Rennen rennen;
  private boolean online;


}
