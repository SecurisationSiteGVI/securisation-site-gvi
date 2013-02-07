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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author damien
 */
@Entity
@NamedQueries({
   @NamedQuery(name="NumeroPredefinisCount",query="SELECT COUNT(n) FROM NumeroPredefinis n"),
   @NamedQuery(name="NumeroPredefinisGetAll",query="SELECT n FROM NumeroPredefinis n")
})

public class NumeroPredefinis implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private List<String> numeros;
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
        if (!(object instanceof NumeroPredefinis)) {
            return false;
        }
        NumeroPredefinis other = (NumeroPredefinis) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "liste de numeros";
    }

    public List<String> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<String> numeros) {
        this.numeros = numeros;
    }

    
}
