package metier;

import java.util.List;
import metier.entitys.Camera;

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
    
    
}
