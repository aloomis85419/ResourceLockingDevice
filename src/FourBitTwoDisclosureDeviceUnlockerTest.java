import org.junit.jupiter.api.Test;

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
    
   // Test case 1.1
    @Test
    public void testUnlockedDevice() {
        Device testDevice = new Device([true, true, true, true], DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(), is(true));
    }

   // Test case 1.2
    @Test
    public void testAllButOneUnlocked() {
    	Device testDevice = new Device([true, true, true, false], DISCLOSURE_BITS);
	FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDiscloureDeviceUnlocker();
	assertThat(testUnlocker.unlock(). is(false));     
   }
    
   // Test case 1.3
    @Test
    public void testTwoTrueTwoFalse() {
        Device testDevice = new Device([true, true, false, false], DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(), is(false));
    }

   // Test case 1.4
    @Test
    public void testAlternatingBits() {
        Device testDevice = new Device([true, false, true, false], DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(), is(false));
    }

   // Test case 1.5.1.1
    @Test
    public void testTooManyDeviceBits() {
        Device testDevice = new Device ([true, true, true, true, true, true, true, true, true, true], DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(), is(false));
    }
    
   // Test case 1.5.1.2
    @Test
    public void testTooFewDeviceBits() {
        Device testDevice = new Device ([true, true], DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        assertThat(testUnlocker.unlock(), is(false));        
   }
}
