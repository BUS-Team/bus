package team.bus.model.dao.implementation;


public class BusTimeDAOImpl {            
    
//    public BusTimeDAOImpl(DataBaseInfo dataBaseInfo) {
//        this.dataBaseInfo = dataBaseInfo;
//    }
//            
//    private static final String TIME_BUS_STOP = 
//            "SELECT rbs.moment FROM route r" +
//                " JOIN route_has_bus_stop rbs ON (r.id = rbs.route_id)" +
//                " JOIN bus_stop bs ON (bs.id = rbs.bus_stop_id)" +
//            " WHERE r.bus_id = ?" +
//                " AND r.destination = ?" +
//                " AND bs.name LIKE ?;";
//    
//    @Override
//    public List<Time> loadTimeRouteBusStop(Route route, BusStop busStop) 
//                                                        throws SQLException {
//        List<Time> times = new ArrayList<Time>();
//        
//        Connection con = this.createConnection();
//        //create sql query
//        PreparedStatement stm = con.prepareStatement(
//                                                BusTimeDAOImpl.TIME_BUS_STOP);
//        stm.setInt(1, route.getBusId());
//        stm.setString(2, route.getDestination());
//        stm.setString(3, busStop.getName());
//        
//        ResultSet rs = stm.executeQuery();
//        while (rs.next()) {
//            Time time = rs.getTime("moment");
//            times.add(time);
//        }
//        return times;
//    }
    
}
