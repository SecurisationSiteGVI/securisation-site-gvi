/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public interface AttributionSecteurBorneAccesServiceORM {

    public void add(AttributionSecteurBorneAcces attributionSecteurBorneAcces);

    public void remove(AttributionSecteurBorneAcces attributionSecteurBorneAcces);

    public void update(AttributionSecteurBorneAcces attributionSecteurBorneAcces);

    public Long count();

    public List<AttributionSecteurBorneAcces> getAll();
    public AttributionSecteurBorneAcces getBySecteur(Secteur secteur);
}
