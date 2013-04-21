package metier;

import java.util.List;
import metier.entitys.Camera;
import metier.entitys.Position;

/**
 *
 * @author damien
 * @author BlondelleMarvin
 *
 */
public interface CameraService {

    public void add(Camera camera) throws Exception;

    public void update(Camera camera) throws Exception;

    public void remove(Camera camera) throws Exception;

    public List<Camera> getAll() throws Exception;

    public boolean piloterCameraGauche() throws Exception;

    public boolean piloterCameraDroite() throws Exception;

    public boolean piloterCameraHaut() throws Exception;

    public boolean piloterCameraBas() throws Exception;

    public boolean piloterAutomatiquement() throws Exception;

    public boolean zoom() throws Exception;

    public boolean luminositer() throws Exception;

    public boolean contraste() throws Exception;

    public boolean resolution() throws Exception;

    public byte[] prendrePhoto(Camera camera) throws Exception;

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

    public Long count();

    public List<Camera> getByPosition(Position position);

    public List<Camera> getAll(int index, int nbResult);

    public Camera getById(Long id);
}
