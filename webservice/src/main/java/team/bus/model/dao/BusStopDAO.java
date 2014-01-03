package team.bus.model.dao;

import java.util.Collection;
import javax.json.JsonObject;

public interface BusStopDAO {
    Collection<JsonObject> getAll();    
}
