package physique.io;

import physique.data.CameraServiceORM;

/**
 * @author ragotalexis
 * @author BlondelleMarvin
 * @author
 */

public class PhysiqueIOFactory {
    
    private static BorneAccesServiceIO borneAccesSrv = new BorneAccesServiceIOImpl();
    private static CameraServiceIO cameraSrv = new CameraServiceIOImpl();

    
    
    public BorneAccesServiceIO getBorneAccesServiceIO() {
        return borneAccesSrv;
    }

    public  CameraServiceIO CameraServiceIOImpl() {
        return cameraSrv ;
    }


    
}
