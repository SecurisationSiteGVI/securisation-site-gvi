package physique.io;

/**
 * @author ragotalexis
 * @author
 * @author
 * @author
 */

public class PhysiqueIOFactory {
    
    private static BorneAccesServiceIO borneAccesSrv = new BorneAccesServiceIOImpl();
    
    public BorneAccesServiceIO getBorneAccesServiceIO() {
        return this.borneAccesSrv;
    }
    
}
