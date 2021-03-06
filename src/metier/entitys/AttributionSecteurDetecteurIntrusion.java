/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damien
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "AttributionSecteurDetecteurIntrusionCount", query = "SELECT COUNT(a) FROM AttributionSecteurDetecteurIntrusion a"),
    @NamedQuery(name = "AttributionSecteurDetecteurIntrusionGetAll", query = "SELECT a FROM AttributionSecteurDetecteurIntrusion a"),
    @NamedQuery(name = "AttributionSecteurDetecteurIntrusionGetBySecteur", query = "SELECT a FROM AttributionSecteurDetecteurIntrusion a WHERE a.secteur.id = :id")
})
@XmlRootElement
public class AttributionSecteurDetecteurIntrusion implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne()
    @JoinColumn(nullable = false)
    private Secteur secteur;
    @OneToMany()
    private List<DetecteurIntrusion> detecteurIntrusions;

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
        if (!(object instanceof AttributionSecteurDetecteurIntrusion)) {
            return false;
        }
        AttributionSecteurDetecteurIntrusion other = (AttributionSecteurDetecteurIntrusion) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Attribution secteur " + secteur;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<DetecteurIntrusion> getDetecteurIntrusions() {
        return detecteurIntrusions;
    }

    public void setDetecteurIntrusions(List<DetecteurIntrusion> detecteurIntrusions) {
        this.detecteurIntrusions = detecteurIntrusions;
    }
}
