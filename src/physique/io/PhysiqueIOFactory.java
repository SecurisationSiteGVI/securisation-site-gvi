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

    private static BorneAccesServiceIO borneAccesSrv;
    private static CameraDriver cameraDrivers;
    private static DetecteurIntrusionServiceIO detecteurIntrusionSrv;
    private static SmsServiceIO smsSrv;
    private static MailServiceIO mailSrv;
    
    public static MailServiceIO getMailServiceIO() {
        if (mailSrv == null) {
            mailSrv = new MailServiceIOImpl();
        }
        return mailSrv;
    }
    public static BorneAccesServiceIO getBorneAccesServiceIO() {
        if (borneAccesSrv == null) {
            borneAccesSrv = new BorneAccesServiceIOImpl();
        }
        return borneAccesSrv;
    }

    public static DetecteurIntrusionServiceIO getDetecteurIntrusionServiceIO() {
        if (detecteurIntrusionSrv == null) {
            detecteurIntrusionSrv = new DetecteurIntrusionServiceIOImpl();
        }
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
    
    public static SmsServiceIO getSmsServiceIO() {
        if(smsSrv == null) {
            smsSrv = new SmsServiceIOImpl();
        }
        return smsSrv;
    }
}
