/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.entitys.Sms;
import physique.data.PhysiqueDataFactory;
import physique.data.SmsServiceORM;
import physique.io.PhysiqueIOFactory;
import physique.io.SmsServiceIOImpl;

/**
 *
 * @author saturne
 */
public class SmsServiceImpl implements SmsService, Observer {

//    private SmsServiceORM smsSrv = PhysiqueDataFactory.getSmsServiceORM();
//    private SmsServiceIOImpl smsServiceIOImpl = (SmsServiceIOImpl) PhysiqueIOFactory.getSmsServiceIO();
//
//    public SmsServiceImpl() {
//        smsServiceIOImpl.addObserver(this);
//    }
//
//    @Override
//    public void add(Sms sms) throws Exception {
//        if (sms != null) {
//            if (sms instanceof Sms) {
//                smsSrv.add(sms);
//            } else {
//                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
//            }
//        } else {
//            throw new NullPointerException("Objet passé en parametre égale à null");
//        }
//    }
//
//    @Override
//    public void update(Sms sms) throws Exception {
//        if (sms != null) {
//            if (sms instanceof Sms) {
//                smsSrv.update(sms);
//            } else {
//                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
//            }
//        } else {
//            throw new NullPointerException("Objet passé en parametre égale à null");
//        }
//    }
//
//    @Override
//    public void remove(Sms sms) throws Exception {
//        if (sms != null) {
//            if (sms instanceof Sms) {
//                smsSrv.remove(sms);
//            } else {
//                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
//            }
//        } else {
//            throw new NullPointerException("Objet passé en parametre égale à null");
//        }
//    }
//
////    @Override
////    public List<Sms> getAll() throws Exception {
////        return this.smsSrv.getAll();
////    }
//
//    @Override
//    public Long count() {
//        return this.smsSrv.count();
//    }
//
//    @Override
//    public Sms getById(Long id) {
//        Sms sms = null;
////        if (id != null) {
////            sms = this.smsSrv.getById(id);
////        } else {
////            throw new NullPointerException("Objet passé en parametre égale à null");
////        }
//        return sms;
//    }
//
//    @Override
//    public void update(Observable o, Object o1) {
//        if (o instanceof SmsServiceIOImpl) {
//            SmsServiceIOImpl oo = (SmsServiceIOImpl) o;
//
//        }
//    }
//
//    @Override
//    public void startThread() {
//        try {
//            this.smsServiceIOImpl.creationPort();
//        } catch (Exception ex) {
//            Logger.getLogger(SmsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
