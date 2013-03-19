/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damien
 */
@Entity
@NamedQueries({
    @NamedQuery(name="AuthorisationAccesCount",query="SELECT COUNT(a) FROM AuthorisationAcces a"),
    @NamedQuery(name="AuthorisationAccesGetAll",query="SELECT a FROM AuthorisationAcces a"),
    @NamedQuery(name="AuthorisationAccesGetByUtilisateur",query="SELECT a FROM AuthorisationAcces a WHERE a.utilisateur.id = :id")
})
@XmlRootElement
public class AuthorisationAcces implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureOuverture;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureFermeture;
    @OneToOne()
    @JoinColumn(nullable=false)
    private Utilisateur utilisateur;
    @OneToMany()
    private List<Secteur> secteurs;
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
        if (!(object instanceof AuthorisationAcces)) {
            return false;
        }
        AuthorisationAcces other = (AuthorisationAcces) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.entitys.AuthorisationAcces7[ id=" + getId() + " ]";
    }

    public Date getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(Date heureOuverture) {
        this.heureOuverture = heureOuverture;
    }

    public Date getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(Date heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }
    
}
