/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import javax.management.InstanceNotFoundException;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.AttributionSecteurCamera;
import metier.entitys.Secteur;
import physique.data.AttributionSecteurCameraServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author damien
 */
public class AttributionSecteurCameraServiceImpl implements AttributionSecteurCameraService{

    private AttributionSecteurCameraServiceORM attributionSecteurCameraSrv = PhysiqueDataFactory.getAttributionSecteurCameraServiceORM();
    @Override
    public void add(AttributionSecteurCamera attributionSecteurCamera) throws Exception {
       if(attributionSecteurCamera!=null){
            if(attributionSecteurCamera instanceof AttributionSecteurCamera){
                attributionSecteurCameraSrv.add(attributionSecteurCamera);
            }else{
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(AttributionSecteurCamera attributionSecteurCamera) throws Exception {
       if(attributionSecteurCamera!=null){
            if(attributionSecteurCamera instanceof AttributionSecteurCamera){
                attributionSecteurCameraSrv.update(attributionSecteurCamera);
            }else{
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(AttributionSecteurCamera attributionSecteurCamera) throws Exception {
        if(attributionSecteurCamera!=null){
            if(attributionSecteurCamera instanceof AttributionSecteurCamera){
                attributionSecteurCameraSrv.remove(attributionSecteurCamera);
            }else{
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<AttributionSecteurCamera> getAll() throws Exception {
       return this.attributionSecteurCameraSrv.getAll();
    }

    @Override
    public AttributionSecteurCamera getBySecteur(Secteur secteur) {
         AttributionSecteurCamera attributionSecteurCameras =null;
        if(secteur!=null){
            if(secteur instanceof Secteur){
                attributionSecteurCameras=this.attributionSecteurCameraSrv.getBySecteur(secteur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return attributionSecteurCameras;
    }
    
}
