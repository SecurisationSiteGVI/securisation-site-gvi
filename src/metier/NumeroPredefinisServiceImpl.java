/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
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
    public void ajouterUnNumero(String numero) throws Exception{
        List<NumeroPredefinis> numeroPredefinis = this.getAll();
        if(numeroPredefinis.isEmpty()){
            NumeroPredefinis numeroPredefini = new NumeroPredefinis();
            List<String> strings = new ArrayList<String>();
            strings.add(numero);
            numeroPredefini.setNumeros(strings);
            this.add(numeroPredefini);
        }else{
            List<String> strings = numeroPredefinis.get(0).getNumeros();
            strings.add(numero);
            numeroPredefinis.get(0).setNumeros(strings);
            this.update(numeroPredefinis.get(0));
        }
    }
    @Override
    public void supprimerUnNumero(String numero) throws Exception{
        List<NumeroPredefinis> numeroPredefinis = this.getAll();
        NumeroPredefinis numeroPredefini =numeroPredefinis.get(0);
        boolean start = true;
        boolean update = false;
        int i= 0;
        while(start){
            if(numeroPredefini.getNumeros().get(i).equals(numero)){
                numeroPredefini.getNumeros().remove(i);
                start = false;
                update = true;
            }
            i++;
        }
        if(update == true ){
            this.update(numeroPredefini);
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
