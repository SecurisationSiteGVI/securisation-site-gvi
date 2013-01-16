package metier;

import metier.entitys.AttributionSecteurBorneAcces;

/**
 * @author ragotalexis
 * @author damien
 * @author
 * @author
 */
public class MetierFactory {

    private static BorneAccesService borneAccesSrv = new BorneAccesServiceImpl();
    private static AuthorisationAccesService AuthorisationAccesSrv = new AuthorisationAccesServiceImpl();
    private static EvenementService evenementSrv = new EvenementServiceImpl();
    private static BadgeService badgeSrv = new BadgeServiceImpl();
    private static AttributionUtilisateurBadgeService AttributionUtilisateurBadgeSrv = new AttributionUtilisateurBadgeServiceImpl();
    private static SecteurService SecteurSrv = new SecteurServiceImpl();
    private static PositionService positionSrv = new PositionServiceImpl();
    private static CameraService cameraSrv = new CameraServiceImpl();
    private static UtilisateurService utilisateurSrv = new UtilisateurServiceImpl();
    private static NumeroPredefinisService numeroPredefinisSrv = new NumeroPredefinisServiceImpl();
    private static DetecteurIntrusionService detecteurIntrusionSrv = new DetecteurIntrusionServiceImpl();
    private static AttributionSecteurBorneAccesService attributionSecteurBorneAccesSrv = new AttributionSecteurBorneAccesServiceImpl();
    private static AttributionSecteurCameraService attributionSecteurCameraSrv = new AttributionSecteurCameraServiceImpl();
    private static AttributionSecteurDetecteurIntrusionService attributionSecteurDetectionIntrusionSrv = new AttributionSecteurDetecteurIntrusionServiceImpl();

    public static AttributionSecteurCameraService getAttributionSecteurCameraService() {
        return attributionSecteurCameraSrv;
    }

    public static AttributionSecteurDetecteurIntrusionService getAttributionSecteurDetecteurIntrusionService() {
        return attributionSecteurDetectionIntrusionSrv;
    }
    public static CameraService getCameraService() {
        return cameraSrv;
    }

    public static UtilisateurService getUtilisateurService() {
        return utilisateurSrv;
    }

    public static NumeroPredefinisService getNumeroPredefinisService() {
        return numeroPredefinisSrv;
    }

    public static DetecteurIntrusionService getDetecteurIntrusionService() {
        return detecteurIntrusionSrv;
    }

    public static AttributionSecteurBorneAccesService getAttributionSecteurBorneAccesService() {
        return attributionSecteurBorneAccesSrv;
    }

    public static BorneAccesService getBorneAccesService() {
        return borneAccesSrv;
    }

    public static AuthorisationAccesService getAuthorisationAccesService() {
        return AuthorisationAccesSrv;
    }

    public static EvenementService getEvenementService() {
        return evenementSrv;
    }

    public static BadgeService getBadgeService() {
        return badgeSrv;
    }

    public static AttributionUtilisateurBadgeService getAttributionUtilisateurBadgeService() {
        return AttributionUtilisateurBadgeSrv;
    }

    public static SecteurService getSecteurService() {
        return SecteurSrv;
    }

    public static PositionService getPositionService() {
        return positionSrv;
    }
}
