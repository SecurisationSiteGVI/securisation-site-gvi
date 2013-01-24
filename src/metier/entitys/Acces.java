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
    @NamedQuery(name="AccesCount",query="SELECT COUNT(a) FROM Acces a"),
    @NamedQuery(name="AccesGetAll",query="SELECT a FROM Acces a")
})
public class Acces extends Evenement implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(nullable=false)
    private Utilisateur utilisateur;
    @Column(nullable=false)
    private Boolean passage;
    @OneToOne
    @JoinColumn(nullable=false)
    private BorneAcces borneAcces;
    
  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acces)) {
            return false;
        }
        Acces other = (Acces) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passege de l'utilisateur : "+utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Boolean getPassage() {
        return passage;
    }

    public void setPassage(Boolean passage) {
        this.passage = passage;
    }

    public BorneAcces getBorneAcces() {
        return borneAcces;
    }

    public void setBorneAcces(BorneAcces borneAcces) {
        this.borneAcces = borneAcces;
    }
    
}
