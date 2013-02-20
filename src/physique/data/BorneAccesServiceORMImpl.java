/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.BorneAcces;

/**
 *
 * @author damien
 */
public class BorneAccesServiceORMImpl implements BorneAccesServiceORM {

    @Override
    public void add(BorneAcces borneAcces) {
        Connexion.getPersistance();
        Connexion.em.persist(borneAcces);
        Connexion.disconect();
    }

    @Override
    public void remove(BorneAcces borneAcces) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(borneAcces));
        Connexion.disconect();
    }

    @Override
    public void update(BorneAcces borneAcces) {
        Connexion.getPersistance();
        Connexion.em.merge(borneAcces);
        Connexion.disconect();
    }

    @Override
    public List<BorneAcces> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("borneAccesGetAll");
        List<BorneAcces> borneAcceses = query.getResultList();
        Connexion.disconect();
        return borneAcceses;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("borneAccesCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public BorneAcces getById(Long id) {
        Connexion.getPersistance();
        BorneAcces borneAcces = Connexion.em.find(BorneAcces.class, id);
        Connexion.disconect();
        return borneAcces;
    }
}
