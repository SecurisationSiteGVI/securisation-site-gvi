package metier;

/**
 * @author ragotalexis
 * @author damien
 * @author blondelleMarvin
 */
public class MetierFactory {

    private static BorneAccesService borneAccesSrv;
    private static AuthorisationAccesService authorisationAccesSrv;
    private static EvenementService evenementSrv;
    private static BadgeService badgeSrv;
    private static AttributionUtilisateurBadgeService attributionUtilisateurBadgeSrv;
    private static SecteurService secteurSrv;
    private static PositionService positionSrv;
    private static CameraService cameraSrv;
    private static UtilisateurService utilisateurSrv;
    private static NumeroPredefinisService numeroPredefinisSrv;
    private static DetecteurIntrusionService detecteurIntrusionSrv;
    private static AttributionSecteurBorneAccesService attributionSecteurBorneAccesSrv;
    private static AttributionSecteurCameraService attributionSecteurCameraSrv;
    private static AttributionSecteurDetecteurIntrusionService attributionSecteurDetectionIntrusionSrv;

    public static AttributionSecteurCameraService getAttributionSecteurCameraService() {
        if (attributionSecteurCameraSrv == null) {
            attributionSecteurCameraSrv = new AttributionSecteurCameraServiceImpl();
        }
        return attributionSecteurCameraSrv;
    }

    public static AttributionSecteurDetecteurIntrusionService getAttributionSecteurDetecteurIntrusionService() {
        if (attributionSecteurDetectionIntrusionSrv == null) {
            attributionSecteurDetectionIntrusionSrv = new AttributionSecteurDetecteurIntrusionServiceImpl();
        }
        return attributionSecteurDetectionIntrusionSrv;
    }

    public static CameraService getCameraService() {
        if (cameraSrv == null) {
            cameraSrv = new CameraServiceImpl();
        }
        return cameraSrv;
    }

    public static UtilisateurService getUtilisateurService() {
        if (utilisateurSrv == null) {
            utilisateurSrv = new UtilisateurServiceImpl();
        }
        return utilisateurSrv;
    }

    public static NumeroPredefinisService getNumeroPredefinisService() {
        if (numeroPredefinisSrv == null) {
            numeroPredefinisSrv = new NumeroPredefinisServiceImpl();
        }
        return numeroPredefinisSrv;
    }

    public static DetecteurIntrusionService getDetecteurIntrusionService() {
        if (detecteurIntrusionSrv == null) {
            detecteurIntrusionSrv = new DetecteurIntrusionServiceImpl();
        }
        return detecteurIntrusionSrv;
    }

    public static AttributionSecteurBorneAccesService getAttributionSecteurBorneAccesService() {
        if (attributionSecteurBorneAccesSrv == null) {
            attributionSecteurBorneAccesSrv = new AttributionSecteurBorneAccesServiceImpl();
        }
        return attributionSecteurBorneAccesSrv;
    }

    public static BorneAccesService getBorneAccesService() {
        if (borneAccesSrv == null) {
            borneAccesSrv = new BorneAccesServiceImpl();
        }
        return borneAccesSrv;
    }

    public static AuthorisationAccesService getAuthorisationAccesService() {
        if (authorisationAccesSrv == null) {
            authorisationAccesSrv = new AuthorisationAccesServiceImpl();
        }
        return authorisationAccesSrv;
    }

    public static EvenementService getEvenementService() {
        if (evenementSrv == null) {
            evenementSrv = new EvenementServiceImpl();
        }
        return evenementSrv;
    }

    public static BadgeService getBadgeService() {
        if (badgeSrv == null) {
            badgeSrv = new BadgeServiceImpl();
        }
        return badgeSrv;
    }

    public static AttributionUtilisateurBadgeService getAttributionUtilisateurBadgeService() {
        if (attributionUtilisateurBadgeSrv == null) {
            attributionUtilisateurBadgeSrv = new AttributionUtilisateurBadgeServiceImpl();
        }
        return attributionUtilisateurBadgeSrv;
    }

    public static SecteurService getSecteurService() {
        if (secteurSrv == null) {
            secteurSrv = new SecteurServiceImpl();
        }
        return secteurSrv;
    }

    public static PositionService getPositionService() {
        if (positionSrv == null) {
            positionSrv = new PositionServiceImpl();
        }
        return positionSrv;
    }
}
