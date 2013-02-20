/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import metier.entitys.Camera;

/**
 *
 * @author marvin
 */
public class CameraDriverSonyImpl implements CameraDriver{

    private String protocol = "http://";
    private String visu = "/videostream.cgi?user=admin&pwd=marvin&resolution=32";
    private String piloter = "/decoder_control.cgi?user=admin&pwd=marvin&onestep=1&command=";
    private Camera camera;

    CameraDriverSonyImpl(Camera camera) {
        this.camera = camera;
    }
    @Override
    public String getVideo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String piloterCameraGauche() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String piloterCameraDroite() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String piloterCameraHaut() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String piloterCameraBas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public byte[] prendrePhoto() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
