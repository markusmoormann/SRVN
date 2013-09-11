package de.srvn.domain.api;

import javax.persistence.MappedSuperclass;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 12:12
 */
@MappedSuperclass
public class Value extends IdOnly {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
