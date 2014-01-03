package team.bus.JDBCDAO;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

public class PointJDBCDAO {
    private final static Map<Integer, JsonObject> points = 
            Maps.newLinkedHashMap();
    
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
        
        PointJDBCDAO.points.put(1, jo1);
        PointJDBCDAO.points.put(2, jo2);
        PointJDBCDAO.points.put(3, jo3);
        
        return points.values();
    }
}
