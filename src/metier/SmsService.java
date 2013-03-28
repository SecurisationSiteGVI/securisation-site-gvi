/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Sms;

/**
 *
 * @author saturne
 */
public interface SmsService {
    
    public void add(DetecteurIntrusion detecteurIntrusion) throws Exception;

    public void update(DetecteurIntrusion detecteurIntrusion) throws Exception;

    public void remove(DetecteurIntrusion detecteurIntrusion) throws Exception;

    public List<Sms> getAll() throws Exception;

    public Long count();

    public DetecteurIntrusion getById(Long id);
    
    public void startThread();
      
}
