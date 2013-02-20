/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.DetecteurIntrusion;
import physique.data.DetecteurIntrusionServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author damien
 */
public class DetecteurIntrusionServiceImpl implements DetecteurIntrusionService{

    private DetecteurIntrusionServiceORM detecteurIntrusionSrv = PhysiqueDataFactory.getDetecteurIntrusionServiceORM();
    @Override
    public void add(DetecteurIntrusion detecteurIntrusion) throws Exception {
        if(detecteurIntrusion!=null){
            if(detecteurIntrusion instanceof DetecteurIntrusion){
                detecteurIntrusionSrv.add(detecteurIntrusion);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(DetecteurIntrusion detecteurIntrusion) throws Exception {
       if(detecteurIntrusion!=null){
            if(detecteurIntrusion instanceof DetecteurIntrusion){
                detecteurIntrusionSrv.update(detecteurIntrusion);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(DetecteurIntrusion detecteurIntrusion) throws Exception {
        if(detecteurIntrusion!=null){
            if(detecteurIntrusion instanceof DetecteurIntrusion){
                detecteurIntrusionSrv.remove(detecteurIntrusion);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<DetecteurIntrusion> getAll() throws Exception {
        return this.detecteurIntrusionSrv.getAll();
    }

    @Override
    public Long count() {
        return this.detecteurIntrusionSrv.count();
    }

    @Override
    public DetecteurIntrusion getById(Long id) {
        DetecteurIntrusion detecteurIntrusion = null;
        if (id != null) {
            detecteurIntrusion = this.detecteurIntrusionSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return detecteurIntrusion;
    }
    
}
