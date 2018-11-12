package fr.unilim.kataRacing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.when;

public class AlarmTest{

	
	@Test
	public void isAlarmOnWhenPressureLow() {
		Sensor sensor = sensorSensoring(16.0);
		
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
	}
	
	
	@Test
	public void isAlarmOnWhenPressureHigh() {
		Sensor sensor = sensorSensoring(22.0);
		
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
	}
	
	@Test
	public void isAlarmOnWhenPressureThreshold() {
		Sensor sensor = sensorSensoring(17.0);
		
		Alarm alarm = new Alarm(sensor);
		
		alarm.check();
		assertEquals(alarm.isAlarmOn(), false);
	}
	
	@Test
	public void isAlarmStillOn() {
		Sensor sensor = sensorSensoring(16.0);
		
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
		
		sensor = sensorSensoring(20.0);
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
	}
	private Sensor sensorSensoring(double value) {
		Sensor sensor = mock(Sensor.class);
		when(sensor.probePressureValue()).thenReturn(value);
		return sensor;
	}
}
