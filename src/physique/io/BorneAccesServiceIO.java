package physique.io;

public interface BorneAccesServiceIO {
    public int getNumeroAcces() throws Exception;    
    public void OuvrirPorte(BorneAcces borneAcces)throws Exception;
    public void affichageLed(BorneAcces borneAcces) throws Exception;
}
