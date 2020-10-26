package com.omni.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "user")
@Proxy(lazy = false)
public class User extends AbstractTimestampEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", unique = true, nullable = false)
    private Long userId;

    @Column(name = "refUser", length = 15)
    private String refUser;

    @Column(name = "initial", length = 3)
    private String initial;

    @Column(name = "email", unique = true)
    private String email;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateSuppression", nullable = true)
    private Date dateSuppression;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "token")
    private String token;

    @Column(name = "tokenNumber")
    private String tokenNumber;

    @Column(name = "flagUser", length = 1)
    private boolean flagUser;

    @Column(name = "provider", updatable = false)
    private String provider;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "adresseId", referencedColumnName = "adresseId")
    private Adresse adresse;

    @Transient //IsOrganisation
    private boolean organisation;

    @Transient //IsClient
    private boolean client;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public boolean isOrganisation() {
        return organisation;
    }

    public void setIsOrganisation(boolean isOrganisation) {
        this.organisation = isOrganisation;
    }

    public boolean isClient() {
        return client;
    }

    public void setIsClient(boolean client) {
        this.client = client;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the flagUser
     */
    public boolean getFlagUser() {
        return flagUser;
    }

    /**
     * @param flagUser the flagUser to set
     */
    public void setFlagUser(boolean flagUser) {
        this.flagUser = flagUser;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public String getRefUser() {
        return refUser;
    }

    public void setRefUser(String refUser) {
        this.refUser = refUser;
    }
    /**
     * @return the tokenNumber
     */
    public String getTokenNumber() {
        return tokenNumber;
    }

    /**
     * @param tokenNumber the tokenNumber to set
     */
    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    /**
     * @return the initial
     */
    public String getInitial() {
        return initial;
    }

    /**
     * @param initial the initial to set
     */
    public void setInitial(String initial) {
        this.initial = initial;
    }

}
