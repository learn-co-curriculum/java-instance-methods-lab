import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TVTest {

    private TV tv;

    @BeforeEach
    void setUp() {
        tv = new TV();  //tv not on
    }

    @Test
    void toggleOnOff() {
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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
        // tv was instantiated in setUp method

        assertFalse(tv.isOn()); //tv not on

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

    @Disabled
    @Test
    void multipleTVsDifferentState() {
        TV sony = new TV();
        TV vizio = new TV();

        assertFalse(sony.isOn()); //not on
        assertFalse(vizio.isOn()); //not on

        // Add the appropriate code for each comment below

        // Turn the sony on

        // Assert that sony is on

        // Set sony channel to 50

        // Assert the sony channel is 50

        // Turn sony volume up

        // Turn sony volume up again

        // Assert sony volume is 2

        // Turn vizio volume up  (don't turn it on, so volume should not change)

        // Set vizio channel to 40 (don't turn it on, so channel should not change)

        // Assert vizio is not on

        // Assert vizio channel is minimum value

        // Assert vizio volume is minimum value

    }
}