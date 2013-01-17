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
    
}
