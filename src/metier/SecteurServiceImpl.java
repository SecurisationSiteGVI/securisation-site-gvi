package metier;

import java.util.List;
import metier.entitys.Secteur;
import physique.data.PhysiqueDataFactory;
import physique.data.SecteurServiceORM;

/**
 * @author 
 * @author
 * @author
 */

public class SecteurServiceImpl implements SecteurService {    
    
    private SecteurServiceORM secteurSrv = PhysiqueDataFactory.getSecteurServiceORM();
    
    @Override
    public void add(Secteur secteur) throws Exception {
        if(secteur!=null){
            if(secteur instanceof Secteur){
                secteurSrv.add(secteur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Secteur secteur) throws Exception {
        if(secteur!=null){
            if(secteur instanceof Secteur){
                secteurSrv.update(secteur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Secteur secteur) throws Exception {
        if(secteur!=null){
            if(secteur instanceof Secteur){
                secteurSrv.remove(secteur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Secteur> getAll() throws Exception {
        return this.secteurSrv.getAll();
    }

    @Override
    public Long count() {
        return this.secteurSrv.count();
    }
}
