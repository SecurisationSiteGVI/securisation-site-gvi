/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public class SecteurServiceORMImpl implements SecteurServiceORM{
    @Override
    public void add(Secteur secteur) {
        Connexion.getPersistance();
        Connexion.em.persist(secteur);
        Connexion.disconect();
    }

    @Override
    public void remove(Secteur secteur) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(secteur));
        Connexion.disconect();
    }

    @Override
    public void update(Secteur secteur) {
        Connexion.getPersistance();
        Connexion.em.merge(secteur);
        Connexion.disconect();
    }

    @Override
    public List<Secteur> getAll() {
        Connexion.getPersistance();
        Query query =Connexion.em.createNamedQuery("SecteurGetAll");
        List<Secteur> secteurs = query.getResultList();
        Connexion.disconect();
        return secteurs;
    }

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
