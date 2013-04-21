/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Evenement;
import metier.entitys.Intrusion;
import metier.entitys.NumeroPredefinis;
import metier.entitys.Position;
import physique.data.DetecteurIntrusionServiceORM;
import physique.data.NumeroPredefinisServiceORM;
import physique.data.PhysiqueDataFactory;
import physique.io.DetecteurIntrusionServiceIOImpl;
import physique.io.PhysiqueIOFactory;
import physique.io.SmsServiceIO;

/**
 *
 * @author damien
 */
public class DetecteurIntrusionServiceImpl implements DetecteurIntrusionService, Observer {

    private DetecteurIntrusionServiceORM detecteurIntrusionSrv = PhysiqueDataFactory.getDetecteurIntrusionServiceORM();
    private DetecteurIntrusionServiceIOImpl detecteurIntrusionServiceIOImpl = (DetecteurIntrusionServiceIOImpl) PhysiqueIOFactory.getDetecteurIntrusionServiceIO();
    private EvenementService evenementSrv = MetierFactory.getEvenementService();
    private SmsServiceIO smsSrv = PhysiqueIOFactory.getSmsServiceIO();
    private NumeroPredefinisServiceORM numeroPredefinisSrv = PhysiqueDataFactory.getNumeroPredefinisServiceORM();

    public DetecteurIntrusionServiceImpl() {
        detecteurIntrusionServiceIOImpl.addObserver(this);
    }

    @Override
    public void add(DetecteurIntrusion detecteurIntrusion) throws Exception {
        if (detecteurIntrusion != null) {
            if (detecteurIntrusion instanceof DetecteurIntrusion) {
                detecteurIntrusionSrv.add(detecteurIntrusion);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(DetecteurIntrusion detecteurIntrusion) throws Exception {
        if (detecteurIntrusion != null) {
            if (detecteurIntrusion instanceof DetecteurIntrusion) {
                detecteurIntrusionSrv.update(detecteurIntrusion);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(DetecteurIntrusion detecteurIntrusion) throws Exception {
        if (detecteurIntrusion != null) {
            if (detecteurIntrusion instanceof DetecteurIntrusion) {
                detecteurIntrusionSrv.remove(detecteurIntrusion);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<DetecteurIntrusion> getAll() throws Exception {
        return this.detecteurIntrusionSrv.getAll();
    }

    @Override
    public Long count() {
        return this.detecteurIntrusionSrv.count();
    }

    @Override
    public DetecteurIntrusion getById(Long id) {
        DetecteurIntrusion detecteurIntrusion = null;
        if (id != null) {
            detecteurIntrusion = this.detecteurIntrusionSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return detecteurIntrusion;
    }

    @Override
    public void update(Observable o, Object o1) {
        if (o instanceof DetecteurIntrusionServiceIOImpl) {
            try {
                DetecteurIntrusionServiceIOImpl oo = (DetecteurIntrusionServiceIOImpl) o;
                this.traitementEvenement();
                this.traitementSms();
            } catch (Exception ex) {
                Logger.getLogger(DetecteurIntrusionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void traitementEvenement() throws Exception {
        Intrusion e = new Intrusion();
        e.setDateEvt(new Date());

        //e.setDetecteurIntrusion());
        this.evenementSrv.add(e);
    }

    public void traitementSms() throws Exception {
        NumeroPredefinis numeroPredefinis = this.numeroPredefinisSrv.getAll().get(0);
        List<String> numeros = numeroPredefinis.getNumeros();
        for (int i = 0; i < numeros.size(); i++) {
            this.smsSrv.envoie(numeros.get(i));
            Thread.sleep(500);
        }
    }

    @Override
    public void startThread() {
        try {
            this.detecteurIntrusionServiceIOImpl.creationPort();
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<DetecteurIntrusion> getAll(int index, int nbResult) {
        return this.detecteurIntrusionSrv.getAll(index, nbResult);
    }

    @Override
    public List<DetecteurIntrusion> getByPosition(Position position) {
        List<DetecteurIntrusion> detecteurIntrusions = null;
        if (position != null) {
            if (position instanceof Position) {
                detecteurIntrusions = detecteurIntrusionSrv.getByPosition(position);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return detecteurIntrusions;
    }
}