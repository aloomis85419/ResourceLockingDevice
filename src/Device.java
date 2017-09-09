/**
*  Resource-locking device with circular storage.
*  @author API: Dr. Jody Paul
*  @author Implementation: Aaron L, Joe M, Vicky L, Erin G, Jaziel P
*  @version API: 1.2.4 Implementation: 1.0
*  @see <a href="../projectDescription.html">Project Description</a>
*/
public class Device extends Object 
{
    
    /** Default number of bits to reveal per peek. */
    public static int DEFAULT_PEEKS;
    /** Default number of bits stored. */
    public static int DEFAULT_SIZE;
    /** Character indicator of false. */
    public static char VALUE_FALSE;
    /** Character indicator of true. */
    public static char VALUE_TRUE;    

    /**
    * Construct device using defaults.
    */
    public Device()
    {

    }
  
    /**
    * Construct device with specified bits for testing.
    * Initial bit values are represented by an array of boolean primitives.
    * @param initialBits the bit values for this test device.   
    * @param bitsPerPeek the number of bits to disclose per peek or set via poke
    */
    public Device(boolean[] initialBits, int bitsPerPeek)
    {

    }

    /**
    * Construct a device with specified size and number of peek/poke bits.
    * @param size the number of bits stored in this device.
    * @param bitsPerPeek the number of bits to disclose via peek or set via poke.
    */
    public Device(int size, int bitsPerPeek)
    {

    }
    
    /**
    * Initiate device rotation
    * @return true if all bits have identical pattern; false otherwise.
    */
    public boolean spin()
    {
    	return false;
    }

    /**
    * Peek at bits of device.
    * @param pattern indicating which bits show as '?'
    * @return a pattern that discloses the value of the indicated bits.
    */
    public CharSequence peek(CharSequence pattern)
    {
    	return null;
    }
 
    /**
    * Poke bits into device.
    * @param pattern indicator of values of bits to poke
    */
    public void poke(CharSequence pattern)
    {

    }

    /**
    * Render device information as a string.
    * @return rendering that reveals partial string
    */
    @Override
    public String toString()
    {
    	return null;
    }
}
