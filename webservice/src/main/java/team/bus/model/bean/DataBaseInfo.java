package team.bus.model.bean;

public class DataBaseInfo {
    private String user = null;
    private String password = null;
    private String dataBase = null;
    private String host = null;
    private int port = 5432;

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        if (user.isEmpty()) 
            throw new IllegalArgumentException("The field user in DataBaseInfo"
                    + "shouldn't be empty.");
        this.user = user;
    }

    public DataBaseInfo withUser(String user) {
        this.setUser(user);
        return this;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataBaseInfo withPassword(String password) {
        this.setPassword(password);
        return this;
    }
    
    public String getDataBase() {
        return this.dataBase;
    }

    public void setDataBase(String dataBase) {
        if (dataBase.isEmpty())
            throw new IllegalArgumentException("The field dataBase in "
                    + "DataBaseInfo shouldn't be empty.");
        this.dataBase = dataBase;
    }

    public DataBaseInfo withDataBase(String dataBase) {
        this.setDataBase(dataBase);
        return this;
    }
    
    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        if (host.isEmpty())
            throw new IllegalArgumentException("The field host in "
                    + "DataBaseInfo shouldn't be empty.");
        this.host = host;
    }
    
    public DataBaseInfo withHost(String host) {
        this.setHost(host);
        return this;
    }
    
    public int getPort() {
        return this.port;
    }
    
    private final static int FIRST_REGISTERED_PORT = 1024;
    
    public void setPort(int port) {
        if (port < DataBaseInfo.FIRST_REGISTERED_PORT)
            throw new IllegalArgumentException("Invalid port.");
        this.port = port;
    }
    
    public DataBaseInfo withPort(int port) {
        this.setPort(port);
        return this;
    }
}