/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.entitys.AuthorisationAcces;
import metier.entitys.Secteur;
import metier.entitys.Utilisateur;
import physique.data.AuthorisationAccesServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 * @author 
 */
public class AuthorisationAccesServiceImpl implements AuthorisationAccesService{
    
    private AuthorisationAccesServiceORM authorisationAccesSrv = PhysiqueDataFactory.getAuthorisationAccesServiceORM();
    @Override
    public void add(AuthorisationAcces authorisationAcces) throws Exception {
        if(authorisationAcces!=null){
            if(authorisationAcces instanceof AuthorisationAcces){
                authorisationAccesSrv.add(authorisationAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(AuthorisationAcces authorisationAcces) throws Exception {
        if(authorisationAcces!=null){
            if(authorisationAcces instanceof AuthorisationAcces){
                authorisationAccesSrv.update(authorisationAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(AuthorisationAcces authorisationAcces) throws Exception {
        if(authorisationAcces!=null){
            if(authorisationAcces instanceof AuthorisationAcces){
                authorisationAccesSrv.remove(authorisationAcces);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<AuthorisationAcces> getAll() throws Exception {
        return this.authorisationAccesSrv.getAll();
    }

    @Override
    public AuthorisationAcces getByUtilisateur(Utilisateur utilisateur) throws Exception {
        AuthorisationAcces authorisationAcces =null;
        if(utilisateur!=null){
            authorisationAcces = this.authorisationAccesSrv.getByUtilisateur(utilisateur);
        }else{
            throw new NullPointerException("L'objet passé en parametre est null.");
        }return authorisationAcces;
    }

    @Override
    public void detacherSecteurFromUtilisateur(Secteur secteur, Utilisateur utilisateur) {
        if(secteur!=null){
            if(utilisateur!=null){
                AuthorisationAcces a=null;
                try {
                    a = this.getByUtilisateur(utilisateur);
                } catch (Exception ex) {
                    Logger.getLogger(AuthorisationAccesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                for(int i= 0; i<a.getSecteurs().size() ; i++){
                    if(secteur.getId().equals(a.getSecteurs().get(i).getId())){
                        a.getSecteurs().remove(i);
                    }
                }try {
                    this.update(a);
                } catch (Exception ex) {
                    Logger.getLogger(AuthorisationAccesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                throw new NullPointerException("L'objet passé en parametre est null.");
            }
            
        }else{
            throw new NullPointerException("L'objet passé en parametre est null.");
        }
    }

    @Override
    public void atacherSecteurFromUtilisateur(Secteur secteur, Utilisateur utilisateur) {
         if(secteur!=null){
            if(utilisateur!=null){
                AuthorisationAcces a=null;
                try {
                    a = this.getByUtilisateur(utilisateur);
                } catch (Exception ex) {
                    Logger.getLogger(AuthorisationAccesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }if(a==null){
                    a = new AuthorisationAcces();
                }
                if(a.getSecteurs()==null){
                    List<Secteur> secteurs = new ArrayList<Secteur>();
                    secteurs.add(secteur);
                    a.setSecteurs(secteurs);
                }else{
                    List<Secteur> secteurs = new ArrayList<Secteur>();
                    secteurs.addAll(a.getSecteurs());
                    secteurs.add(secteur);
                    a.setSecteurs(secteurs);
                }a.setUtilisateur(utilisateur);
               try {
                    this.update(a);
                } catch (Exception ex) {
                    Logger.getLogger(AuthorisationAccesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                throw new NullPointerException("L'objet passé en parametre est null.");
            }
            
        }else{
            throw new NullPointerException("L'objet passé en parametre est null.");
        }
    }

    @Override
    public List<Secteur> getSecteurNotAssignByUtilisateur(Utilisateur utilisateur) {
        List<Secteur> secteur =null;
        if(utilisateur!=null){
            secteur = this.authorisationAccesSrv.getSecteurNotAssignByUtilisateur(utilisateur);
        }else{
            throw new NullPointerException("L'objet passé en parametre est null.");
        }return secteur;
    }

    @Override
    public Long count() {
        return this.authorisationAccesSrv.count();
    }
    
    
}
