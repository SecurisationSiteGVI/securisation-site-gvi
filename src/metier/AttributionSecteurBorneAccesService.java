/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.AttributionSecteurBorneAcces;

/**
 *
 * @author damien
 */
public interface AttributionSecteurBorneAccesService {
    public void add(AttributionSecteurBorneAcces attributionSecteurBorneAcces);
    public void update(AttributionSecteurBorneAcces attributionSecteurBorneAcces);
    public void remove(AttributionSecteurBorneAcces attributionSecteurBorneAcces);
    public List<AttributionSecteurBorneAcces> getAll();
}
