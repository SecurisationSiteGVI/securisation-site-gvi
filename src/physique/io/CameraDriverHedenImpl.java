package physique.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import metier.entitys.Camera;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author marvin
 */
public class CameraDriverHedenImpl implements CameraDriver {

    private String protocol = "http://";
    private String visu = "/videostream.cgi?user=admin&pwd=marvin&resolution=32";
    private String piloter = "/decoder_control.cgi?user=admin&pwd=marvin&onestep=1&command=";
    private Camera camera;
    private String ip;

    CameraDriverHedenImpl(Camera camera) {
        this.camera = camera;
    }

    @Override
    public String piloterCameraGauche() throws Exception {
        URL u = new URL("http://"+ip+"/decoder_control.cgi?user=admin&pwd=marvin&command=4");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public String getVideo() throws Exception {
        return this.protocol + this.camera.getIp() + this.visu;
    }

    @Override
    public String piloterCameraDroite() throws Exception {
        URL u = new URL("http://"+ip+"/decoder_control.cgi?user=admin&pwd=marvin&command=6");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public String piloterCameraHaut() throws Exception {
        URL u = new URL("http://"+ip+"/decoder_control.cgi?user=admin&pwd=marvin&command=0'");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public String piloterCameraBas() throws Exception {
        URL u = new URL("http://"+ip+"/decoder_control.cgi?user=admin&pwd=marvin&command=2");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public byte[] prendrePhoto() throws Exception {

        this.ip = this.camera.getIp();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //fos = new FileOutputStream("/home/blondellemarvin/Bureau/photo.jpg");
        DefaultHttpClient client2 = new DefaultHttpClient();
        HttpGet request2 = new HttpGet("http://" + this.ip + "/snapshot.jpg?user=admin&pwd=marvin");
        HttpResponse response2 = client2.execute(request2);
        BufferedInputStream is = new BufferedInputStream(response2.getEntity().getContent());

        byte[] buff = new byte[10240];
        int n;
        int total = 0;
        while ((n = is.read(buff)) != -1) {
            if (n >= buff.length) {
                n = buff.length - 1;
            }

            bos.write(buff, 0, n);
            //fos.write(buff, 0, n);

            total += n;

        }
        System.out.println("IMG : " + total);
        //fos.close();
        bos.close();
        is.close();

        return bos.toByteArray();
    }

    @Override
    public Camera getCamera() {
        return this.camera;
    }

    @Override
    public boolean piloterAutomatiquement() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean zoom() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean luminositer() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contraste() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean resolution() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean detectionMouvement() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean sensPriseDeVueHorrizontal() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean sensPriseDeVueVertical() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visionModeUneCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visionModeQuatreCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visionModeNeufCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int connectionCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void verifierConnectionCamera() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void enregistrerPhoto() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
