import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
*  DeviceUnlocker test class. Tests various initial bit patterns. Each bit can be set
*  to true or false. Checks if the device is unlocked when all bits in the pattern are
*  set to either all true or all false. Also, tests to determine if maximum number of
*  spins (or circular rotation of the bits) has been reached.
*
*  @author Team Locksmiths
*  @author Vicky Lym, Erin Gurnett, Joe Medina, Jazil Pauda, Aaron Loomis
*  @version v1.0
*/

public class FourBitTwoDisclosureDeviceUnlockerTest {

   private final int DISCLOSURE_BITS = 2;
   private boolean[] bitArray = new boolean[4];
   private String traceValue = "";
    
   /**
    * Test case 1.1.1 using [true, true, true, true] to verify device is unlocked.
    */
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

    @Test
    public void randomTest()
    {
	System.out.println("Random Test");
        bitArray[0] = true;
	bitArray[1] = false;
	bitArray[2] = false;
	bitArray[3] = false;
	int timesUnlocked = 0, timesNotUnlocked = 0;	

	for(int i = 0; i < 1000000; i++)
	{
		Device testDevice = new Device(bitArray, 2);
		FourBitTwoDisclosureDeviceUnlocker testUnlocker = new FourBitTwoDisclosureDeviceUnlocker();
		if(testUnlocker.unlock(testDevice) == true)
		{
			timesUnlocked++;
			System.out.println(i + ": Device unlocked");
		}
		else if(testUnlocker.unlock(testDevice) == false)
		{
			timesNotUnlocked++;
			System.out.println(i + ": Device not unlocked");
		}
	}
	
	System.out.println("Times Unlocked: " + timesUnlocked);
	System.out.println("Times couldn't unlock: " + timesNotUnlocked);
    }
    
    /**
     * Test case 1.1.2 using [false, false, false, false] to verify device is unlocked.
     */
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

    /**
     * Test case 1.2.1.1 using [true, true, true, false] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.2.1.2 using [true, true, false, true] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.2.1.3 using [true, false, true, true] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.2.1.4 using [false, true, true, true] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.3.1.1 using [true, false, true, false] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.3.1.2 using [false, true, false, true] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.3.2.1 using [true, false, false, true] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.3.2.2 using [false, true, true, false] to verify device is unlocked.
     */
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

    
    /**
     * Test case 1.3.3.1 using [true, true, false, false] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.3.3.2 using [false, false, true, true] to verify device is unlocked.
     */
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
    
    /**
     * Test case 1.4 using [false, true, false, true] to test if spin count maximum
     * is reached.  This test will require a change to the FourBitTwoDisclosureDeviceUnlocker.java
     * to decrease the MAX_SPIN_COUNT to force the message to indicate maximum reached.  Also,
     * the assert statement will need to be changed to be is(false);
     */
    @Test
    public void testSpinCountMaximumReached() {
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
