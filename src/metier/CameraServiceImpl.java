package metier;

import java.util.Date;
import java.util.List;
import metier.entitys.Camera;
import metier.entitys.Photo;
import physique.data.CameraServiceORM;
import physique.data.EvenementServiceORM;
import physique.data.PhysiqueDataFactory;



/**
 *
 * @author damien
 * @author BlondelleMarvin
 * 
 */
public class CameraServiceImpl implements CameraService{

    private CameraServiceORM cameraSrv = PhysiqueDataFactory.getCameraServiceORM();
    private EvenementService evenementSrv= MetierFactory.getEvenementService();
    
    @Override
    public void add(Camera camera) throws Exception {
        if(camera!=null){
            if(camera instanceof Camera){
                cameraSrv.add(camera);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Camera camera) throws Exception {
        if(camera!=null){
            if(camera instanceof Camera){
                cameraSrv.update(camera);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Camera camera) throws Exception {
        if(camera!=null){
            if(camera instanceof Camera){
                cameraSrv.remove(camera);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Camera> getAll() throws Exception {
        return this.cameraSrv.getAll();
    }

    @Override
    public boolean piloterCameraGauche() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean piloterCameraDroite() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean piloterCameraHaut() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean piloterCameraBas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean piloterAutomatiquement() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean zoom() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean luminositer() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contraste() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean resolution() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }



    @Override
    public boolean detectionMouvement() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int[] choixCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean sensPriseDeVueHorrizontal() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean sensPriseDeVueVertical() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visionModeUneCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visionModeQuatreCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visionModeNeufCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int connectionCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void verifierConnectionCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void enregistrerPhoto() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public byte[] prendrePhoto(Camera camera) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long count() {
        return this.cameraSrv.count();
    }

    @Override
    public Camera getById(Long id) {
        Camera camera = null;
        if (id != null) {
            camera = this.cameraSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return camera;
    }


}
