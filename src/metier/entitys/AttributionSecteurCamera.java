/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import java.util.List;
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
    @NamedQuery(name="AttributionSecteurCameraCount",query="SELECT COUNT(a) FROM AttributionSecteurCamera a"),
    @NamedQuery(name="AttributionSecteurCameraGetAll",query="SELECT a FROM AttributionSecteurCamera a"),
    @NamedQuery(name="AttributionSecteurCameraGetBySecteur",query="SELECT a FROM AttributionSecteurCamera a WHERE a.secteur.id = :id")
})
@XmlRootElement
public class AttributionSecteurCamera implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(nullable=false)
    @OneToOne
    private Secteur secteur;
    @OneToMany
    private List<Camera> cameras;
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
        if (!(object instanceof AttributionSecteurCamera)) {
            return false;
        }
        AttributionSecteurCamera other = (AttributionSecteurCamera) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AttributionSecteur sur secteur :"+getSecteur();
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }
    
}
