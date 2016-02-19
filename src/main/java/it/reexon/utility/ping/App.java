package it.reexon.utility.ping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


/**
 * Hello world!
 *
 */
public class App
{
    public static final int SECONDS_ONE_DAY = 86400;

    public static void main(String[] args)
    {

        final String PING_INTEVAL_SECONDS = "1";

        String ip = "www.google.it";

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
            while ((inputLine = reader.readLine()) != null && c < SECONDS_ONE_DAY)
            {
                c++;
                Date date = new Date();
                String message = createMessage(inputLine, date);

                System.out.println(message);
                writer.newLine();
                writer.write(message);
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

    private static String createMessage(String inputLine, Date date)
    {
        StringBuilder message = new StringBuilder();
        message.append(date + " ");
        message.append(inputLine);

        return message.toString();
    }

}
