/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.List;
import metier.entitys.Administrateur;
import metier.entitys.Technicien;
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
    /*
     * @return : retourne false si le login n'est pas déjà utilisé. retourne true sinon.
     */
    @Override
    public boolean loginIsUtilise(String login) {
        boolean retour=true;
        List<Technicien> utilisateurs = this.getByLogin(login);
        if (utilisateurs.isEmpty()) {
            System.out.println("passage");
            retour = false;
        } 
        return retour;
    }

    @Override
    public Technicien verifificationConnexion(String login, String password) {
        boolean retour=false;
        List<Technicien> utilisateurs = this.getByLogin(login);
        Technicien p=null;
        for(int i=0; i<utilisateurs.size();i++){
            if(login.equals(utilisateurs.get(i).getLogin())){
                p=utilisateurs.get(i);
                Technicien test = new Technicien();
                test.setPassword(password);
                test.encode(true);
                if(p.getPassword().equals(test.getPassword())){
                    System.out.println(new Date() +" Utilisateur reconnu");
                    return  p;
                }
            }
        }System.out.println("L'utilisateur n'a pas été reconnu");
        return null;
    }

    @Override
    public List<Technicien> getByLogin(String login) {
        List<Technicien> utilisateurs = null;
       if(login!=null){
            utilisateurs = this.utilisateurSrv.getByLogin(login);
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
       return utilisateurs;
    }

    @Override
    public List<Utilisateur> getAllByRange(int debut, int fin) {
        return this.utilisateurSrv.getAllByRange(debut, fin);
    }

    @Override
    public int count() {
        return this.utilisateurSrv.count();
    }
}
