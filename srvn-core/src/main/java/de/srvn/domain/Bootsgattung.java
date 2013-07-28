package de.srvn.domain;

import de.srvn.domain.api.LabelAware;
import de.srvn.domain.api.Value;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 12:15
 */
public class Bootsgattung extends Value implements LabelAware {

    private String label;

    private Bootsgattung(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel() {
        this.label = label;
    }
}
