package fr.unilim.kataRacing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.when;

public class AlarmTest{

	
	@Test
	public void isAlarmOnWhenPressureLow() {
		PressureSensor sensor = sensorSensoring(16.0);
		
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertEquals( true,alarm.isAlarmOn());
	}
	
	
	@Test
	public void isAlarmOnWhenPressureHigh() {
		PressureSensor sensor = sensorSensoring(22.0);
		
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}
	
	@Test
	public void isAlarmOnWhenPressureThreshold() {
		PressureSensor sensor = sensorSensoring(17.0);
		
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertEquals(false,alarm.isAlarmOn() );
	}
	
	@Test
	public void isAlarmStillOn() {
		PressureSensor sensor = sensorSensoring(16.0);
		
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertEquals( true,alarm.isAlarmOn());
		
		sensor = sensorSensoring(20.0);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}
	private PressureSensor sensorSensoring(double value) {
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.probeValue()).thenReturn(value);
		return sensor;
	}
}
