package physique.io;

/**
 *
 * @author marvin
 */

public interface CameraServiceIO {
    

    public boolean piloterCameraGauche() throws Exception;
    public boolean piloterCameraDroite() throws Exception;
    public boolean piloterCameraHaut() throws Exception;
    public boolean piloterCameraBas() throws Exception;
    public boolean piloterAutomatiquement() throws Exception;
   
    public boolean zoom() throws Exception;
    public boolean luminositer()throws Exception;
    public boolean contraste() throws Exception;
    public boolean resolution() throws Exception;
    public byte[] prendrePhoto() throws Exception;
    
    public boolean detectionMouvement() throws Exception;
    public int[] choixCamera() throws Exception;

    public boolean sensPriseDeVueHorrizontal() throws Exception;
    public boolean sensPriseDeVueVertical() throws Exception;
    
    public void visionModeUneCamera() throws Exception;
    public void visionModeQuatreCamera() throws Exception;
    public void visionModeNeufCamera() throws Exception;
    
    public int connectionCamera() throws Exception;
    public void verifierConnectionCamera() throws Exception;
    public void enregistrerPhoto() throws Exception;

    
    
    
    
    
    
}
