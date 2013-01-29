/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author damien
 */
@Entity
@NamedQueries({//
    @NamedQuery(name = "UtilisateurGetAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "UtilisateurGetByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "UtilisateurGetByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "UtilisateurGetByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville"),
    @NamedQuery(name = "UtilisateurGetByAdresse", query = "SELECT u FROM Utilisateur u WHERE u.adresse = :adresse"),
    @NamedQuery(name = "UtilisateurGetByCodePostale", query = "SELECT u FROM Utilisateur u WHERE u.codePostale = :codePostale"),
    @NamedQuery(name = "UtilisateurGetByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
       @NamedQuery(name = "UtilisateurCount", query = "SELECT COUNT(u) FROM Utilisateur u")
})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private String ville;
    private int codePostale;
    private String adresse;
    private String telephonePortable;
    private String telephoneFixe;
    @Column(nullable = false)
    private boolean homme;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeNaissance;
    private String email;
    @Transient
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public boolean isHomme() {
        return homme;
    }

    public void setHomme(boolean homme) {
        this.homme = homme;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        int agen = 0;
        if (dateDeNaissance != null) {
            int yearH = dateDeNaissance.getYear();
            int yearN = new Date().getYear();
            agen =  yearN-yearH;
        }
        return agen;
    }

    public Number getTelephonePortable() {
        return telephonePortable;
    }

    public void setTelephonePortable(Number telephonePortable) {
        this.telephonePortable = telephonePortable;
    }

    public Number getTelephoneFixe() {
        return telephoneFixe;
    }

    public void setTelephoneFixe(Number telephoneFixe) {
        this.telephoneFixe = telephoneFixe;
    }
}
