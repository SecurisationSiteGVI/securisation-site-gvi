package physique.io;


public class PhysiqueIOFactory {
    
    private static BorneAccesServiceIO borneAccesSrv = new BorneAccesServiceIOImpl();
    
    public BorneAccesServiceIO getBorneAccesServiceIO() {
        return this.borneAccesSrv;
    }
    
}
