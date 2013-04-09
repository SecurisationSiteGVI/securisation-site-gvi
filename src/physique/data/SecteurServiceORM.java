/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public interface SecteurServiceORM {

    public void add(Secteur secteur);

    public void remove(Secteur secteur);

    public void update(Secteur secteur);

    public List<Secteur> getAll();

    public List<Secteur> getAll(int index, int nbResult);
    
    public Long count();

    public Secteur getById(Long id);
}
