public class Light implements Bright,CanTurnOff,CanTurnOn {
    @Override
    public void light() {

    }

    @Override
    public boolean turnOff() {
        return false;
    }

    @Override
    public boolean turnOn() {
        return false;
    }
}
