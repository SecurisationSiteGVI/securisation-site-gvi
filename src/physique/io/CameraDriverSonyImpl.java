/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
}
