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
    
    public static CameraServiceORM getCameraServiceORM(){
        return cameraSrv;
    }
    public static BorneAccesServiceORM getAccesServiceORM(){
        return borneAccesSrv;
    }
    public static UtilisateurServiceORM getUtilisateurServiceORM(){
        return utilisateurSrv;
    }
}
