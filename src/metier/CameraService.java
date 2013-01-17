package metier;

import java.util.List;

/**
 *
 * @author damien
 * @author BlondelleMarvin
 * 
 */
public interface CameraService {
    
        
    public void add(CameraService cameraService) throws Exception;
    public void update(CameraService cameraService) throws Exception;
    public void remove(CameraService cameraService) throws Exception;
    public List<CameraService> getAll() throws Exception;
    
    
}
