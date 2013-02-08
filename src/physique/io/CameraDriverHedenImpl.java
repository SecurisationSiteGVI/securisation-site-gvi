package physique.io;

import metier.entitys.Camera;

/**
 *
 * @author marvin
 */
public class CameraDriverHedenImpl implements CameraDriver {

    private String protocol = "http://";
    private String visu = "/videostream.cgi?user=admin&pwd=marvin&resolution=32";
    private String piloter = "/decoder_control.cgi?user=admin&pwd=marvin&onestep=1&command=";
    private Camera camera;

    CameraDriverHedenImpl(Camera camera) {
        this.camera = camera;
    }

    @Override
    public String piloterCameraGauche() throws Exception {
        return this.protocol + this.camera.getIp() + this.piloter + "4";
    }

    @Override
    public String getVideo() throws Exception {
        return this.protocol + this.camera.getIp() + this.visu;
    }

    @Override
    public String piloterCameraDroite() throws Exception {
        return this.protocol + this.camera.getIp() + this.piloter + "6";
    }

    @Override
    public String piloterCameraHaut() throws Exception {
       return this.protocol + this.camera.getIp() + this.piloter + "0";
    }

    @Override
    public String piloterCameraBas() throws Exception {
       return this.protocol + this.camera.getIp() + this.piloter + "2";
    }
}
