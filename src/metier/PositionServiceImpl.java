package metier;

import java.util.List;
import metier.entitys.Position;
import physique.data.PhysiqueDataFactory;
import physique.data.PositionServiceORM;

/**
 * @author 
 * @author
 * @author
 */

public class PositionServiceImpl implements PositionService{

    private PositionServiceORM positionSrv = PhysiqueDataFactory.getPositionServiceORM();
    @Override
    public void add(Position position) throws Exception {
        if(position!=null){
            if(position instanceof Position){
                positionSrv.add(position);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Position position) throws Exception {
        if(position!=null){
            if(position instanceof Position){
                positionSrv.update(position);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Position position) throws Exception {
        if(position!=null){
            if(position instanceof Position){
                positionSrv.remove(position);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Position> getAll() throws Exception {
       return this.positionSrv.getAll();
    }
}
