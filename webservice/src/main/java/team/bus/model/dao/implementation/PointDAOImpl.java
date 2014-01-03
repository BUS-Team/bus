package team.bus.model.dao.implementation;

import team.bus.model.dao.PointDAO;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;

public class PointDAOImpl implements PointDAO {
    private final static Map<Integer, JsonObject> points = 
            Maps.newLinkedHashMap();
    
    @Override
    public Collection<JsonObject> getAll() {
        JsonObject jo1 = Json.createObjectBuilder()
                .add("id", "1")
                .add("nome", "RU").build();        
        
        JsonObject jo2 = Json.createObjectBuilder()
                .add("id", "2")
                .add("nome", "CCB").build();
        
        JsonObject jo3 = Json.createObjectBuilder()
                .add("id", "3")
                .add("nome", "CCH").build();
        
        PointDAOImpl.points.put(1, jo1);
        PointDAOImpl.points.put(2, jo2);
        PointDAOImpl.points.put(3, jo3);
        
        return points.values();
    }
}
