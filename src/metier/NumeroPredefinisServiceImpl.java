/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.NumeroPredefinis;
import physique.data.NumeroPredefinisServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author damien
 */
public class NumeroPredefinisServiceImpl implements NumeroPredefinisService{

    private NumeroPredefinisServiceORM numeroPredefinisSrv= PhysiqueDataFactory.getNumeroPredefinisServiceORM();
    @Override
    public void add(NumeroPredefinis numeroPredefinis) throws Exception {
        if(numeroPredefinis!=null){
            if(numeroPredefinis instanceof NumeroPredefinis){
                numeroPredefinisSrv.add(numeroPredefinis);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(NumeroPredefinis numeroPredefinis) throws Exception {
        if(numeroPredefinis!=null){
            if(numeroPredefinis instanceof NumeroPredefinis){
                numeroPredefinisSrv.update(numeroPredefinis);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(NumeroPredefinis numeroPredefinis) throws Exception {
        if(numeroPredefinis!=null){
            if(numeroPredefinis instanceof NumeroPredefinis){
                numeroPredefinisSrv.remove(numeroPredefinis);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<NumeroPredefinis> getAll() throws Exception {
        return this.numeroPredefinisSrv.getAll();
    }
    
}
