/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.AuthorisationAcces;
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
    
}
