package team.bus.model.bean;

public class BusStop {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    private final static int MIN_ID_PERMITED = 1;
    
    public void setId(int id) {
        if (id < BusStop.MIN_ID_PERMITED)
            throw new IllegalArgumentException("BusStop id shouldn't be less "
                    + "than " + BusStop.MIN_ID_PERMITED);
        this.id = id;
    }

    public BusStop withId(int id) {
        this.setId(id);
        return this;
    }
    
    public String getName() {
        return name;
    }

    private final static int MAX_NAME_LENGHT_PERMITED = 30;
    
    public void setName(String name) {
        if (name.length() > BusStop.MAX_NAME_LENGHT_PERMITED || name.isEmpty())
            throw new IllegalArgumentException("BusStop name shouldn't be empty"
                    + " or greater than " + BusStop.MAX_NAME_LENGHT_PERMITED);
        this.name = name;
    }
    
    public BusStop withName(String name) {
        this.setName(name);
        return this;
    }
}
