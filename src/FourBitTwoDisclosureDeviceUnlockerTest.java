import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
*  DeviceUnlocker test class. Tests different variations of how the bits could be set.	
*  Checks if the device is unlocked in the case that all bits are the same, and false,
*  in every other case.
*
*  @author Team Locksmiths
*  @author Vicky Lym, Erin Gurnett, Joe Medina, Jazil Pauda, Aaron Loomis
*  @version v1.0
*/

public class FourBitTwoDisclosureDeviceUnlockerTest {

   private final int DISCLOSURE_BITS = 2;
   private boolean[] bitArray = new boolean[4];
    
   // Test case 1.1
    @Test
    public void testUnlockedDevice() {
        bitArray[0] = true;
        bitArray[1] = true;
        bitArray[2] = true;
        bitArray[3] = true;
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }

   // Test case 1.2
    @Test
    public void testAllButOneUnlocked() {
        bitArray[0] = true;
        bitArray[1] = true;
        bitArray[2] = true;
        bitArray[3] = false;
    	Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
	    FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
	    assertThat(testUnlocker.unlock(testDevice), is(false));
   }
    
   // Test case 1.3
    @Test
    public void testTwoTrueTwoFalse() {
        bitArray[0] = true;
        bitArray[1] = true;
        bitArray[2] = false;
        bitArray[3] = false;
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(testDevice), is(false));
    }

   // Test case 1.4
    @Test
    public void testAlternatingBits() {
        bitArray[0] = true;
        bitArray[1] = false;
        bitArray[2] = true;
        bitArray[3] = false;
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(testDevice), is(false));
    }

// <<<<<<< HEAD

// =======
   // Test case 1.5.1.1
    // @Test
    // public void testTooManyDeviceBits() {
    //    bitArray[0] = true;
    //    bitArray[1] = true;
    //    bitArray[2] = true;
    //    bitArray[3] = false;
    /*    Device testDevice = new Device ([true, true, true, true, true, true, true, true, true, true], DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(testDevice), is(false));
// >>>>>>> 2dad9be564044dd53922f020d0cc54fb662a66d1

    }
         */
    
   // Test case 1.5.1.2
    @Test
    public void testTooFewDeviceBits() {
        bitArray[0] = true;
        bitArray[1] = true;
        Device testDevice = new Device (bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(testDevice), is(false));
   }
}
