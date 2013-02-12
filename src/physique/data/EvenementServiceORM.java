/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.Acces;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Evenement;
import metier.entitys.Intrusion;
import metier.entitys.Photo;

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
    public List<Photo> getByPhoto();
    public List<Photo> getByPhoto(int debut, int nbResut);
    public List<Acces> getByAcces();
    public List<Acces> getByAcces(int debut, int nbResut);
    public List<Intrusion> getByIntrusion();
    public List<Intrusion> getByIntrusion(int debut, int nbResut);
    
    public Long count();
}
