package lab6;

public class FromSocket extends ElectricalDevice {
    private boolean isPowerOn;
    private int power;

    public FromSocket(String name, int electromagneticRadiation, int power, boolean isPowerOn) {
        super(name, electromagneticRadiation);
        this.power = power;
        this.isPowerOn = isPowerOn;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int newPower) {
        this.power = newPower;
    }

    public boolean getIsPowerOn() {
        return this.isPowerOn;
    }
}
