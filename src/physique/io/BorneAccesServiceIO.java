package physique.io;

import metier.entitys.BorneAcces;

public interface BorneAccesServiceIO {
    public int getNumeroAcces() throws Exception;    
    public void ouvrirPorte(BorneAcces borneAcces)throws Exception;
    public void affichageLed(BorneAcces borneAcces) throws Exception;
}
