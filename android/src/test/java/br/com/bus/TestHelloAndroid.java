package br.com.bus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(RobolectricTestRunner.class)
public class TestHelloAndroid {

	@Test
	public void oneEqualsOne(){
		assertThat(1, equalTo(1));
	}
	
}
