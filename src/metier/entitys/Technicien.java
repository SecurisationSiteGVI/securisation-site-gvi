/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damien
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "TechnicienGetByLogin", query = "SELECT u FROM Technicien u WHERE u.login = :login"),
    @NamedQuery(name = "TechnicienCount", query = "SELECT COUNT(t) FROM Technicien t")
})
@XmlRootElement
public class Technicien extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technicien)) {
            return false;
        }
        Technicien other = (Technicien) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encode(boolean encode) {
        if (encode) {
            password = this.codeMD5(password);
        }
    }

    private String codeMD5(String msg) {
        String code = "";
        byte[] b = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            b = md.digest(msg.getBytes());
            for (int i = 0; i < b.length; i++) {
                int x = b[i];
                if (x < 0) {
                    x += 256;
                }

                code += Integer.toHexString(x);
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return code;
    }
}
