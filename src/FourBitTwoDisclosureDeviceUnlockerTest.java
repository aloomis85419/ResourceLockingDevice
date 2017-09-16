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
   private String traceValue = "";
    
   // Test case 1.1.1
    @Test
    public void testUnlockedDevice1111() {
        bitArray[0] = true;
        bitArray[1] = true;
        bitArray[2] = true;
        bitArray[3] = true;
        System.out.println("Test Case 1.1.1 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.1.2
    @Test
    public void testUnlockedDevice1121() {
        bitArray[0] = false;
        bitArray[1] = false;
        bitArray[2] = false;
        bitArray[3] = false;
        System.out.println("Test Case 1.1.2 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }

   // Test case 1.2.1.1
    @Test
    public void testAllButOneUnlocked1211() {
        bitArray[0] = true;
        bitArray[1] = true;
        bitArray[2] = true;
        bitArray[3] = false;
        System.out.println("Test Case 1.2.1.1 ");
    	Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
	    FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
	    assertThat(testUnlocker.unlock(testDevice), is(true));
   }
    
    // Test case 1.2.1.2
    @Test
    public void testAllButOneUnlocked1212() {
        bitArray[0] = true;
        bitArray[1] = true;
        bitArray[2] = false;
        bitArray[3] = true;
        System.out.println("Test Case 1.2.1.2 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.2.1.3
    @Test
    public void testAllButOneUnlocked1213() {
        bitArray[0] = true;
        bitArray[1] = false;
        bitArray[2] = true;
        bitArray[3] = true;
        System.out.println("Test Case 1.2.1.3 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.2.1.4
    @Test
    public void testAllButOneUnlocked1214() {
        bitArray[0] = false;
        bitArray[1] = true;
        bitArray[2] = true;
        bitArray[3] = true;
        System.out.println("Test Case 1.2.1.4 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.3.1.1
    @Test
    public void testAlternatingBits1311() {
        bitArray[0] = true;
        bitArray[1] = false;
        bitArray[2] = true;
        bitArray[3] = false;
        System.out.println("Test Case 1.3.1.1 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.3.1.2
    @Test
    public void testAlternatingBits1312() {
        bitArray[0] = false;
        bitArray[1] = true;
        bitArray[2] = false;
        bitArray[3] = true;
        System.out.println("Test Case 1.3.1.2 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.3.2.1
    @Test
    public void testAlternatingBits1321() {
        bitArray[0] = true;
        bitArray[1] = false;
        bitArray[2] = false;
        bitArray[3] = true;
        System.out.println("Test Case 1.3.2.1 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.3.2.2
    @Test
    public void testAlternatingBits1322() {
        bitArray[0] = false;
        bitArray[1] = true;
        bitArray[2] = true;
        bitArray[3] = false;
        System.out.println("Test Case 1.3.2.2 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }

    
   // Test case 1.3.3.1
    @Test
    public void testTwoTrueTwoFalse1331() {
        bitArray[0] = true;
        bitArray[1] = true;
        bitArray[2] = false;
        bitArray[3] = false;
        System.out.println("Test Case 1.3.3.1 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.3.3.2
    @Test
    public void testTwoTrueTwoFalse1332() {
        bitArray[0] = false;
        bitArray[1] = false;
        bitArray[2] = true;
        bitArray[3] = true;
        System.out.println("Test Case 1.3.3.2 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }
    
    // Test case 1.4 - Testing when Spin Count Maximum is reached
    @Test
    public void testTwoTrueTwoFalse14() {
        bitArray[0] = false;
        bitArray[1] = true;
        bitArray[2] = false;
        bitArray[3] = true;
        System.out.println("Test Case 1.4 ");
        Device testDevice = new Device(bitArray, DISCLOSURE_BITS);
        FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
        // testUnlocker.unlock(testDevice);
        assertThat(testUnlocker.unlock(testDevice), is(true));
    }

}
