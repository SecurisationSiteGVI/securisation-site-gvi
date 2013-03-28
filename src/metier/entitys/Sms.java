/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entitys;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author saturne
 */
@Entity
@NamedQueries({
    @NamedQuery(name="SmsCount",query="SELECT COUNT(s) FROM Sms s"),
    @NamedQuery(name="SmsGetAll",query="SELECT s FROM Sms s")
})
public class Sms {
    
}
