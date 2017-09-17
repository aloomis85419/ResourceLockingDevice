/**
 * Solution development for 4-bit/2-disclosure device.
 *
 * @author Erin Gurnett
 * @author Aaron Loomis
 * @author Vicky Lym
 * @author Joseph Medina
 * @author Jaziel Pauda
 * @author Dr. Jody Paul (API)
 * @version 4.1.4
 * @see <a href="http://jodypaul.com/cs/sweprin/deviceProj/projectDescription.html">Project Description</a>
 */
public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker
{
    /** Maximum number of spins unlock algorithm is allowed to perform before aborting unlock method and returning false */
	private static final int MAX_SPIN_COUNT = 1000;

	/** Pattern used to return first two bits of Device utilizing peek method */
    private static final String PATTERN = "??--";

	/** Pattern used to set bits in register if they are not equal to unlock value, default pattern is "TT--" */
    private static String pokePattern = "TT--";

	/** Value bits are set to in order to unlock device, default value is 'T' */
    private static char unlockValue = 'T';

	/** Counter for number of spins unlock algorithm has performed */
    private static int spinCount = 0;

	/** String to catch return of showTrace method */
    private static String traceValue = "";

    /**
     * Unlocks a resource controlled by a 4-bit/2-disclosure device. Behavior is unspecified if parameter is
     * not a reference to a valid 4-bit/2-disclosure device.
     * @param dev the device controlling the resource to unlock; must be a 4-bit device with 2 peek/poke bits.
     * @return true if the resource is successfully unlocked (all bits are now identical); false otherwise
     */
    public static boolean unlock(Device dev)
    {
        boolean unlocked = init(dev);

        if (!unlocked) {
            while ((spinCount < MAX_SPIN_COUNT) && (!unlocked)) {
                unlocked = dev.spin();
                spinCount++;
                log("spin(): spincount = " + spinCount);
                if (unlocked == false) {
                    String peekResults = (String) dev.peek(PATTERN);
                    log("peek() peekResults: " + peekResults);
                    
                    // (peekResults.charAt(0) == peekResults.charAt(1)) : First two chars are equal
                    // (peekResults.charAt(0) == unlockValue): First char equals unlockValue
                    if ((peekResults.charAt(0) == peekResults.charAt(1)) && (peekResults.charAt(0) == unlockValue)) {
                        ; // Don't do anything.
                    } else {
                        dev.poke(pokePattern);
                        log("poke(): " + pokePattern);
                    }
                }
            }
        }
        if (spinCount >= MAX_SPIN_COUNT) {
            log("Maximum number of Spins reached, " + spinCount);
            log("Program has halted without an unlocked Device, " + unlocked);
        } else {
            log("Device is Unlocked.");
        }
        traceValue = showTrace();
        System.out.println("Trace Value is: ");
        System.out.println(traceValue);
        traceValue = "";
        spinCount = 0;
        log(null);
        return unlocked;
    }

    /**
     * Helper method to check if device starts out unlocked.
     * Method modifies poke pattern based on results of first peek.
     *
     * @param initDevice Device passed to unlock method
     * @return true if initDevice is unlocked, false if device is locked
     */
    private static boolean init(final Device initDevice) {
        boolean unlockStatus = initDevice.spin();
        spinCount++;
        log("spin(): spinCount = " + spinCount);

        if (unlockStatus == true) {
            log("With initial spin(), Device is unlocked.");
        } else {
            CharSequence initialPattern = initDevice.peek("??--");
            log("peek(): [??--], initial Pattern " + initialPattern);

            if (initialPattern.equals("FF--")) {
                unlockValue = 'F';
                pokePattern = "FF--";
            }
            initDevice.poke(pokePattern);
            log("poke(): " + pokePattern);
        }
        return unlockStatus;
    }
}
