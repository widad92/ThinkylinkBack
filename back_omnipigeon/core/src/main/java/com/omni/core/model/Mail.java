package com.omni.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "mail")
@Proxy(lazy = false)
public class Mail extends AbstractTimestampEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mailId", unique = true, nullable = false)
    private Long mailId;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "emailFrom")
    private String emailFrom;
    @Column(name = "subject")
    private String subject;
    @Column(name = "emailTo")
    private String emailTo;
    @Column(name = "cc")
    private String cc;
    @Column(name = "cci")
    private String cci;
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
    @Column(name = "tel", length = 14)
    private String tel;
    @Column(name = "origine", length = 20)
    private String origine;
    @Column(name = "type", length = 50)
    private String type;
    @Column(name = "libelle", length = 100)
    private String libelle;

//    private List<String> files;
    /**
     * @return the mailId
     */
    public Long getMailId() {
        return mailId;
    }

    /**
     * @param mailId the mailId to set
     */
    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the emailFrom
     */
    public String getEmailFrom() {
        return emailFrom;
    }

    /**
     * @param emailFrom the emailFrom to set
     */
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the emailTo
     */
    public String getEmailTo() {
        return emailTo;
    }

    /**
     * @param emailTo the emailTo to set
     */
    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    /**
     * @return the cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * @return the cci
     */
    public String getCci() {
        return cci;
    }

    /**
     * @param cci the cci to set
     */
    public void setCci(String cci) {
        this.cci = cci;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the origine
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * @param origine the origine to set
     */
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    

}
