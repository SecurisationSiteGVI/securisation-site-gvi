package metier;

import java.util.List;
import metier.entitys.BorneAcces;
import physique.data.BorneAccesServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author ragotalexis
 */

public class BorneAccesServiceImpl implements BorneAccesService{
    private BorneAccesServiceORM borneAccesSrv = PhysiqueDataFactory.getBorneAccesServiceORM();
    @Override
    public void add(BorneAcces borneAcces) throws Exception {
         if(borneAcces!=null){
            if(borneAcces instanceof BorneAcces){
                borneAccesSrv.add(borneAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(BorneAcces borneAcces) throws Exception {
        if(borneAcces!=null){
            if(borneAcces instanceof BorneAcces){
                borneAccesSrv.update(borneAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(BorneAcces borneAcces) throws Exception {
       if(borneAcces!=null){
            if(borneAcces instanceof BorneAcces){
                borneAccesSrv.remove(borneAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<BorneAcces> getAll() throws Exception {
        return this.borneAccesSrv.getAll();
    }

}
