/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CameraDriverSonyImpl implements CameraDriver {

    private String protocol = "http://";
    private String visu = "/mjpeg?speed=50";
    private String piloter = "";
    private Camera camera;
    private String ip;

    CameraDriverSonyImpl(Camera camera) {
        this.camera = camera;
    }

    @Override
    public String getVideo() throws Exception {
        return this.protocol + this.camera.getIp() + this.visu;
    }

    @Override
    public String piloterCameraGauche() throws Exception {
        URL u = new URL("http://"+ip+"/command/ptzf.cgi?Move=left,8");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public String piloterCameraDroite() throws Exception {
        URL u = new URL("http://"+ip+"/command/ptzf.cgi?Move=right,8");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public String piloterCameraHaut() throws Exception {
        URL u = new URL("http://"+ip+"/command/ptzf.cgi?Move=up,8");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public String piloterCameraBas() throws Exception {
        URL u = new URL("http://"+ip+"/command/ptzf.cgi?Move=down,8");
        URLConnection connection = (URLConnection) u.openConnection();
        return null;
    }

    @Override
    public byte[] prendrePhoto() throws Exception {
        this.ip = this.camera.getIp();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //fos = new FileOutputStream("/home/blondellemarvin/Bureau/photo.jpg");
        DefaultHttpClient client2 = new DefaultHttpClient();
        HttpGet request2 = new HttpGet("http://" + this.ip + "/oneshotimage.jpg");
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
