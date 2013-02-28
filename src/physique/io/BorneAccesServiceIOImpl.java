package physique.io;

/**
 * 
 * @author ragotalexis
 * 
 */

import gnu.io.SerialPort;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.tsiris.serialcomm.SerialCom;
import lml.tsiris.serialcomm.SerialComImpl;
import metier.entitys.Badge;
import metier.entitys.BorneAcces;


public class BorneAccesServiceIOImpl extends Observable implements BorneAccesServiceIO,Runnable{
    
    private final static byte STX = 0x02;
    private final static byte ETX = 0x03;
    public Trame trame ;
    private byte[] buffer;
    private List<Trame> frames;
    private boolean running=true;
    private SerialCom is;
    
    public BorneAccesServiceIOImpl(){
        System.out.println("Constrruct");
    }
    
    @Override
    public Trame getTrame() throws Exception {
        this.is = new SerialComImpl();
        this.is.open("/dev/ttyACM0", 9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        Thread t = new Thread(this);
        t.start();
        return trame;
    }

    @Override
    public void ouvrirPorte(BorneAcces borneAcces) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void stop() {
        this.running = false;
    }

    public Trame read() {
        Trame fr = null;
        if (!this.frames.isEmpty()) {
            fr = this.frames.remove(0);
        }
        return fr;
    }

    @Override
    public void run() {
        Trame t2 = new Trame();
        while (this.running) {
            try {
                // read and append to buffer        
                String frameLu = this.is.readLine();
                this.buffer= frameLu.getBytes();
                byte[] name = new byte[4];
                name[0] = this.buffer[13];
                name[1] = this.buffer[14];
                name[2] = this.buffer[15];
                name[3] = this.buffer[16];
                String lecteur = new String(name);
                BorneAcces b =new BorneAcces();
                b.setNom(lecteur);
                this.trame = new Trame();
                t2.setBorneAcces(b);
                System.out.println("\nLe nom du lecteur est : " + lecteur);
                byte[] num = new byte[10];
                for(int i=0; i<10; i++){
                    num[i] = this.buffer[25+i];
                }
                Badge badge = new Badge();
                badge.setNumero(new String(num));
                t2.setBadge(badge);
                this.trame = t2;
                this.setChanged();
                this.notifyObservers();
            } catch (Exception ex) {
                Logger.getLogger(BorneAccesServiceIOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
