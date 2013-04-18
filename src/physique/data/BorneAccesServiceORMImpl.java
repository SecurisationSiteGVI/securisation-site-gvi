/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import metier.entitys.BorneAcces;
import metier.entitys.Position;

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
    public List<BorneAcces> getAll(int index, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("borneAccesGetAll");
        query.setFirstResult(index);
        query.setMaxResults(nbResult);
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

    @Override
    public BorneAcces getByNom(String nom) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("BorneAccesGetByNom");
        query.setParameter("nom", nom);
        BorneAcces i = null;
        try {
            i = (BorneAcces) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Il n'y a pas de lecteur avec le nom : " + nom + " dans la base.");
        }
        Connexion.disconect();
        return i;
    }
      @Override
    public List<BorneAcces> getByPosition(Position position) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("BorneAccesByPosition");
        query.setParameter("id", position.getId());
        List<BorneAcces> borneAcceses = query.getResultList();
        Connexion.disconect();
        return borneAcceses;
    }
}
