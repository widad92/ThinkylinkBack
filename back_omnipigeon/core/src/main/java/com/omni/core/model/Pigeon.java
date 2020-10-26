package com.omni.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "pigeon")
@Proxy(lazy = false)
public class Pigeon extends AbstractTimestampEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pigeonId", unique = true, nullable = false)
    private Long pigeonId;

    @Column(name = "pigeonName")
    private String pigeonName;

    @Column(name = "NumeroSerie")
    private String NumeroSerie;
    
    @Column(name = "idPere")
    private Long idPere;
    
    @Column(name = "idMere")
    private Long idMere;
    
    @Column(name = "lieuNaissance", length = 100)
    private String lieuNaissance;

    @Column(name = "dateNaissance", length = 100)
    private Date dateNaissance;

     @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "couleurPigeonId")
    private Couleur couleurPigeon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "couleurYeuxId")
    private Couleur couleurYeux;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "couleurBagueId")
    private Couleur couleurBague;

    @Column(name = "disciplines")
    private String disciplines;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "taille")
    private String taille;

    @Column(name = "epaisseur")
    private String epaisseur;

    @Column(name = "vitalite")
    private String vitalite;

    @Column(name = "densiteCouleur")
    private String densiteCouleur;

    @Column(name = "longueur")
    private String longueur;

    @Column(name = "DegreForce")
    private String degreForce;

    @Column(name = "SoliditeFourche")
    private String SoliditeFourche;

    @Column(name = "PositionFourche")
    private String PositionFourche;

    @Column(name = "muscle")
    private String muscle;

    @Column(name = "equilibre")
    private String equilibre;

    @Column(name = "dos")
    private String dos;

    @Column(name = "plumeElevage")
    private String plumeElevage;

    @Column(name = "Primaires")
    private String Primaires;

    @Column(name = "plumage")
    private String plumage;

    @Column(name = "plume")
    private String plume;

    @Column(name = "arriereAile")
    private String arriereAile;

    @Column(name = "souplesse")
    private String souplesse;

    @ManyToOne 
    @JoinColumn( name="clientId", nullable=false )
    private Client client;

    
    @ManyToOne 
    @JoinColumn( name="stationId", nullable=false )
    private StationElevage stationElevage;
    
   /* @ManyToOne
    @JoinColumn(name = "enchereId", nullable=false )
    private Enchere enchere;*/

    @ManyToOne
    @JoinColumn(name = "acteurId", nullable=false )
    private Acteur acteur;


    public Pigeon() {
        super();
    }
      
   
    /**
     * @return the pigeonName
     */
    public String getPigeonName() {
        return pigeonName;
    }

    /**
     * @param pigeonName the pigeonName to set
     */
    public void setPigeonName(String pigeonName) {
        this.pigeonName = pigeonName;
    }

    /**
     * @return the NumeroSerie
     */
    public String getNumeroSerie() {
        return NumeroSerie;
    }

    /**
     * @param NumeroSerie the NumeroSerie to set
     */
    public void setNumeroSerie(String NumeroSerie) {
        this.NumeroSerie = NumeroSerie;
    }

    /**
     * @return the LieuNaissance
     */
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * @param lieuNaissance the LieuNaissance to set
     */
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the couleurPigeon
     */
    public Couleur getCouleurPigeon() {
        return couleurPigeon;
    }

    /**
     * @param couleurPigeon the couleurPigeon to set
     */
    public void setCouleurPigeon(Couleur couleurPigeon) {
        this.couleurPigeon = couleurPigeon;
    }

    /**
     * @return the couleurYeux
     */
    public Couleur getCouleurYeux() {
        return couleurYeux;
    }

    /**
     * @param couleurYeux the couleurYeux to set
     */
    public void setCouleurYeux(Couleur couleurYeux) {
        this.couleurYeux = couleurYeux;
    }

    /**
     * @return the couleurBague
     */
    public Couleur getCouleurBague() {
        return couleurBague;
    }

    /**
     * @param couleurBague the couleurBague to set
     */
    public void setCouleurBague(Couleur couleurBague) {
        this.couleurBague = couleurBague;
    }

    /**
     * @return the disciplines
     */
    public String getDisciplines() {
        return disciplines;
    }

    /**
     * @param disciplines the disciplines to set
     */
    public void setDisciplines(String disciplines) {
        this.disciplines = disciplines;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the taille
     */
    public String getTaille() {
        return taille;
    }

    /**
     * @param taille the taille to set
     */
    public void setTaille(String taille) {
        this.taille = taille;
    }

    /**
     * @return the epaisseur
     */
    public String getEpaisseur() {
        return epaisseur;
    }

    /**
     * @param epaisseur the epaisseur to set
     */
    public void setEpaisseur(String epaisseur) {
        this.epaisseur = epaisseur;
    }

    /**
     * @return the vitalite
     */
    public String getVitalite() {
        return vitalite;
    }

    /**
     * @param vitalite the vitalite to set
     */
    public void setVitalite(String vitalite) {
        this.vitalite = vitalite;
    }

    /**
     * @return the densiteCouleur
     */
    public String getDensiteCouleur() {
        return densiteCouleur;
    }

    /**
     * @param densiteCouleur the densiteCouleur to set
     */
    public void setDensiteCouleur(String densiteCouleur) {
        this.densiteCouleur = densiteCouleur;
    }

    /**
     * @return the longueur
     */
    public String getLongueur() {
        return longueur;
    }

    /**
     * @param longueur the longueur to set
     */
    public void setLongueur(String longueur) {
        this.longueur = longueur;
    }

    /**
     * @return the degreForce
     */
    public String getDegreForce() {
        return degreForce;
    }

    /**
     * @param degreForce the degreForce to set
     */
    public void setDegreForce(String degreForce) {
        this.degreForce = degreForce;
    }

    /**
     * @return the SoliditeFourche
     */
    public String getSoliditeFourche() {
        return SoliditeFourche;
    }

    /**
     * @param SoliditeFourche the SoliditeFourche to set
     */
    public void setSoliditeFourche(String SoliditeFourche) {
        this.SoliditeFourche = SoliditeFourche;
    }

    /**
     * @return the PositionFourche
     */
    public String getPositionFourche() {
        return PositionFourche;
    }

    /**
     * @param PositionFourche the PositionFourche to set
     */
    public void setPositionFourche(String PositionFourche) {
        this.PositionFourche = PositionFourche;
    }

    /**
     * @return the muscle
     */
    public String getMuscle() {
        return muscle;
    }

    /**
     * @param muscle the muscle to set
     */
    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    /**
     * @return the equilibre
     */
    public String getEquilibre() {
        return equilibre;
    }

    /**
     * @param equilibre the equilibre to set
     */
    public void setEquilibre(String equilibre) {
        this.equilibre = equilibre;
    }

    /**
     * @return the dos
     */
    public String getDos() {
        return dos;
    }

    /**
     * @param dos the dos to set
     */
    public void setDos(String dos) {
        this.dos = dos;
    }

    /**
     * @return the plumeElevage
     */
    public String getPlumeElevage() {
        return plumeElevage;
    }

    /**
     * @param plumeElevage the plumeElevage to set
     */
    public void setPlumeElevage(String plumeElevage) {
        this.plumeElevage = plumeElevage;
    }

    /**
     * @return the Primaires
     */
    public String getPrimaires() {
        return Primaires;
    }

    /**
     * @param Primaires the Primaires to set
     */
    public void setPrimaires(String Primaires) {
        this.Primaires = Primaires;
    }

    /**
     * @return the plumage
     */
    public String getPlumage() {
        return plumage;
    }

    /**
     * @param plumage the plumage to set
     */
    public void setPlumage(String plumage) {
        this.plumage = plumage;
    }

    /**
     * @return the plume
     */
    public String getPlume() {
        return plume;
    }

    /**
     * @param plume the plume to set
     */
    public void setPlume(String plume) {
        this.plume = plume;
    }

    /**
     * @return the arriereAile
     */
    public String getArriereAile() {
        return arriereAile;
    }

    /**
     * @param arriereAile the arriereAile to set
     */
    public void setArriereAile(String arriereAile) {
        this.arriereAile = arriereAile;
    }

    /**
     * @return the souplesse
     */
    public String getSouplesse() {
        return souplesse;
    }

    /**
     * @param souplesse the souplesse to set
     */
    public void setSouplesse(String souplesse) {
        this.souplesse = souplesse;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

 
    /**
     * @return the pigeonId
     */
    public Long getPigeonId() {
        return pigeonId;
    }

    /**
     * @param pigeonId the pigeonId to set
     */
    public void setPigeonId(Long pigeonId) {
        this.pigeonId = pigeonId;
    }

    
   

    /**
     * @return the acteur
     */
    public Acteur getActeur() {
        return acteur;
    }

    /**
     * @param acteur the acteur to set
     */
    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    /**
     * @return the idPere
     */
    public Long getIdPere() {
        return idPere;
    }

    /**
     * @param idPere the idPere to set
     */
    public void setIdPere(Long idPere) {
        this.idPere = idPere;
    }

    /**
     * @return the idMere
     */
    public Long getIdMere() {
        return idMere;
    }

    /**
     * @param idMere the idMere to set
     */
    public void setIdMere(Long idMere) {
        this.idMere = idMere;
    }

  
    
}
