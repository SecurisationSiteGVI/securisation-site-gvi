/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Position;

/**
 *
 * @author damien
 */
public class PositionServiceORMImpl implements PositionServiceORM{

    @Override
    public void add(Position position) {
        Connexion.getPersistance();
        Connexion.em.persist(position);
        Connexion.disconect();
    }

    @Override
    public void remove(Position position) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(position));
        Connexion.disconect();
    }

    @Override
    public void update(Position position) {
        Connexion.getPersistance();
        Connexion.em.merge(position);
        Connexion.disconect();
    }

    @Override
    public List<Position> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("PositionGetAll");
        List<Position> positions = query.getResultList();
        Connexion.disconect();
        return positions;
    }

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
