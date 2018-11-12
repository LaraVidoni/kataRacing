package fr.unilim.kataRacing;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;

    public Alarm(Sensor sensor) {
    	this.sensor = sensor;
    }
    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (pressureLow(psiPressureValue) || pressureHigh(psiPressureValue))
        {
            alarmOn = true;
        }
    }
	private boolean pressureHigh(double psiPressureValue) {
		return HighPressureThreshold < psiPressureValue;
	}
	private boolean pressureLow(double psiPressureValue) {
		return psiPressureValue < LowPressureThreshold;
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}