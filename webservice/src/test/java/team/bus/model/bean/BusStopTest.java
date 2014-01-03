package team.bus.model.bean;

import org.junit.Test;
import static org.junit.Assert.*;

public class BusStopTest {
    
    public BusStopTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        BusStop instance = new BusStop();        
        int expResult = 307;
        instance.setId(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIdNegative() {
        System.out.println("setIdNegative");
        int id = -1;
        BusStop instance = new BusStop();
        instance.setId(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIdEqualsZero() {
        System.out.println("setIdEqualsZero");
        int id = 0;
        BusStop instance = new BusStop();
        instance.setId(id);
    }
    
    @Test
    public void testGetName() {
        System.out.println("getName");
        BusStop instance = new BusStop();        
        String expResult = "glubsglubs";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameWithBigLenght() {
        System.out.println("setNameWithBigLenght");                
        String name = 
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; //lenght = 31, permited = 30
        BusStop instance = new BusStop();
        instance.setName(name);
    }    
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetNameWithEmptyName() {
        System.out.println("setNameWithEmptyName");                
        String name = "";
        BusStop instance = new BusStop();
        instance.setName(name);
    }        
}