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
 */
public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker
{
    private static final int MAX_SPIN_COUNT = 10000;
    private static final String PATTERN = "??--";
    private static String pokePattern = "TT--";
    private static char unlockValue = 'T';
    private static int spinCount = 0;

    /**
     * Unlocks a resource controlled by a 4-bit/2-disclosure device.
	 *
     * @param dev: the device controlling the resource to unlock; must be a 4-bit device with 2 peek/poke bits.
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
        return unlocked;
    }

	/**
	 * Helper method to check if device starts out unlocked.
	 * Method also modifies poke pattern based on results of first peek.
	 *
	 * @param initDevice Device passed to unlock method
	 * @return true if initDevice is unlocked, false if device is locked
	 */
    private static boolean init(final Device initDevice) {
        boolean unlockStatus = initDevice.spin();
        spinCount++;
        log("spin(): spinCount = " + spinCount);

        if (unlockStatus == true) {
            return true;
        } else {
            CharSequence initialPattern = initDevice.peek("??--");
            log("peek(): [??--].");

            if (initialPattern.equals("FF--")) {
                toggleUnlockValue();
                pokePattern = "FF--";
            }
            return false;
        }
    }

    private static void toggleUnlockValue() {
        if (unlockValue == 'T') {
            unlockValue = 'F';
        } else if (unlockValue == 'F') {
            unlockValue = 'T';
        }
    }

    public static void main(String[]args)
    {

       unlock(new Device(4,2));


    }
}
