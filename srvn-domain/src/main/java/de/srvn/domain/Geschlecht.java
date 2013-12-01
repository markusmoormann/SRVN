package de.srvn.domain;

import de.srvn.domain.api.LabelAware;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 11:59
 */
public enum Geschlecht implements LabelAware {

    MAENNLICH("männlich"),
    WEIBLICH("weiblich");

    private String label;

    Geschlecht(String label) {
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
