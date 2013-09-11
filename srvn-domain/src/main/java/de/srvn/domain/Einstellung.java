package de.srvn.domain;

import de.srvn.domain.api.IdOnly;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Markus Moormann
 * @author Philipp Kürschner
 * @version 24.07.2012
 */
@Entity
@Table(name = "einstellung")
@XmlRootElement
public class Einstellung extends IdOnly {
    private String valueKey;
    private String value;

    public String getValueKey() {
        return valueKey;
    }

    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
