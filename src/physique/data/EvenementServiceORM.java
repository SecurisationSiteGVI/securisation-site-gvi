/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.Evenement;

/**
 *
 * @author damien
 */
public interface EvenementServiceORM {
        public void add(Evenement evenement);
    public void remove(Evenement evenement);
    public void update(Evenement evenement);
    public List<Evenement> getAll();
    public List<Evenement> getAll(int debut, int nbResut);
    public List<Evenement> getByPhoto();
    public List<Evenement> getByPhoto(int debut, int nbResut);
    public List<Evenement> getByAcces();
    public List<Evenement> getByAcces(int debut, int nbResut);
    public List<Evenement> getByIntrusion();
    public List<Evenement> getByIntrusion(int debut, int nbResut);
    
    public Long count();
}
