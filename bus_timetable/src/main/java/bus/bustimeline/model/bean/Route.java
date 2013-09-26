package bus.bustimeline.model.bean;

/**
 *
 * @author vinicius
 */
public class Route {
    private int busId;
    
    private String origin;
    
    private String destination;
    
    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
}
