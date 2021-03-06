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
    @NamedQuery(name = "borneAccesCount", query = "SELECT COUNT(b) FROM BorneAcces b"),
    @NamedQuery(name = "borneAccesGetAll", query = "SELECT b FROM BorneAcces b"),
    @NamedQuery(name = "BorneAccesGetByNom", query = "SELECT b FROM BorneAcces b WHERE b.nom = :nom"),
    @NamedQuery(name = "BorneAccesByPosition", query = "SELECT b FROM BorneAcces b WHERE b.position.id = :id")
})
@XmlRootElement
public class BorneAcces implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne()
    private Position position;
    private String nom;
    @Column(nullable = false)
    private Boolean entrer;

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
        if (!(object instanceof BorneAcces)) {
            return false;
        }
        BorneAcces other = (BorneAcces) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        String entr = "sorie";
        if (this.entrer) {
            entr = "entré";
        }
        return nom + " " + entr;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getEntrer() {
        return entrer;
    }

    public void setEntrer(Boolean entrer) {
        this.entrer = entrer;
    }
}
