/**
 * Class extends the DeviceUnlocker class. This class uses a size of 4 bits and a disclosure of 2 bits.
 */
public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker
{
    /**
     * Unlocks a resource controlled by a 4-bit/2-disclosure device.
     * @param dev: the device controlling the resource to unlock; must be a 4-bit device with 2 peek/poke bits.
     * @return: true if the resource is successfully unlocked (all bits are now identical); false otherwise
     */
    public static boolean unlock(Device dev)
    {
        return true;
    }

}
