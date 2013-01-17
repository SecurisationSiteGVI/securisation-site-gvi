package physique.io;

/**
 *
 * @author marvin
 */

public interface CameraServiceIO {
    

    public void piloterCameraGauche() throws Exception;
    public void piloterCameraDroite() throws Exception;
    public void piloterCameraHaut() throws Exception;
    public void piloterCameraBas() throws Exception;
    public void piloterAutomatiquement() throws Exception;
   
    public void zoom() throws Exception;
    public void luminositer()throws Exception;
    public void contraste() throws Exception;
    public void resolution() throws Exception;
    public void prendrePhoto() throws Exception;
    public void detectionMouvement() throws Exception;
    public void choixCamera() throws Exception;

    public void sensPriseDeVueHorrizontal() throws Exception;
    public void sensPriseDeVueVertical() throws Exception;
    
    public void visionModeUneCamera() throws Exception;
    public void visionModeQuatreCamera() throws Exception;
    public void visionModeNeufCamera() throws Exception;
    
    public void connectionCamera() throws Exception;
    public void verifierConnectionCamera() throws Exception;
    public void enregistrerPhoto() throws Exception;

    
    
    
    
    
    
}
