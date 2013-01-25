/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

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
    @NamedQuery(name="AttributionUtilisateurBadgeGetUtilisateurNotAssignByNom",query="SELECT u FROM Utilisateur u WHERE u.id NOT in (SELECT a.utilisateur.id FROM AttributionUtilisateurBadge a ) AND u.nom = :nom")
})
public class AttributionUtilisateurBadge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(nullable=false)
    private Utilisateur utilisateur;
    @OneToOne
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributionUtilisateurBadge)) {
            return false;
        }
        AttributionUtilisateurBadge other = (AttributionUtilisateurBadge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return utilisateur +" "+badge;
    }
    
}
