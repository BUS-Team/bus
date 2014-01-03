package team.bus.resource;

import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import team.bus.model.bean.Point;

@Path("points")
@Produces(MediaType.APPLICATION_JSON)
public class PointResource {
    @GET
    public List<Point> getAll() {
        
        
        Point p = new Point();
        p.setId(1);
        p.setName("RU");

        Point p1 = new Point();
        p1.setId(2);
        p1.setName("CCH");

        Point p2 = new Point();
        p2.setId(1);
        p2.setName("RU");
        List points = new ArrayList();
        
        points.add(p1);
        points.add(p2);
        
        return points;
    }
}
