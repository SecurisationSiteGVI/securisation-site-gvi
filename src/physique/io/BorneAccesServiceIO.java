package physique.io;

/**
 *
 * @author ragotalexis
 *
 */
import metier.entitys.BorneAcces;

/**
 *
 * @author ragotalexis
 */
public interface BorneAccesServiceIO {

    public Trame getTrame() throws Exception;

    public void ouvrirPorte(BorneAcces borneAcces) throws Exception;

    public Trame read() throws Exception;

    public void run() throws Exception;

    public void stop() throws Exception;

    public void connection() throws Exception;
}
