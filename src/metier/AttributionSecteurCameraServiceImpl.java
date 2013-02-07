/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceNotFoundException;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.AttributionSecteurCamera;
import metier.entitys.Camera;
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

    @Override
    public void attribuerCamera(Secteur secteur, Camera camera) {
         List<AttributionSecteurCamera> attributionSecteurCamera = null;
        try {
            attributionSecteurCamera = this.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean start = true;
        boolean secteurTrouve = false;
        int i = 0;
        while (start) {
            if (!attributionSecteurCamera.isEmpty()) {
                if (i < attributionSecteurCamera.size()) {
                    if (attributionSecteurCamera.get(i).getSecteur().getId().equals(secteur.getId())) {
                        AttributionSecteurCamera asc = attributionSecteurCamera.get(i);
                        asc.getCameras().add(camera);
                        try {
                            this.update(asc);
                        } catch (Exception ex) {
                            Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        secteurTrouve = true;
                        start = false;
                    }
                }else{
                    start=false;
                }
            } else {
                start = false;
            }

            i++;
        }
        if (secteurTrouve == false) {
            AttributionSecteurCamera asc = new AttributionSecteurCamera();
            List<Camera> cameras = new ArrayList<Camera>();
            cameras.add(camera);
            asc.setCameras(cameras);
            asc.setSecteur(secteur);
            try {
                this.add(asc);
            } catch (Exception ex) {
                Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void desattribuerCamera(Secteur secteur, Camera camera) {
        List<AttributionSecteurCamera> attributionSecteurCamera=null;
        try {
            attributionSecteurCamera = this.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean start = true;
        int i = 0;
        while (start) {
            if (attributionSecteurCamera.get(i).getSecteur().getId().equals(secteur.getId())) {
                AttributionSecteurCamera asc = attributionSecteurCamera.get(i);
                for (int j = 0; j < asc.getCameras().size(); j++) {
                    if (asc.getCameras().get(j).getId().equals(camera.getId())) {
                        asc.getCameras().remove(j);
                        start = false;
                    }
                }
                try {
                    this.update(asc);
                } catch (Exception ex) {
                    Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            i++;
        }
    }
    
}
