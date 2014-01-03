package team.bus.model.bean;

import org.junit.Test;
import static org.junit.Assert.*;

public class DataBaseInfoTest {
    
    public DataBaseInfoTest() {
    }

    @Test
    public void testGetUser() {
        System.out.println("getUser");
        DataBaseInfo instance = new DataBaseInfo();
        String expResult = "glubsglubs";
        instance.setUser(expResult);
        String result = instance.getUser();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetUserEmpty() {
        System.out.println("setUserEmpty");
        String user = "";
        DataBaseInfo instance = new DataBaseInfo();
        instance.setUser(user);
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        DataBaseInfo instance = new DataBaseInfo();
        String expResult = "123456";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDataBase() {
        System.out.println("getDataBase");
        DataBaseInfo instance = new DataBaseInfo();
        String expResult = "bus";
        instance.setDataBase(expResult);
        String result = instance.getDataBase();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDataBaseEmpty() {
        System.out.println("setDataBaseEmpty");
        String dataBase = "";
        DataBaseInfo instance = new DataBaseInfo();
        instance.setDataBase(dataBase);
    }

    @Test
    public void testGetHost() {
        System.out.println("getHost");
        DataBaseInfo instance = new DataBaseInfo();
        String expResult = "localhost";
        instance.setHost(expResult);
        String result = instance.getHost();
        
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHostEmpty() {
        System.out.println("setHostEmpty");
        String host = "";
        DataBaseInfo instance = new DataBaseInfo();
        instance.setHost(host);
    }   
}