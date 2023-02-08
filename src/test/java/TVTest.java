import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TVTest {

    @Test
    void toggleOnOff() {
        TV tv = new TV();  //tv not on
        assertFalse(tv.isOn());

        tv.toggleOnOff();  //tv on
        assertTrue(tv.isOn());

        tv.toggleOnOff();  //tv not on
        assertFalse(tv.isOn());

        tv.toggleOnOff();  //tv on
        assertTrue(tv.isOn());
    }

    @Disabled
    @Test
    void volumeUpTvNotOn() {
        TV tv = new TV();
        assertFalse(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

        //volume shouldn't increase if tv is not on
        tv.volumeUp();

        // tv still off and volume is 0
        assertFalse(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());
    }


    @Disabled
    @Test
    void volumeUpTvOn() {
        TV tv = new TV();
        //turn tv on
        tv.toggleOnOff();
        assertTrue(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

        //increase volume
        tv.volumeUp();
        assertTrue(tv.isOn());
        assertEquals(1, tv.getVolume());

        //increase volume
        tv.volumeUp();
        assertTrue(tv.isOn());
        assertEquals(2, tv.getVolume());

        //turn off, volume shouldn't increase
        tv.toggleOnOff();
        assertFalse(tv.isOn());
        tv.volumeUp();
        assertFalse(tv.isOn());
        assertEquals(2, tv.getVolume());

    }


    @Disabled
    @Test
    void volumeUpMaxThreshold() {
        TV tv = new TV();
        //turn tv on
        tv.toggleOnOff();
        assertTrue(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

        //turn the volume to the maximum level
        for (int i=0;i<TV.MAX_VOLUME;i++) {
            tv.volumeUp();
        }
        assertEquals(TV.MAX_VOLUME, tv.getVolume());

        //volume should not exceed MAX_VOLUME
        tv.volumeUp();
        assertEquals(TV.MAX_VOLUME, tv.getVolume());

    }


    @Disabled
    @Test
    void volumeDownTvNotOn() {
        TV tv = new TV();
        assertFalse(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

        //volume shouldn't decrease if tv is off
        tv.volumeDown();

        // tv still off and volume is 0
        assertFalse(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());
    }

    @Disabled
    @Test
    void volumeDownTvOn() {
        TV tv = new TV();
        //turn tv on
        tv.toggleOnOff();
        assertTrue(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

        tv.volumeUp();
        tv.volumeUp();
        assertEquals(2, tv.getVolume());

        tv.volumeDown();
        assertEquals(1, tv.getVolume());

        tv.volumeDown();
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

        // volume should not go below min
        tv.volumeDown();
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

    }

    @Disabled
    @Test
    void volumeDownMinThreshold() {
        TV tv = new TV();
        //turn tv on
        tv.toggleOnOff();
        assertTrue(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

        //volume should not go below MIN_VOLUME
        tv.volumeDown();
        assertTrue(tv.isOn());
        assertEquals(TV.MIN_VOLUME, tv.getVolume());

    }


    @Disabled
    @Test
    void setChannelTVNotOn() {
        TV tv = new TV();
        assertFalse(tv.isOn());
        assertEquals(TV.MIN_CHANNEL, tv.getChannel());

        //channel shouldn't change if tv is not on
        tv.setChannel(5);

        // tv still off and channel is 1
        assertFalse(tv.isOn());
        assertEquals(TV.MIN_CHANNEL, tv.getChannel());
    }


    @Disabled
    @Test
    void setChannelTVOn() {
        TV tv = new TV();
        assertFalse(tv.isOn());
        assertEquals(TV.MIN_CHANNEL, tv.getChannel());

        tv.toggleOnOff();
        assertTrue(tv.isOn());

        //change channel
        tv.setChannel(5);
        assertEquals(5, tv.getChannel());

        tv.setChannel(TV.MAX_CHANNEL);
        assertEquals(TV.MAX_CHANNEL, tv.getChannel());

        //exceeds max, don't change channel
        tv.setChannel(TV.MAX_CHANNEL+1);
        assertEquals(TV.MAX_CHANNEL, tv.getChannel());

        tv.setChannel(TV.MIN_CHANNEL);
        assertEquals(TV.MIN_CHANNEL, tv.getChannel());

        //below min, don't change channel
        tv.setChannel(TV.MIN_CHANNEL-1);
        assertEquals(TV.MIN_CHANNEL, tv.getChannel());

    }
}