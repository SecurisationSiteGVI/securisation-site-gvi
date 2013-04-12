/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.BorneAcces;

/**
 *
 * @author damien
 */
public interface BorneAccesServiceORM {

    public void add(BorneAcces borneAcces);

    public void remove(BorneAcces borneAcces);

    public void update(BorneAcces borneAcces);

    public Long count();

    public List<BorneAcces> getAll();

    public BorneAcces getById(Long id);

    public BorneAcces getByNom(String nom);
    
     public List<BorneAcces> getAll(int index, int nbResult);
}
