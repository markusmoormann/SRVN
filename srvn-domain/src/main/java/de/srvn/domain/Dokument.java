package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Markus Moormann
 * @author Philipp Kürschner
 * @version 22.08.2012
 */
@Entity
@Table(name = "dokument")
@XmlRootElement
public class Dokument extends IdOnly {
    private String name;
    private String pfad;
    private Regatta regatta;
    private long filesize;
    private String mimetype;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    @ManyToOne
    public Regatta getRegatta() {
        return regatta;
    }

    public void setRegatta(Regatta regatta) {
        this.regatta = regatta;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }
}
