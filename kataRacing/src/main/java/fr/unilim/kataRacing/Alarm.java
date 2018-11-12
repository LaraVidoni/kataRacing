package fr.unilim.kataRacing;

public class Alarm {
	private final double LowPressureThreshold = 17;
	private final double HighPressureThreshold = 21;

	Sensor sensor = new Sensor();

	boolean alarmOn;

	public Alarm() {
	}

	public Alarm(Sensor sensor) {
		this.sensor = sensor;
		this.alarmOn = false;
	}

	public void check() {
		double psiPressureValue = sensor.probePressureValue();

		if (pressureNotGood(psiPressureValue)) {
			setAlarmOn();
		}
	}

	private void setAlarmOn() {
		alarmOn = true;
	}

	private boolean pressureNotGood(double psiPressureValue) {
		return pressureLow(psiPressureValue) || pressureHigh(psiPressureValue);
	}

	private boolean pressureHigh(double psiPressureValue) {
		return HighPressureThreshold < psiPressureValue;
	}

	private boolean pressureLow(double psiPressureValue) {
		return psiPressureValue < LowPressureThreshold;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}