package it.reexon.utility.ping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.junit.Test;

import it.reexon.utility.ping.enums.SystemEnum;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    private static final int NUMBER_PING = 10;
    private static final int PING_INTEVAL_SECONDS = 5;

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

    /**
     * Rigourous Test :-)
     */
    public void appTest()
    {
        String ip = "127.0.0.1";
        String pingResult = "";

        StringBuffer pingCmd = new StringBuffer("ping ");
        pingCmd.append(" -t");
        pingCmd.append(" -i " + PING_INTEVAL_SECONDS);
        pingCmd.append(" " + ip);

        BufferedReader reader = null;
        BufferedWriter writer = null;
        try
        {
            File file = new File("C:\\TEMP\\ping2.txt");
            writer = new BufferedWriter(new FileWriter(file, true));

            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd.toString());
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            int c = 0;
            while ((inputLine = reader.readLine()) != null && c < NUMBER_PING)
            {
                c++;
                Date date = new Date();
                String message = createMessage(inputLine, date);

                System.out.println(message);
                writer.newLine();
                writer.write(message);
                pingResult += message;
            }
            writer.flush();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {}
            }
            if (writer != null)
            {
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {}
            }
        }
    }

    private String createMessage(String inputLine, Date date)
    {
        StringBuilder message = new StringBuilder();
        message.append(date + " ");
        message.append(inputLine);

        return message.toString();
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

    @Test
    public void mainTest()
    {
        //        testApp();
        assertTrue(true);
    }

}
