package team.bus.model.dao;

import java.util.Collection;
import javax.json.JsonObject;

public interface PointDAO {
    Collection<JsonObject> getAll();    
}
