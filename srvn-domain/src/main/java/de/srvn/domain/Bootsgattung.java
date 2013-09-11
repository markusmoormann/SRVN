package de.srvn.domain;

import de.srvn.domain.api.LabelAware;
import de.srvn.domain.api.Value;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 12:15
 */
@Entity
@Table(name = "bootsgattung")
@XmlRootElement
public class Bootsgattung extends Value implements LabelAware {

    private String label;

    private Bootsgattung() {}

    private Bootsgattung(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}
