/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name="IntrusionGetAll",query="SELECT i FROM Intrusion i")
})
@XmlRootElement
public class Intrusion extends Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade= CascadeType.REMOVE)
    private DetecteurIntrusion detecteurIntrusion;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intrusion)) {
            return false;
        }
        Intrusion other = (Intrusion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "evenement sur : "+detecteurIntrusion;
    }

    public DetecteurIntrusion getDetecteurIntrusion() {
        return detecteurIntrusion;
    }

    public void setDetecteurIntrusion(DetecteurIntrusion detecteurIntrusion) {
        this.detecteurIntrusion = detecteurIntrusion;
    }
    
}
