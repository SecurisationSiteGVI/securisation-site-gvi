/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

/**
 *
 * @author damien
 */
public class PhysiqueDataFactory {
    private static CameraServiceORM cameraSrv = new CameraServiceORMImpl();
    private static BorneAccesServiceORM borneAccesSrv = new BorneAccesServiceORMImpl();
    private static UtilisateurServiceORM utilisateurSrv = new UtilisateurServiceORMImpl();
    private static AuthorisationAccesServiceORM authorisationAccesSrv = new AuthorisationAccesServiceORMImpl();
    private static EvenementServiceORM evenementSrv = new EvenementServiceORMImpl();
    private static NumeroPredefinisServiceORM numeroPredefinisSrv = new NumeroPredefinisServiceORMImpl();
    private static DetecteurIntrusionServiceORM detecteurIntrusionSrv = new DetecteurIntrusionServiceORMImpl();
   
    public static DetecteurIntrusionServiceORM getDetecteurIntrusionServiceORM(){
        return detecteurIntrusionSrv;
    }
    public static NumeroPredefinisServiceORM getNumeroPredefinisServiceORM(){
        return numeroPredefinisSrv;
    }
    public static CameraServiceORM getCameraServiceORM(){
        return cameraSrv;
    }
    public static BorneAccesServiceORM getAccesServiceORM(){
        return borneAccesSrv;
    }
    public static UtilisateurServiceORM getUtilisateurServiceORM(){
        return utilisateurSrv;
    }
    public static AuthorisationAccesServiceORM getAuthorisationAccesServiceORM(){
        return authorisationAccesSrv;
    }
    public static EvenementServiceORM getEvenementServiceORM(){
        return evenementSrv;
    }
}
