package metier;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyledEditorKit;
import metier.entitys.Acces;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.AuthorisationAcces;
import metier.entitys.Badge;
import metier.entitys.BorneAcces;
import metier.entitys.Secteur;
import metier.entitys.Utilisateur;
import physique.data.BorneAccesServiceORM;
import physique.data.PhysiqueDataFactory;
import physique.io.BorneAccesServiceIOImpl;
import physique.io.PhysiqueIOFactory;
import physique.io.Trame;

/**
 * @author damien
 * @author ragotalexis
 */
public class BorneAccesServiceImpl implements BorneAccesService, Observer {

    private BorneAccesServiceORM borneAccesSrv = PhysiqueDataFactory.getBorneAccesServiceORM();
    private BorneAcces borneAcces;
    private Badge badge;
    private BorneAccesServiceIOImpl borneAccesServiceIOImpl = (BorneAccesServiceIOImpl) PhysiqueIOFactory.getBorneAccesServiceIO();

    public BorneAccesServiceImpl() {
        borneAccesServiceIOImpl.addObserver(this);
    }

    public void startThread() {
        try {
            this.borneAccesServiceIOImpl.getTrame();
        } catch (Exception ex) {
            Logger.getLogger(BorneAccesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(BorneAcces borneAcces) throws Exception {
        if (borneAcces != null) {
            if (borneAcces instanceof BorneAcces) {
                borneAccesSrv.add(borneAcces);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(BorneAcces borneAcces) throws Exception {
        if (borneAcces != null) {
            if (borneAcces instanceof BorneAcces) {
                borneAccesSrv.update(borneAcces);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(BorneAcces borneAcces) throws Exception {
        if (borneAcces != null) {
            if (borneAcces instanceof BorneAcces) {
                borneAccesSrv.remove(borneAcces);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<BorneAcces> getAll() throws Exception {
        return this.borneAccesSrv.getAll();
    }

    @Override
    public Long count() {
        return this.borneAccesSrv.count();
    }

    @Override
    public BorneAcces getById(Long id) {
        BorneAcces utilisateur = null;
        if (id != null) {
            utilisateur = this.borneAccesSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateur;
    }

    @Override
    public BorneAcces getByNom(String nom) {
        BorneAcces b = null;
        if (nom != null) {
            if (nom instanceof String) {
                b = borneAccesSrv.getByNom(nom);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return b;
    }

    @Override
    public void verificationAcces() {
        Badge badg = PhysiqueDataFactory.getBadgeServiceORM().getByNumero(this.badge.getNumero());
        AttributionUtilisateurBadge attributionUtilisateurBadge = PhysiqueDataFactory.getAttributionUtilisateurBadgeServiceORM().getByBadge(badg);
        BorneAcces borne = PhysiqueDataFactory.getBorneAccesServiceORM().getByNom(this.borneAcces.getNom());
        Utilisateur utilisateur = null;
        boolean authorisationPassage = false;
        if (attributionUtilisateurBadge != null) {
            utilisateur = attributionUtilisateurBadge.getUtilisateur();
            AuthorisationAcces authorisationAcces = PhysiqueDataFactory.getAuthorisationAccesServiceORM().getByUtilisateur(utilisateur);
            List<Secteur> secteursUtilisateur = authorisationAcces.getSecteurs();
            if (!secteursUtilisateur.isEmpty()) {
                for (int j = 0; j < secteursUtilisateur.size(); j++) {
                    AttributionSecteurBorneAcces attributionSecteurBorneAcces = PhysiqueDataFactory.getAttributionSecteurBorneAccesServiceORM().getBySecteur(secteursUtilisateur.get(j));
                    List<BorneAcces> listBorneAcces = attributionSecteurBorneAcces.getBorneAccess();
                    authorisationPassage = false;
                    for (int k = 0; k < listBorneAcces.size(); k++) {
                        if (listBorneAcces.get(k).getNom().equals(this.borneAcces.getNom())) {
                            System.out.println("Acces Authorisé !");
                            authorisationPassage = true; 
                            borne =listBorneAcces.get(k);
                        }
                    }
                }
                
            } else {
                System.out.println("L'utilisateur n'a pas de secteur authorisé");
            }

        } else {
            System.out.println("Le badge n'a pas d'utilisateur d'attribuer.");
        }
        
        Acces acces = new Acces();
        acces.setBorneAcces(borne);
        acces.setPassage(authorisationPassage);
        acces.setUtilisateur(utilisateur);
        acces.setDateEvt(new Date());
        EvenementService evenementService = MetierFactory.getEvenementService();
        try {
            evenementService.add(acces);
        } catch (Exception ex) {
            Logger.getLogger(BorneAccesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof BorneAccesServiceIOImpl) {
            BorneAccesServiceIOImpl oo = (BorneAccesServiceIOImpl) o;
            Trame t = oo.trame;
            this.badge = t.getBadge();
            this.borneAcces = t.getBorneAcces();
            verificationAcces();
        }
    }
}
