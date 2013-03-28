/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.BorneAcces;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public interface AttributionSecteurBorneAccesService {

    public void add(AttributionSecteurBorneAcces attributionSecteurBorneAcces);

    public void update(AttributionSecteurBorneAcces attributionSecteurBorneAcces);

    public void remove(AttributionSecteurBorneAcces attributionSecteurBorneAcces);

    public List<AttributionSecteurBorneAcces> getAll();

    public void attribuerBorneAcces(Secteur secteur, BorneAcces borneAcces);

    public void desattribuerBorneAcces(Secteur secteur, BorneAcces borneAcces);

    public AttributionSecteurBorneAcces getBySecteur(Secteur secteur);

    public Long count();

    public AttributionSecteurBorneAcces getById(Long id);

    public List<AttributionSecteurBorneAcces> getByBorneAcces(BorneAcces borneAcces);
}
