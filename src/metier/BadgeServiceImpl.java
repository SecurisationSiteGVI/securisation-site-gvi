package metier;

import java.util.List;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;
import physique.data.AttributionUtilisateurBadgeServiceORM;
import physique.data.BadgeServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 * @author damien
 */
public class BadgeServiceImpl implements BadgeService {

    private BadgeServiceORM badgeSrv = PhysiqueDataFactory.getBadgeServiceORM();
    private AttributionUtilisateurBadgeServiceORM attributionUtilisateurBadgeSrv = PhysiqueDataFactory.getAttributionUtilisateurBadgeServiceORM();
    @Override
    public void add(Badge badge) throws Exception {
        if (badge != null) {
            if (badge instanceof Badge) {
                badgeSrv.add(badge);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Badge badge) throws Exception {
        if (badge != null) {
            if (badge instanceof Badge) {
                badgeSrv.update(badge);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Badge badge) throws Exception {
        if (badge != null) {
            if (badge instanceof Badge) {
                if(this.attributionUtilisateurBadgeSrv.getByBadge(badge)!=null){
                    AttributionUtilisateurBadge badged = this.attributionUtilisateurBadgeSrv.getByBadge(badge);
                    this.attributionUtilisateurBadgeSrv.remove(badged);
                }
                badgeSrv.remove(badge);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Badge> getAll() throws Exception {
        return this.badgeSrv.getAll();
    }

    @Override
    public List<Badge> getAll(int debut, int nbResult) throws Exception {
        return this.badgeSrv.getAll(debut, nbResult);
    }

    @Override
    public Long count() {
        return this.badgeSrv.count();
    }

    @Override
    public Badge getById(Long id) {
        Badge badge = null;
        if (id != null) {
            badge = this.badgeSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return badge;
    }

    @Override
    public Badge getByNumero(String numero) {
        Badge b = null;
        if (numero != null) {
            if (numero instanceof String) {
                b = badgeSrv.getByNumero(numero);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return b;
    }
}
