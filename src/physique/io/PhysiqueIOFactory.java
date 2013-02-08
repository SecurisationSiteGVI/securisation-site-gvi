package physique.io;

import java.util.ArrayList;
import java.util.List;
import metier.entitys.Camera;

/**
 * @author ragotalexis
 * @author BlondelleMarvin
 * @author
 */

public class PhysiqueIOFactory {
    
    private static BorneAccesServiceIO borneAccesSrv = new BorneAccesServiceIOImpl();
    private static List<CameraDriver> cameraDrivers = new ArrayList<>();
    
    public static BorneAccesServiceIO getBorneAccesServiceIO() {
        return borneAccesSrv;
    }

    public static List<CameraDriver> getCameraDrivers() {
        if (cameraDrivers.isEmpty()) {
            Camera cam = new Camera();
            cam.setIp("172.16.79.214");
            cam.setNom("Camera Heden 1");
            cam.setType("Heden");
            cameraDrivers.add(new CameraDriverHedenImpl(cam));
        }
        
        return cameraDrivers ;
    }


    
}
