package team.bus.model.bean;

public class DataBaseInfo {
    private String user;
    private String password;
    private String dataBase;
    private String host;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        if (user.isEmpty()) 
            throw new IllegalArgumentException("The field user in DataBaseInfo"
                    + "shouldn't be empty.");
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        if (dataBase.isEmpty())
            throw new IllegalArgumentException("The field dataBase in "
                    + "DataBaseInfo shouldn't be empty.");
        this.dataBase = dataBase;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        if (host.isEmpty())
            throw new IllegalArgumentException("The field host in "
                    + "DataBaseInfo shouldn't be empty.");
        this.host = host;
    }   
}
