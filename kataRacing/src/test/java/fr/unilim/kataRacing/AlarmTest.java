package fr.unilim.kataRacing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.when;

public class AlarmTest{

	@Test
	public void isAlarmOnWhenPressureLow() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
		
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
	}
}
