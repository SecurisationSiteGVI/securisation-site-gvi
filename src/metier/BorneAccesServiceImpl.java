package metier;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.entitys.Badge;
import metier.entitys.BorneAcces;
import physique.data.BorneAccesServiceORM;
import physique.data.BorneAccesServiceORMImpl;
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
    public void startThread(){
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

    private void traiterTrame() {
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof BorneAccesServiceIOImpl) {
            BorneAccesServiceIOImpl oo = (BorneAccesServiceIOImpl) o;
            Trame t = oo.trame;
            this.badge = t.getBadge();
            this.borneAcces = t.getBorneAcces();
        }
    }
}
