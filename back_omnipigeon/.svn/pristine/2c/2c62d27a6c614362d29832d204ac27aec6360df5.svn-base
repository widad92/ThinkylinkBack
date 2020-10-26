package com.omni.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractTimestampEntity extends GenericEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreation", nullable = true, updatable = false)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateModification", nullable = true)
    private Date dateModification;

    @PrePersist
    protected void onCreate() {
        dateCreation = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateModification = new Date();
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

}
