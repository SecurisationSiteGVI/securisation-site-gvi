package metier;

import java.util.List;
import javax.management.InstanceNotFoundException;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;
import metier.entitys.Utilisateur;
import physique.data.AttributionUtilisateurBadgeServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 * @author damien
 */
public class AttributionUtilisateurBadgeServiceImpl implements AttributionUtilisateurBadgeService {

    private AttributionUtilisateurBadgeServiceORM attributionUtilisateurBadgeSrv = PhysiqueDataFactory.getAttributionUtilisateurBadgeServiceORM();

    @Override
    public void add(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception {
        if (attributionUtilisateurBadge != null) {
            if (attributionUtilisateurBadge instanceof AttributionUtilisateurBadge) {
                attributionUtilisateurBadgeSrv.add(attributionUtilisateurBadge);
            } else {
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception {
        if (attributionUtilisateurBadge != null) {
            if (attributionUtilisateurBadge instanceof AttributionUtilisateurBadge) {
                attributionUtilisateurBadgeSrv.update(attributionUtilisateurBadge);
            } else {
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception {
        if (attributionUtilisateurBadge != null) {
            if (attributionUtilisateurBadge instanceof AttributionUtilisateurBadge) {
                attributionUtilisateurBadgeSrv.remove(attributionUtilisateurBadge);
            } else {
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<AttributionUtilisateurBadge> getAll() throws Exception {
        return this.attributionUtilisateurBadgeSrv.getAll();
    }

    @Override
    public List<AttributionUtilisateurBadge> getAll(int debut, int nbResult) {
        return this.attributionUtilisateurBadgeSrv.getAll(debut, nbResult);
    }

    @Override
    public List<Badge> getBadgesNotAssign() {
        return this.attributionUtilisateurBadgeSrv.getBadgesNotAssign();
    }

    @Override
    public List<Badge> getBadgesNotAssign(int debut, int nbResult) {
        return this.attributionUtilisateurBadgeSrv.getBadgesNotAssign(debut, nbResult);
    }

    @Override
    public List<Utilisateur> getUtilisateurNotAssign() {
        return this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssign();
    }

    @Override
    public List<Utilisateur> getUtilisateurNotAssign(int debut, int nbResult) {
        return this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssign(debut, nbResult);
    }

    @Override
    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom) {
        return this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssignByNom(nom);
    }

    @Override
    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom, int debut, int nbResult) {
        return this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssignByNom(nom, debut, nbResult);
    }

    @Override
    public AttributionUtilisateurBadge getByUtilisateur(Utilisateur utilisateur) {
        AttributionUtilisateurBadge attributionUtilisateurBadge = null;
        if (utilisateur != null) {
            if (utilisateur instanceof Utilisateur) {
                attributionUtilisateurBadge = attributionUtilisateurBadgeSrv.getByUtilisateur(utilisateur);
            } else {
                System.out.append("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return attributionUtilisateurBadge;
    }

    @Override
    public List<Badge> getBadgesNotAssignByNumero(String numero) {
        return this.attributionUtilisateurBadgeSrv.getBadgesNotAssignByNumero(numero);
    }

    @Override
    public List<Badge> getBadgesNotAssignByNumero(String numero, int debut, int nbResult) {
        return this.attributionUtilisateurBadgeSrv.getBadgesNotAssignByNumero(numero, debut, nbResult);
    }

    @Override
    public Long count() {
        return this.attributionUtilisateurBadgeSrv.count();
    }

    @Override
    public AttributionUtilisateurBadge getById(Long id) {
        AttributionUtilisateurBadge attributionUtilisateurBadge = null;
        if (id != null) {
            attributionUtilisateurBadge = this.attributionUtilisateurBadgeSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return attributionUtilisateurBadge;
    }

    @Override
    public AttributionUtilisateurBadge getByBadge(Badge badge) {
        AttributionUtilisateurBadge attributionUtilisateurBadge = null;
        if (badge != null) {
            if (badge instanceof Badge) {
                attributionUtilisateurBadge = this.attributionUtilisateurBadgeSrv.getByBadge(badge);
            } else {
                System.out.println("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return attributionUtilisateurBadge;
    }
}
