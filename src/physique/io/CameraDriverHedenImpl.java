package physique.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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

    @Override
    public byte[] prendrePhoto() throws Exception {
        return null;

//            ByteOutputStream bos = new ByteOutputStream();
//
//            //FileOutputStream fos = new FileOutputStream("/home/blondellemarvin/Bureau/photo.jpg");
//            URL u = new URL("http://"+this.camera.getIp()+"/snapshot.jpg?user=admin&pwd=marvin");
//            URLConnection connection = (URLConnection) u.openConnection();
//
//            InputStream is = connection.getInputStream();
//            while (is.available() > 0) {
//                byte b = (byte) is.read();
//                bos.write(b);
//              //  fos.write(b);
//
//            }
//            is.close();
//            //fos.close();
//            bos.close();
//            byte[] bytes = bos.getBytes();
        // return bytes;




    }
}
