package metier;

import java.util.List;
import metier.entitys.Camera;
import physique.data.CameraServiceORM;
import physique.data.PhysiqueDataFactory;



/**
 *
 * @author damien
 * @author BlondelleMarvin
 * 
 */
public class CameraServiceImpl implements CameraService{

    private CameraServiceORM cameraSrv = PhysiqueDataFactory.getCameraServiceORM();
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


}
