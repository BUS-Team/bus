package team.bus.model.bean;

import org.junit.Test;
import static org.junit.Assert.*;

public class BusStopTest {
    
    public BusStopTest() {
    }
    
    @Test
    public void testEqualsWithOneElementNull() {
        System.out.println("testEqualsWithOneElementNull");
        BusStop o1 = new BusStop().withId(1).withName("a");
        BusStop o2 = null;
        boolean result = o1.equals(o2);
        
        assertTrue(!result);
    }

    @Test
    public void testEqualsWithDiferentId() {
        System.out.println("testEqualsWithDiferentId");
        BusStop o1 = new BusStop().withId(1).withName("a");
        BusStop o2 = new BusStop().withId(2).withName("a");
        boolean result = o1.equals(o2);
        
        assertTrue(!result);
    }

    @Test
    public void testEqualsWithDiferentName() {
        System.out.println("testEqualsWithDiferentName");
        BusStop o1 = new BusStop().withId(1).withName("a");
        BusStop o2 = new BusStop().withId(1).withName("b");
        boolean result = o1.equals(o2);
        
        assertTrue(!result);
    }

    @Test
    public void testEqualsWithoutId() {
        System.out.println("testEqualsWithoutId");
        BusStop o1 = new BusStop().withId(1).withName("a");
        BusStop o2 = new BusStop().withName("b");
        boolean result = o1.equals(o2);
        
        assertTrue(!result);
    }

    @Test
    public void testEqualsWithoutName() {
        System.out.println("testEqualsWithoutId");
        BusStop o1 = new BusStop().withId(1).withName("a");
        BusStop o2 = new BusStop().withId(1);
        boolean result = o1.equals(o2);
        
        assertTrue(!result);
    }

    @Test
    public void testEquals() {
        System.out.println("testEquals");
        BusStop o1 = new BusStop().withId(1).withName("a");
        BusStop o2 = new BusStop().withId(1).withName("a");
        boolean result = o1.equals(o2);
        
        assertTrue(result);
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
    
    @Test
    public void testFluentInterfaceWithId() {
        System.out.println("testFluentInterfaceWithId");
        BusStop instance = new BusStop();
        int expectedId = 307;
        instance.withId(expectedId);
        int result = instance.getId();
        
        assertEquals(expectedId, result);
    }
    
    @Test
    public void testFluentInterfaceWithName() {
        System.out.println("testFluentInterfaceWithName");
        BusStop instance = new BusStop();
        String expectedName = "glubsglubs";
        instance.withName(expectedName);
        String result = instance.getName();
        
        assertEquals(expectedName, result);
    }
}