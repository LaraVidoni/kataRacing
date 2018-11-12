package fr.unilim.kataRacing;

public class Alarm {
	private static final  double LowThreshold = 17;
	private static final  double HighThreshold = 21;

	PressureSensor sensor;

	boolean alarmOn;

	public Alarm() {
		this(new PressureSensor());
	}

	public Alarm(PressureSensor sensor2) {
		this.sensor = sensor2;
		this.alarmOn = false;
	}

	public void check() {
		double psiValue = sensor.probeValue();

		if (pressureNotGood(psiValue)) {
			setAlarmOn();
		}
	}

	private void setAlarmOn() {
		alarmOn = true;
	}

	private boolean pressureNotGood(double psiValue) {
		return pressureLow(psiValue) || pressureHigh(psiValue);
	}

	private boolean pressureHigh(double psiValue) {
		return HighThreshold < psiValue;
	}

	private boolean pressureLow(double psiValue) {
		return psiValue < LowThreshold;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}