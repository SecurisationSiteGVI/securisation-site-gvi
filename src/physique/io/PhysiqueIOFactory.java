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
    private static CameraDriver cameraDrivers;
    private static DetecteurIntrusionServiceIO detecteurIntrusionSrv = new DetecteurIntrusionServiceIOImpl();

    public static BorneAccesServiceIO getBorneAccesServiceIO() {
        return borneAccesSrv;
    }
    
    public static DetecteurIntrusionServiceIO getDetecteurIntrusionServiceIO() {
        return detecteurIntrusionSrv;
    }

    public static CameraDriver getCameraDrivers(Camera camera) {
        switch (camera.getType()) {
            case HEDEN:
                cameraDrivers = new CameraDriverHedenImpl(camera);
                break;
            case SONY:
                cameraDrivers = new CameraDriverSonyImpl(camera);
                break;
        }
        return cameraDrivers;
    }
}
