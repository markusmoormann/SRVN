/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.srvn.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Markus
 */
@Entity
@Table(name = "startberechtigung")
@XmlRootElement
public class Startberechtigung implements Serializable {
    private boolean schulbescheinigung;
    private boolean aktivenpass;
    private boolean gesundheitsbescheinigung;
    private Regatta regatta;
    private Ruderer ruderer;

    public boolean isSchulbescheinigung() {
        return schulbescheinigung;
    }

    public void setSchulbescheinigung(boolean schulbescheinigung) {
        this.schulbescheinigung = schulbescheinigung;
    }

    public boolean isAktivenpass() {
        return aktivenpass;
    }

    public void setAktivenpass(boolean aktivenpass) {
        this.aktivenpass = aktivenpass;
    }

    public boolean isGesundheitsbescheinigung() {
        return gesundheitsbescheinigung;
    }

    public void setGesundheitsbescheinigung(boolean gesundheitsbescheinigung) {
        this.gesundheitsbescheinigung = gesundheitsbescheinigung;
    }

    public Regatta getRegatta() {
        return regatta;
    }

    public void setRegatta(Regatta regatta) {
        this.regatta = regatta;
    }

    public Ruderer getRuderer() {
        return ruderer;
    }

    public void setRuderer(Ruderer ruderer) {
        this.ruderer = ruderer;
    }
}
