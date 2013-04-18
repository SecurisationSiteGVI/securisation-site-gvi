package metier;

import java.util.List;
import metier.entitys.BorneAcces;
import metier.entitys.Camera;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Position;
import physique.data.BorneAccesServiceORM;
import physique.data.CameraServiceORM;
import physique.data.DetecteurIntrusionServiceORM;
import physique.data.PhysiqueDataFactory;
import physique.data.PositionServiceORM;

/**
 * @author damien
 * @author
 * @author
 */
public class PositionServiceImpl implements PositionService {

    private PositionServiceORM positionSrv = PhysiqueDataFactory.getPositionServiceORM();

    @Override
    public void add(Position position) throws Exception {
        if (position != null) {
            if (position instanceof Position) {
                positionSrv.add(position);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Position position) throws Exception {
        if (position != null) {
            if (position instanceof Position) {
                positionSrv.update(position);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Position position) throws Exception {
        if (position != null) {
            if (position instanceof Position) {
                BorneAccesServiceORM borneAccesSrv = PhysiqueDataFactory.getBorneAccesServiceORM();
                List<BorneAcces> byPosition = borneAccesSrv.getByPosition(position);
                if (!byPosition.isEmpty()) {
                    for (int i = 0; i < byPosition.size(); i++) {
                        byPosition.get(i).setPosition(null);
                        borneAccesSrv.update(byPosition.get(i));
                    }
                }
                
                CameraServiceORM cameraSrv = PhysiqueDataFactory.getCameraServiceORM();
                List<Camera> byPositionc = cameraSrv.getByPosition(position);
                if (!byPositionc.isEmpty()) {
                    for (int i = 0; i < byPositionc.size(); i++) {
                        byPositionc.get(i).setPosition(null);
                        cameraSrv.update(byPositionc.get(i));
                    }
                }
                
                DetecteurIntrusionServiceORM detecteurIntrusionSrv = PhysiqueDataFactory.getDetecteurIntrusionServiceORM();
                List<DetecteurIntrusion> byPositiond = detecteurIntrusionSrv.getByPosition(position);
                if (!byPositiond.isEmpty()) {
                    for (int i = 0; i < byPositiond.size(); i++) {
                        byPositiond.get(i).setPosition(null);
                        detecteurIntrusionSrv.update(byPositiond.get(i));
                    }
                }
                
                positionSrv.remove(position);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Position> getAll() throws Exception {
        return this.positionSrv.getAll();
    }

    @Override
    public Long count() {
        return this.positionSrv.count();
    }

    @Override
    public Position getById(Long id) {
        Position position = null;
        if (id != null) {
            position = this.positionSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return position;
    }

    @Override
    public List<Position> getAll(int index, int nbResult) {
        return this.positionSrv.getAll(index, nbResult);
    }
}
