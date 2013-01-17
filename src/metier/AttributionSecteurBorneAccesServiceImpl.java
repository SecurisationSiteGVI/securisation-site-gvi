/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.AttributionSecteurBorneAcces;
import physique.data.AttributionSecteurBorneAccesServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author damien
 */
public class AttributionSecteurBorneAccesServiceImpl implements AttributionSecteurBorneAccesService{

    private AttributionSecteurBorneAccesServiceORM attributionSecteurBorneAccesSrv = PhysiqueDataFactory.getAttributionSecteurBorneAccesServiceORM();
    @Override
    public void add(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
        if(attributionSecteurBorneAcces!=null){
            if(attributionSecteurBorneAcces instanceof AttributionSecteurBorneAcces){
                attributionSecteurBorneAccesSrv.add(attributionSecteurBorneAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
        if(attributionSecteurBorneAcces!=null){
            if(attributionSecteurBorneAcces instanceof AttributionSecteurBorneAcces){
                attributionSecteurBorneAccesSrv.update(attributionSecteurBorneAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
       if(attributionSecteurBorneAcces!=null){
            if(attributionSecteurBorneAcces instanceof AttributionSecteurBorneAcces){
                attributionSecteurBorneAccesSrv.remove(attributionSecteurBorneAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<AttributionSecteurBorneAcces> getAll() {
        return this.attributionSecteurBorneAccesSrv.getAll();
    }
    
}
