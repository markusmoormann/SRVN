package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

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
    private List<Rolle> rollen = new LinkedList<>();
    private String aktivierung;

    @ManyToOne
    public Verein getVerein() {
        return verein;
    }

    public void setVerein(Verein verein) {
        this.verein = verein;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    @OneToMany
    public List<Rolle> getRollen() {
        return rollen;
    }

    public void setRollen(List<Rolle> rollen) {
        this.rollen = rollen;
    }

    public String getAktivierung() {
        return aktivierung;
    }

    public void setAktivierung(String aktivierung) {
        this.aktivierung = aktivierung;
    }
}
