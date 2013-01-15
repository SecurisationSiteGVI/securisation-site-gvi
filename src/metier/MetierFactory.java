package metier;

/**
 * @author ragotalexis
 * @author
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
