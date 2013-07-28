package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Markus Moormann
 * @author Philipp Kürschner
 *
 * @version 22.08.2012
 */
@Entity
@Table(name = "dokument")
@XmlRootElement
public class Dokument extends IdOnly implements Serializable {
  private String name;
  private String pfad;
  private Regatta regatta;
  private long filesize;
  private String mimetype;


}
