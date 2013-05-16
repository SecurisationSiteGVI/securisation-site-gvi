package physique.io;

import metier.entitys.Camera;

/**
 *
 * @author marvin
 */
public interface CameraDriver {

    public String getVideo() throws Exception;

    public String piloterCameraGauche() throws Exception;

    public String piloterCameraDroite() throws Exception;

    public String piloterCameraHaut() throws Exception;

    public String piloterCameraBas() throws Exception;
    public boolean piloterAutomatiquement() throws Exception;

    public boolean zoom() throws Exception;
    public boolean luminositer()throws Exception;
    public boolean contraste() throws Exception;
    public boolean resolution() throws Exception;
    public byte[] prendrePhoto() throws Exception;
    
    public boolean detectionMouvement() throws Exception;

    public boolean sensPriseDeVueHorrizontal() throws Exception;
    public boolean sensPriseDeVueVertical() throws Exception;
    
    public void visionModeUneCamera() throws Exception;
    public void visionModeQuatreCamera() throws Exception;
    public void visionModeNeufCamera() throws Exception;
    
    public int connectionCamera() throws Exception;
    public void verifierConnectionCamera() throws Exception;
    public void enregistrerPhoto() throws Exception;
    
    public Camera getCamera();
}
