package metier;

/**
 * @author ragotalexis
 * @author
 * @author
 * @author
 */

public class MetierFactory {
    
    private static BorneAccesService borneAccesSrv = new BorneAccesServiceImpl();
    
    
    public static BorneAccesService getBorneAccesService() {
        return borneAccesSrv;
    }
}
