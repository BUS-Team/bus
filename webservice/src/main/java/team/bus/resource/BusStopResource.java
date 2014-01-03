package team.bus.resource;

import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import team.bus.model.bean.BusStop;
import team.bus.model.dao.BusStopDAO;
import team.bus.model.dao.implementation.BusStopDAOImpl;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("pontos")
@Produces(MediaType.APPLICATION_JSON)
public class BusStopResource {    
    private final BusStopDAO busStop = 
            new BusStopDAOImpl(new ArrayList<BusStop>());
            
    @GET
    public List<BusStop> getAll() throws SQLException {
        return this.busStop.getAll();
    }
}