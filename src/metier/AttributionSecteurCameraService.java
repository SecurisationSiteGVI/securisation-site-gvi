/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.AttributionSecteurCamera;


/**
 *
 * @author BlondelleMarvin
 */
public interface AttributionSecteurCameraService {
    
    public void add(AttributionSecteurCamera attributionSecteurCamera) throws Exception;
    public void update(AttributionSecteurCamera attributionSecteurCamera) throws Exception;
    public void remove(AttributionSecteurCamera attributionSecteurCamera) throws Exception;
    public List<AttributionSecteurCamera> getAll() throws Exception;
    
    
    
}
