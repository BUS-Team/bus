package br.com.bus;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestMainAndroid {

	@Test
	public void oneEqualsOne(){
		assertThat(1, equalTo(1));
	}
	
}
