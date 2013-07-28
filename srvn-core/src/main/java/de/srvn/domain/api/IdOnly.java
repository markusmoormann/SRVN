package de.srvn.domain.api;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Markus Moormann
 * @version 01.04.13 - 14:18
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@MappedSuperclass
public abstract class IdOnly implements IdAcc, Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    /** Wird vor dem L&ouml;schen einer Instanz aufgerufen. */
    public IdOnly onBeforeDelete() {
        return this;
    }

    /** Wird vor dem Speichern einer Instanz aufgerufen. */
    public IdOnly onBeforeSave() {
        return this;
    }

    /** Wird vor dem Update einer Instanz aufgerufen. */
    public IdOnly onBeforeUpdate() {
        return this;
    }

    /** Wird vor dem SaveOrUpdate einer Instanz aufgerufen. */
    public IdOnly onBeforeSaveOrUpdate() {
        return this;
    }

    /**
     * Uebernimmt alle base-Attribute aus what.
     *
     * @param what
     */
    public void mimic(final IdOnly what) {
        id = what.getId();
    }

    /** Setzt id = null. */
    public IdOnly clear() {
        id = null;
        return this;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (id == null ||
                obj == null) {
            return false;
        }

        return obj instanceof IdOnly &&
                id.equals(((IdOnly) obj).getId());
    }

    @Override
    public int hashCode() {
        return (id == null) ? System.identityHashCode(this) : id.hashCode();
    }

    /** @return Returns the id. */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    protected void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @see java.lang.Object#clone()
     */
    @Override
    protected IdOnly clone() {
        try {
            return (IdOnly) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("should never happen", e);
        }
    }

    protected IdOnly cloneAndClear() {
        try {
            IdOnly theClone = (IdOnly) super.clone();
            return theClone.clear();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("should never happen", e);
        }
    }


}
