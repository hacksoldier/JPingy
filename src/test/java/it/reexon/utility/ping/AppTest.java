package it.reexon.utility.ping;

import org.junit.Test;

import it.reexon.utility.ping.enums.SystemEnum;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static TestSuite suite()
    {
        return new TestSuite(AppTest.class);
    }

    @Test
    public void testPingArguments()
    {
        //@f:off
        PingArguments pingArguments = null;
        String pingCommand = null;
        
        // WINDOWS
        pingArguments = new PingArguments.Builder(SystemEnum.WINDOWS)
                .setBytes(56)
                .setCount(55)
                .setInterval(54)
                .setTimeout(36666)
                .setTtl(554)
                .setUrl("www.google.it")
            .build();
        pingCommand = pingArguments.getCommand();
        
        assertEquals("ping -n 55 -w 36666 -l 56 www.google.it", pingCommand);
        
        //UNIX
        pingArguments = new PingArguments.Builder(SystemEnum.UNIX)
                .setBytes(56)
                .setCount(55)
                .setInterval(54)
                .setTimeout(36666)
                .setTtl(554)
                .setUrl("www.google.it")
            .build();
        pingCommand = pingArguments.getCommand();
        assertEquals("ping -c 55 -W 36666 -s 56 www.google.it", pingCommand);
        //@f:on
    }
}
