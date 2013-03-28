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
    private static PositionServiceORM positionSrv = new PositionServiceORMImpl();
    private static BadgeServiceORM badgeSrv = new BadgeServiceORMImpl();
    private static AttributionUtilisateurBadgeServiceORM attributionUtilisateurBadgeSrv = new AttributionUtilisateurBadgeServiceORMImpl();
    private static AttributionSecteurBorneAccesServiceORM attributionSecteurBorneAccesSrv = new AttributionSecteurBorneAccesServiceORMImpl();
    private static AttributionSecteurCameraServiceORM attributionSecteurCameraSrv = new AttributionSecteurCameraServiceORMImpl();
    private static AttributionSecteurDetectionIntrusionServiceORM attributionSecteurDetectionIntrusionSrv = new AttributionSecteurDetectionIntrusionServiceORMImpl();
    private static SmsServiceORM smsSrv = new SmsServiceORMImpl();
    private static SecteurServiceORM secteurSrv = new SecteurServiceORMImpl();
    
    public static AttributionSecteurCameraServiceORM getAttributionSecteurCameraServiceORM() {
        return attributionSecteurCameraSrv;
    }
    
    public static AttributionSecteurDetectionIntrusionServiceORM getAttributionSecteurDetectionIntrusionServiceORM() {
        return attributionSecteurDetectionIntrusionSrv;
    }

    public static SecteurServiceORM getSecteurServiceORM() {
        return secteurSrv;
    }
     public static AttributionSecteurBorneAccesServiceORM getAttributionSecteurBorneAccesServiceORM() {
        return attributionSecteurBorneAccesSrv;
    }
    
    public static AttributionUtilisateurBadgeServiceORM getAttributionUtilisateurBadgeServiceORM() {
        return attributionUtilisateurBadgeSrv;
    }

    public static BadgeServiceORM getBadgeServiceORM() {
        return badgeSrv;
    }

    public static PositionServiceORM getPositionServiceORM() {
        return positionSrv;
    }

    public static DetecteurIntrusionServiceORM getDetecteurIntrusionServiceORM() {
        return detecteurIntrusionSrv;
    }

    public static NumeroPredefinisServiceORM getNumeroPredefinisServiceORM() {
        return numeroPredefinisSrv;
    }

    public static CameraServiceORM getCameraServiceORM() {
        return cameraSrv;
    }

    public static BorneAccesServiceORM getBorneAccesServiceORM() {
        return borneAccesSrv;
    }

    public static UtilisateurServiceORM getUtilisateurServiceORM() {
        return utilisateurSrv;
    }

    public static AuthorisationAccesServiceORM getAuthorisationAccesServiceORM() {
        return authorisationAccesSrv;
    }

    public static EvenementServiceORM getEvenementServiceORM() {
        return evenementSrv;
    }
    
    public static SmsServiceORM getSmsServiceORM() {
        return smsSrv;
    }
}
