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

    @Test
    public void testFluentInterfaceWithUser() {
        System.out.println("testFluentInterfaceWithUser");
        DataBaseInfo instance = new DataBaseInfo();
        String expResult = "postgres";
        instance.withUser(expResult);
        String result = instance.getUser();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testFluentInterfaceWithPassword() {
        System.out.println("testFluentInterfaceWithPassword");
        DataBaseInfo instance = new DataBaseInfo();
        String expResult = "123456";
        instance.withPassword(expResult);
        String result = instance.getPassword();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testFluentInterfaceWithDataBase() {
        System.out.println("testFluentInterfaceWithDataBase");
        String expResult = "bus";
        DataBaseInfo instance = new DataBaseInfo();        
        instance.withDataBase(expResult);
        String result = instance.getDataBase();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testFluentInterfaceWithHost() {
        System.out.println("testFluentInterfaceWithHost");
        String expResult = "localhost";
        DataBaseInfo instance = new DataBaseInfo();
        instance.withHost(expResult);
        String result = instance.getHost();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPort() {
        System.out.println("testGetPort");
        int expResult = 5555;
        DataBaseInfo instance = new DataBaseInfo();
        instance.setPort(expResult);
        
        int result = instance.getPort();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefaultPort() {
        System.out.println("testGetDefaultPort");
        int expResult = 5432;
        DataBaseInfo instance = new DataBaseInfo();
        
        int result = instance.getPort();
        
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPortInvalid() {
        System.out.println("testSetPortInvalid");
        int expResult = 1000;
        DataBaseInfo instance = new DataBaseInfo();
        instance.setPort(expResult);        
    }    
    
    @Test
    public void testFluentInterfaceWithPort() {
        System.out.println("testFluentInterfaceWithPort");
        int expResult = 5555;
        DataBaseInfo instance = new DataBaseInfo();
        instance.withPort(expResult);        
        int result = instance.getPort();
        
        assertEquals(expResult, result);
    }
}