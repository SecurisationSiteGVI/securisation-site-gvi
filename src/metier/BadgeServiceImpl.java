package metier;

import java.util.List;
import metier.entitys.Badge;
import physique.data.BadgeServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 * @author 
 */
public class BadgeServiceImpl implements BadgeService {
    private BadgeServiceORM badgeSrv = PhysiqueDataFactory.getBadgeServiceORM();
    @Override
    public void add(Badge badge) throws Exception {
      if(badge!=null){
            if(badge instanceof Badge){
                badgeSrv.add(badge);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Badge badge) throws Exception {
        if(badge!=null){
            if(badge instanceof Badge){
                badgeSrv.update(badge);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Badge badge) throws Exception {
        if(badge!=null){
            if(badge instanceof Badge){
                badgeSrv.remove(badge);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Badge> getAll() throws Exception {
        return this.badgeSrv.getAll();
    }
    
    @Override
    public List<Badge> getAll(int debut, int nbResult) throws Exception {
        return this.badgeSrv.getAll(debut, nbResult);
    }

    @Override
    public Long count() {
        return this.badgeSrv.count();
    }

}
