package metier;

import java.util.List;
import metier.entitys.Evenement;
import physique.data.EvenementServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 * @author 
 * @author 
 * @author 
 */

public class EvenementServiceImpl implements EvenementService{

    private EvenementServiceORM evenementSrv = PhysiqueDataFactory.getEvenementServiceORM();
    @Override
    public void add(Evenement evenement) throws Exception {
        if(evenement!=null){
            if(evenement instanceof Evenement){
                evenementSrv.add(evenement);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Evenement evenement) throws Exception {
        if(evenement!=null){
            if(evenement instanceof Evenement){
                evenementSrv.update(evenement);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Evenement evenement) throws Exception {
        if(evenement!=null){
            if(evenement instanceof Evenement){
                evenementSrv.remove(evenement);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Evenement> getAll() throws Exception {
        return this.evenementSrv.getAll();
    }

    @Override
    public List<Evenement> getAll(int debut, int nbResut) {
        return this.evenementSrv.getAll(debut, nbResut);
    }

    @Override
    public List<Evenement> getByPhoto() {
        return this.evenementSrv.getByPhoto();
    }

    @Override
    public List<Evenement> getByPhoto(int debut, int nbResut) {
        return this.evenementSrv.getByPhoto(debut, nbResut);
    }

    @Override
    public List<Evenement> getByAcces() {
        return this.evenementSrv.getByAcces();
    }

    @Override
    public List<Evenement> getByAcces(int debut, int nbResut) {
        return this.evenementSrv.getByAcces(debut, nbResut);
    }

    @Override
    public List<Evenement> getByIntrusion() {
        return this.evenementSrv.getByIntrusion();
    }

    @Override
    public List<Evenement> getByIntrusion(int debut, int nbResut) {
        return this.getByIntrusion(debut, nbResut);
    }
    
}
