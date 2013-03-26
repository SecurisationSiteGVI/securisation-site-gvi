/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saturne
 */
public class SmsServiceImpl implements SmsService, Observer{
  

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void startThread() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
