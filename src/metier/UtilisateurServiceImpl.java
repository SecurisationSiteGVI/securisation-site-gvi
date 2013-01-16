/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.Utilisateur;
import physique.data.PhysiqueDataFactory;
import physique.data.UtilisateurServiceORM;

/**
 *
 * @author damien
 */
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurServiceORM utilisateurSrv = PhysiqueDataFactory.getUtilisateurServiceORM();
    @Override
    public void add(Utilisateur utilisateur) {
        if(utilisateur!=null){
            if(utilisateur instanceof Utilisateur){
                utilisateurSrv.add(utilisateur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Utilisateur utilisateur) {
        if(utilisateur!=null){
            if(utilisateur instanceof Utilisateur){
                utilisateurSrv.remove(utilisateur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Utilisateur utilisateur) {
        if(utilisateur!=null){
            if(utilisateur instanceof Utilisateur){
                utilisateurSrv.update(utilisateur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Utilisateur> getAll() {
        return utilisateurSrv.getAll();
    }
}
