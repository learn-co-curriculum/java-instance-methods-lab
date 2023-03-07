public class TV {
    // Instance variables
    private boolean on;
    private int volume = MIN_VOLUME;
    private int channel = MIN_CHANNEL;

    // Class constants
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 10;
    public static final int MIN_CHANNEL = 1;
    public static final int MAX_CHANNEL = 100;

    // Getters are used by Junit tests
    public boolean isOn() {return on;}
    public int getVolume() {return volume;}
    public int getChannel() {return channel;}

    // Implement the following methods
    public void toggleOnOff() {

    }

    public void volumeUp() {

    }

    public void volumeDown() {

    }

    public void setChannel(int channel) {

    }

}