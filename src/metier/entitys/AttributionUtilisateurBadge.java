/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damien
 */
@Entity
@NamedQueries({
    @NamedQuery(name="AttributionUtilisateurBadgeCount",query="SELECT COUNT(a) FROM AttributionUtilisateurBadge a"),
    @NamedQuery(name="AttributionUtilisateurBadgeGetAll",query="SELECT a FROM AttributionUtilisateurBadge a"),
    @NamedQuery(name="AttributionUtilisateurBadgeGetBadgesNotAssign",query="SELECT b FROM Badge b WHERE b.id NOT in (SELECT a.badge.id FROM AttributionUtilisateurBadge a )"),
    @NamedQuery(name="AttributionUtilisateurBadgeGetUtilisateurNotAssign",query="SELECT u FROM Utilisateur u WHERE u.id NOT in (SELECT a.utilisateur.id FROM AttributionUtilisateurBadge a )"),
    @NamedQuery(name="AttributionUtilisateurBadgeGetUtilisateurNotAssignByNom",query="SELECT u FROM Utilisateur u WHERE u.nom = :nom  AND u.id NOT in (SELECT a.utilisateur.id FROM AttributionUtilisateurBadge a )"),
    @NamedQuery(name="AttributionUtilisateurBadgegetByUtilisateur",query="SELECT a FROM AttributionUtilisateurBadge a WHERE a.utilisateur.id = :id"),
    @NamedQuery(name="AttributionUtilisateurBadgeGetBadgesNotAssignByNumero",query="SELECT b FROM Badge b WHERE b.id NOT in (SELECT a.badge.id FROM AttributionUtilisateurBadge a ) AND b.numero = :numero"),
    @NamedQuery(name = "AttributionUtilisateurBadgeGetByBadge",query = "SELECT a FROM AttributionUtilisateurBadge a WHERE a.badge = :badge")
})
@XmlRootElement
public class AttributionUtilisateurBadge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade= CascadeType.REMOVE)
    @JoinColumn(nullable=false)
    private Utilisateur utilisateur;
    @OneToOne(cascade= CascadeType.REMOVE)
    private Badge badge;
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
        if (!(object instanceof AttributionUtilisateurBadge)) {
            return false;
        }
        AttributionUtilisateurBadge other = (AttributionUtilisateurBadge) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getUtilisateur() +" "+getBadge();
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
    
}
