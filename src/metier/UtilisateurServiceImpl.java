/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.entitys.Acces;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.AuthorisationAcces;
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
    private AuthorisationAccesService authorisationAccesSrv = MetierFactory.getAuthorisationAccesService();
    private EvenementService evenementSrv = MetierFactory.getEvenementService();
    private AttributionUtilisateurBadgeService attributionUtilisateurBadgeSrv = MetierFactory.getAttributionUtilisateurBadgeService();

    @Override
    public void add(Utilisateur utilisateur) {
        if (utilisateur != null) {
            if (utilisateur instanceof Utilisateur) {
                utilisateurSrv.add(utilisateur);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Utilisateur utilisateur) {
        if (utilisateur != null) {
            if (utilisateur instanceof Utilisateur) {
                AuthorisationAcces ret = null;
                if (!this.evenementSrv.getAccesByUtilisateur(utilisateur).isEmpty()) {
                    List<Acces> acces = this.evenementSrv.getAccesByUtilisateur(utilisateur);
                    for (int i = 0; i < acces.size(); i++) {
                        try {
                            this.evenementSrv.remove(acces.get(i));
                        } catch (Exception ex) {
                            Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                try {
                    if (this.attributionUtilisateurBadgeSrv.getByUtilisateur(utilisateur) != null) {
                        AttributionUtilisateurBadge badge = attributionUtilisateurBadgeSrv.getByUtilisateur(utilisateur);
                        this.attributionUtilisateurBadgeSrv.remove(badge);

                    }
                } catch (Exception ex) {
                    Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    ret = authorisationAccesSrv.getByUtilisateur(utilisateur);
                } catch (Exception ex) {
                    Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ret == null) {

                    utilisateurSrv.remove(utilisateur);
                } else {
                    try {
                        authorisationAccesSrv.remove(ret);
                    } catch (Exception ex) {
                        Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    utilisateurSrv.remove(ret.getUtilisateur());
                }

            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Utilisateur utilisateur) {
        if (utilisateur != null) {
            if (utilisateur instanceof Utilisateur) {
                utilisateurSrv.update(utilisateur);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
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
        boolean retour = true;
        List<Technicien> utilisateurs = this.getByLogin(login);
        if (utilisateurs.isEmpty()) {
            System.out.println("passage");
            retour = false;
        }
        return retour;
    }

    @Override
    public Technicien verifificationConnexion(String login, String password) {
        boolean retour = false;
        List<Technicien> utilisateurs = this.getByLogin(login);
        Technicien p = null;
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (login.equals(utilisateurs.get(i).getLogin())) {
                p = utilisateurs.get(i);
                Technicien test = new Technicien();
                test.setPassword(password);
                test.encode(true);
                if (p.getPassword().equals(test.getPassword())) {
                    System.out.println(new Date() + " Utilisateur reconnu");
                    return p;
                }
            }
        }
        System.out.println("L'utilisateur n'a pas été reconnu");
        return null;
    }

    @Override
    public List<Technicien> getByLogin(String login) {
        List<Technicien> utilisateurs = null;
        if (login != null) {
            utilisateurs = this.utilisateurSrv.getByLogin(login);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getAllByRange(int debut, int nbResult) {
        return this.utilisateurSrv.getAllByRange(debut, nbResult);
    }

    @Override
    public Long count() {
        return this.utilisateurSrv.count();
    }

    @Override
    public List<Utilisateur> getByNom(String nom) {
        List<Utilisateur> utilisateurs = null;
        if (nom != null) {
            utilisateurs = this.utilisateurSrv.getByNom(nom);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByNom(String nom, int debut, int nbResult) {
        List<Utilisateur> utilisateurs = null;
        if (nom != null) {
            utilisateurs = this.utilisateurSrv.getByNom(nom, debut, nbResult);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByPrenom(String prenom) {
        List<Utilisateur> utilisateurs = null;
        if (prenom != null) {
            utilisateurs = this.utilisateurSrv.getByPrenom(prenom);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByPrenom(String prenom, int debut, int nbResult) {
        List<Utilisateur> utilisateurs = null;
        if (prenom != null) {
            utilisateurs = this.utilisateurSrv.getByPrenom(prenom, debut, nbResult);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByVille(String ville) {
        List<Utilisateur> utilisateurs = null;
        if (ville != null) {
            utilisateurs = this.utilisateurSrv.getByVille(ville);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByVille(String ville, int debut, int nbResult) {
        List<Utilisateur> utilisateurs = null;
        if (ville != null) {
            utilisateurs = this.utilisateurSrv.getByVille(ville);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByAdresse(String adresse) {
        List<Utilisateur> utilisateurs = null;
        if (adresse != null) {
            utilisateurs = this.utilisateurSrv.getByAdresse(adresse);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByAdresse(String adresse, int debut, int nbResult) {
        List<Utilisateur> utilisateurs = null;
        if (adresse != null) {
            utilisateurs = this.utilisateurSrv.getByAdresse(adresse, debut, nbResult);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByCodePostale(int code) {
        List<Utilisateur> utilisateurs = null;
        if (code != 0) {
            utilisateurs = this.utilisateurSrv.getByCodePostale(code);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByCodePostale(int code, int debut, int nbResult) {
        List<Utilisateur> utilisateurs = null;
        if (code != 0) {
            utilisateurs = this.utilisateurSrv.getByCodePostale(code, debut, nbResult);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByEmail(String email) {
        List<Utilisateur> utilisateurs = null;
        if (email != null) {
            utilisateurs = this.utilisateurSrv.getByEmail(email);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByEmail(String email, int debut, int nbResult) {
        List<Utilisateur> utilisateurs = null;
        if (email != null) {
            utilisateurs = this.utilisateurSrv.getByEmail(email, debut, nbResult);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateurs;
    }

    @Override
    public Utilisateur getById(Long id) {
        Utilisateur utilisateur = null;
        if (id != null) {
            utilisateur = this.utilisateurSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return utilisateur;
    }
}
